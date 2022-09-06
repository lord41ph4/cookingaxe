package de.alpha_zone.game.cookingaxe.core

import de.alpha_zone.game.cookingaxe.universe.Figure
import de.alpha_zone.game.cookingaxe.universe.Player
import de.alpha_zone.game.cookingaxe.universe.Vector2d
import de.alpha_zone.game.cookingaxe.universe.WorldMap
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
class Arena(
	players: List<Player>,
	private val worldMap: MutableWorldMap,
	private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
	class ImmutableWrapper<T>(list: List<T>) : List<T> by list

	class MapInfo(
		val player: Player,
		private val base: WorldMap
	) : WorldMap {

		private val immutableFigures: List<Figure> get() = ImmutableWrapper(base.figures)

		override fun getFigures(): List<Figure> {
			return immutableFigures
		}

		override fun getPosition(figure: Figure?): Vector2d {
			return base.getPosition(figure)
		}

	}

	private val playerMaps: Map<Player, MapInfo> = players.associateBy({ player -> player }, { player -> MapInfo(player, this.worldMap) })
	private val moveHandler = MoveHandler(worldMap)

	fun onTick() {
		runBlocking {
			val playerActions: Map<Player, Deferred<List<Figure>>> = this@Arena.playerMaps.entries.associateBy({ entry -> entry.key }, { entry ->
				this.async(dispatcher) {
					withTimeout(2L.seconds) {
						collectActions(entry)
					}
				}
			})
			playerActions.values.awaitAll()
			for ((player, action) in playerActions) {
				this@Arena.evaluate(player, action)
			}
		}
	}

	private fun collectActions(entry: Map.Entry<Player, MapInfo>): List<Figure> {
		val figures = entry.value.figures.filter { figure -> figure.owner == entry.key }
		entry.key.think(entry.value, figures)
		return figures
	}

	private fun evaluate(player: Player, action: Deferred<List<Figure>>) {
		val actionFigures = if (action.isCompleted && action.getCompletionExceptionOrNull() == null) action.getCompleted() else null
		actionFigures?.forEach {
			val figure = it
			moveHandler.evaluate(figure)
			figure.action?.perform(player, worldMap)
		}
	}
}
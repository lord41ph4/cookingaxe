package com.axetrading.game.cookingaxe.arena

import com.axetrading.game.cookingaxe.world.Action
import com.axetrading.game.cookingaxe.world.Figure
import com.axetrading.game.cookingaxe.world.Item
import com.axetrading.game.cookingaxe.world.Player
import com.axetrading.game.cookingaxe.world.Scenario
import com.axetrading.game.cookingaxe.world.WorldMap
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class Arena(
		players: List<Player>,
		val worldMap: WorldMap,
		val scenario: Scenario
) {

	private class MapInfo(
			val player: Player,
			private val base: WorldMap
	) : WorldMap {

		override fun getItems(): List<Item> {
			TODO("Not yet implemented: not modifiable reference to base.items")
		}

		override fun getFigures(): List<Figure> {
			TODO("Not yet implemented: not modifiable reference to base.figures")
		}

	}

	private val playerMaps: Map<Player, MapInfo> = players.associateBy({ player -> player }, { player -> MapInfo(player, this.worldMap) })

	@ExperimentalCoroutinesApi
	fun onTick() {
		runBlocking {
			val playerActions: Map<Player, Deferred<Action>> = this@Arena.playerMaps.entries.associateBy({ entry -> entry.key }, { entry -> this.async(Dispatchers.Default) { entry.key.think(entry.value) } })
			Thread.sleep(20)
			for ((player, action) in playerActions) {
				this@Arena.evaluate(player, action)
			}
		}

	}

	@ExperimentalCoroutinesApi
	private fun evaluate(player: Player, action: Deferred<Action>) {
		val toExecute = if (action.isCompleted && action.getCompletionExceptionOrNull() == null) action.getCompleted() else null
		if (toExecute != null && scenario.isAllowed(toExecute)) {
			toExecute.perform(player, worldMap)
		}
	}

}
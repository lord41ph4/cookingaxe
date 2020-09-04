package com.axetrading.game.cookingaxe.arena

import com.axetrading.game.cookingaxe.universe.Figure
import com.axetrading.game.cookingaxe.universe.Item
import com.axetrading.game.cookingaxe.universe.Player
import com.axetrading.game.cookingaxe.universe.Scenario
import com.axetrading.game.cookingaxe.universe.Unique
import com.axetrading.game.cookingaxe.universe.WorldMap
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit
import kotlin.time.ExperimentalTime
import kotlin.time.toDuration

class Arena(
        players: List<Player>,
        private val worldMap: WorldMap,
        private val scenario: Scenario
) {
    class ImmutableWrapper<T>(list: List<T>) : List<T> by list

    class MapInfo(
            val player: Player,
            private val base: WorldMap
    ) : WorldMap {

        private val immutableItems: List<Item> get() = ImmutableWrapper(base.items)
        private val immutableFigures: List<Figure> get() = ImmutableWrapper(base.figures)

        override fun getItems(): List<Item> {
            return immutableItems
        }

        override fun getFigures(): List<Figure> {
            return immutableFigures
        }

        override fun <T : Unique?> findById(id: Long): T {
            return base.findById(id)
        }

    }

    private val playerMaps: Map<Player, MapInfo> = players.associateBy({ player -> player }, { player -> MapInfo(player, this.worldMap) })

    @ExperimentalTime
    @ExperimentalCoroutinesApi
    fun onTick() {
        runBlocking {
            val playerActions: Map<Player, Deferred<List<Figure>>> = this@Arena.playerMaps.entries.associateBy({ entry -> entry.key }, { entry ->
                this.async(Dispatchers.Default) {
                    collectActions(entry)
                }
            })
            delay(2.toDuration(TimeUnit.SECONDS))
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

    @ExperimentalCoroutinesApi
    private fun evaluate(player: Player, action: Deferred<List<Figure>>) {
        val actionFigures = if (action.isCompleted && action.getCompletionExceptionOrNull() == null) action.getCompleted() else null
        actionFigures?.forEach {
            if (scenario.isAllowed(it.action)) {
                it.action.perform(player, worldMap)
            }
        }
    }

}
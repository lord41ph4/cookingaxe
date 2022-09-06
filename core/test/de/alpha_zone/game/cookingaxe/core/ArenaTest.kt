@file:Suppress("JAVA_MODULE_DOES_NOT_DEPEND_ON_MODULE")

package de.alpha_zone.game.cookingaxe.core

import de.alpha_zone.game.cookingaxe.universe.Figure
import de.alpha_zone.game.cookingaxe.universe.Player
import de.alpha_zone.game.cookingaxe.universe.WorldMap
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import kotlin.time.ExperimentalTime
import de.alpha_zone.game.cookingaxe.core.KVector2d as Vector

@ExperimentalTime
@ExperimentalCoroutinesApi
class ArenaTest {

	@Test
	fun `an Arena can be created`() {
		Arena(emptyList(), World())
	}

	@Test
	fun `a Player can move a Figure on tick`() {
		val player = object : Player {

			override fun getName(): String {
				return "Test"
			}

			override fun think(worldMap: WorldMap?, ownFigures: MutableList<Figure>?) {
				if (ownFigures != null) {
					for (i in 0 until ownFigures.size) {
						ownFigures[i].move(Vector(1, 1))
					}
				}
			}
		}
		val figure = BaseFigure(0, player)
		val world = World()

		world.place(Vector(0, 0), figure)


		val arena = Arena(mutableListOf(player), world)
		arena.onTick()

		assertThat(figure.position, `is`(Vector(1, 1)))
	}

}
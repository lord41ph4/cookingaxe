@file:Suppress("JAVA_MODULE_DOES_NOT_DEPEND_ON_MODULE")

package de.alpha_zone.game.cookingaxe.core

import de.alpha_zone.game.cookingaxe.universe.Vector2d
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class MoveHandlerTest {

	class MoveOnlyFigure(private val moveDirection: Vector2d) : TestFigure(null) {

		override fun getDirection(): Vector2d {
			return this.moveDirection
		}

	}

	@Test
	fun `a MoveHandler can be created with a given World`() {
		MoveHandler(World())
	}

	@Test
	fun `starting at (0,0) and moving in direction (1,1) results to position (1,1)`() {
		val world = World()
		val moveDirection = TestVector(1, 1)
		val figure = MoveOnlyFigure(moveDirection)
		world.place(TestVector(0, 0), figure)
		val moveHandler = MoveHandler(world)
		moveHandler.evaluate(figure)

		assertThat(world.getPosition(figure), `is`(moveDirection))
	}

}
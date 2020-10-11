@file:Suppress("JAVA_MODULE_DOES_NOT_DEPEND_ON_MODULE")

package com.axetrading.game.cookingaxe.arena

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import com.axetrading.game.cookingaxe.arena.KVector2d as Vector

class MoveHandlerTest {

	class MoveOnlyFigure(private val moveDirection: Vector) : TestFigure(null) {

		override fun getDirection(): Vector {
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
		val moveDirection = Vector(1, 1)
		val figure = MoveOnlyFigure(moveDirection)
		world.place(Vector(0, 0), figure)
		val moveHandler = MoveHandler(world)
		moveHandler.evaluate(figure)

		assertThat(world.getPosition(figure), `is`(moveDirection))
	}

}
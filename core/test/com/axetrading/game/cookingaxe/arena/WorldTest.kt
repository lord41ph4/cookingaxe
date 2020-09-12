@file:Suppress("JAVA_MODULE_DOES_NOT_DEPEND_ON_MODULE")

package com.axetrading.game.cookingaxe.arena

import com.axetrading.game.cookingaxe.universe.Vector2d
import com.axetrading.game.cookingaxe.universe.utils.BasicVector2d
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
import org.junit.jupiter.api.Test

class WorldTest {

	@Test
	fun `A World can be created`() {
		World()
	}

	@Test
	fun `Figures can be placed on a World`() {
		val world = World()
		val figure = TestFigure()
		world.place(BasicVector2d(0, 0), figure)
		assertThat(world.figures, contains(figure))
	}

	@Test
	fun `Positions of Figures can be queried`() {
		val world = World()
		val testFigure = TestFigure()
		val testPosition = BasicVector2d(0, 0)
		world.place(testPosition, testFigure)
		val position: Vector2d? = world.getPosition(testFigure)
		assertThat(position, `is`(testPosition))
	}

	@Test
	fun `Position of unknown Figure is null`() {
		val world = World()
		val testFigure = TestFigure()
		val position: Vector2d? = world.getPosition(testFigure)
		assertThat(position, `is`(nullValue()))
	}

	@Test
	fun `Position of null is null`() {
		val world = World()
		val position: Vector2d? = world.getPosition(null)
		assertThat(position, `is`(nullValue()))
	}

	@Test
	fun `Positions of Figures can be set`() {
		val world = World()
		val testFigure = TestFigure()
		val startPosition = BasicVector2d(0, 0)
		world.place(startPosition, testFigure)

		val position = BasicVector2d(1,1)
		world.setPosition(testFigure, position)
		assertThat(world.getPosition(testFigure), `is`(position))
	}

	@Test
	fun `Containers can be placed on a World`() {
		val world = World()
		world.place(BasicVector2d(0,0), TestContainer())
	}
}
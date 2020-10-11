@file:Suppress("JAVA_MODULE_DOES_NOT_DEPEND_ON_MODULE")

package com.axetrading.game.cookingaxe.core

import com.axetrading.game.cookingaxe.universe.Vector2d
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
import org.junit.jupiter.api.Test
import com.axetrading.game.cookingaxe.core.KVector2d as Vector

class WorldTest {

	@Test
	fun `A World can be created`() {
		World()
	}

	@Test
	fun `Figures can be placed on a World`() {
		val world = World()
		val figure = TestFigure()
		world.place(Vector(0, 0), figure)
		assertThat(world.figures, contains(figure))
	}

	@Test
	fun `Positions of Figures can be queried`() {
		val world = World()
		val testFigure = TestFigure()
		val testPosition = Vector(0, 0)
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
		val startPosition = Vector(0, 0)
		world.place(startPosition, testFigure)

		val position = Vector(1, 1)
		world.setPosition(testFigure, position)
		assertThat(world.getPosition(testFigure), `is`(position))
	}

	@Test
	fun `Containers can be placed on a World`() {
		val world = World()
		world.place(Vector(0, 0), TestContainer())
	}
}
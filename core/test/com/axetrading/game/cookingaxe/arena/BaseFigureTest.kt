@file:Suppress("JAVA_MODULE_DOES_NOT_DEPEND_ON_MODULE")

package com.axetrading.game.cookingaxe.arena

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import com.axetrading.game.cookingaxe.universe.utils.BasicVector2d as Vector

class BaseFigureTest {

	@Test
	fun `a BaseFigure can be created with a given Id and Owner`() {
		BaseFigure(0, null)
	}

	@Test
	fun `a BaseFigure can be positioned`() {
		val baseFigure = BaseFigure(0, null)
		val x = 100
		val y = 500
		baseFigure.position = Vector(x, y)

		assertThat(baseFigure.position, `is`(Vector(x, y)))
	}

	@Test
	fun `the orientation of a BaseFigure can be set`() {
		val baseFigure = BaseFigure(0, null)
		val x = 5.7
		val y = 6
		baseFigure.orientation = Vector(x, y)
		assertThat(baseFigure.orientation, `is`(Vector(x, y)))
	}

	@Test
	fun `moving a BaseFigure sets its direction`() {
		val baseFigure = BaseFigure(0, null)
		val x = 5.7
		val y = 6
		baseFigure.move(Vector(x, y))
		assertThat(baseFigure.direction, `is`(Vector(x, y)))
	}
}
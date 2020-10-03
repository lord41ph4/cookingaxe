@file:Suppress("JAVA_MODULE_DOES_NOT_DEPEND_ON_MODULE")

package com.axetrading.game.cookingaxe.arena

import com.axetrading.game.cookingaxe.universe.Vector2d
import com.axetrading.game.cookingaxe.universe.utils.BasicVector2d
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class BasicVector2dTest {

	@Test
	fun `a BasicVector2d can be created using x and y coordinates using numbers`() {
		val x: Number = 1.337
		val y: Number = 1337
		val vector = BasicVector2d(x, y)

		assertThat(vector.x, `is`(x.toDouble()))
		assertThat(vector.y, `is`(y.toDouble()))
	}

	@Test
	fun `a BasicVector2d can be created using another Vector2d`() {
		val x: Number = 1.337
		val y: Number = 1337
		val toCopy: Vector2d = BasicVector2d(x, y)
		val vector = BasicVector2d(toCopy)

		assertThat(vector.x, `is`(x.toDouble()))
		assertThat(vector.y, `is`(y.toDouble()))
	}

}
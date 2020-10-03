package com.axetrading.game.cookingaxe.arena

import com.axetrading.game.cookingaxe.universe.Figure
import com.axetrading.game.cookingaxe.universe.Vector2d
import com.axetrading.game.cookingaxe.universe.utils.BasicVector2d

class MoveHandler(private val world: MutableWorldMap) {
	fun evaluate(figure: Figure) {
		val position = world.getPosition(figure)
		val direction = figure.direction
		if (position != null && direction != null) {
			val vector = position.toBaseVector()
			val moveResult = vector.add(direction)
			world.setPosition(figure, moveResult)
			figure.position = moveResult
		}
	}

	private fun Vector2d.toBaseVector(): BasicVector2d {
		return when (this) {
			is BasicVector2d -> {
				this
			}
			else -> {
				BasicVector2d(this)
			}
		}
	}
}

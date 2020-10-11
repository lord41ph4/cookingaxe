package com.axetrading.game.cookingaxe.core

import com.axetrading.game.cookingaxe.universe.Figure
import com.axetrading.game.cookingaxe.universe.Vector2d

class MoveHandler(private val world: MutableWorldMap) {
	fun evaluate(figure: Figure) {
		val position = world.getPosition(figure)
		val direction = figure.direction
		if (position != null && direction != null) {
			val vector = position.toKVector()
			val moveResult = vector + direction
			world.setPosition(figure, moveResult)
			figure.position = moveResult
		}
	}

	private fun Vector2d.toKVector(): KVector2d {
		return when (this) {
			is KVector2d -> {
				this
			}
			else -> {
				KVector2d(this)
			}
		}
	}
}

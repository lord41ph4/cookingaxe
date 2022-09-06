package de.alpha_zone.game.cookingaxe.core

import de.alpha_zone.game.cookingaxe.universe.Figure
import de.alpha_zone.game.cookingaxe.universe.Unique
import de.alpha_zone.game.cookingaxe.universe.Vector2d
import java.util.stream.Collectors

class World : MutableWorldMap {

	private data class UniquePosition(var unique: Unique, var position: Vector2d)

	private val figures: MutableMap<Long, UniquePosition> = mutableMapOf()

	fun place(position: Vector2d, unique: Unique) {
		figures[unique.id] = UniquePosition(unique, position)
	}

	override fun getFigures(): List<Figure> {
		return figures.values.stream()
				.map { uniquePosition -> uniquePosition.unique }
				.filter { unique -> unique is Figure }
				.map { unique -> unique as Figure }.collect(Collectors.toList())
	}

	override fun getPosition(figure: Figure?): Vector2d? {
		if (figure != null) {
			val position = this.figures[figure.id]
			return position?.position
		}
		return null
	}

	override fun setPosition(figure: Figure, position: Vector2d) {
		val figurePosition = this.figures[figure.id]
		figurePosition?.position = position
	}
}
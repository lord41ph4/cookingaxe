package com.axetrading.game.cookingaxe.arena

import com.axetrading.game.cookingaxe.universe.Vector2d
import kotlin.math.sqrt

class KVector2d(private var x: Double, private var y: Double) : Vector2d {

	constructor(x: Number, y: Number) : this(x.toDouble(), y.toDouble())
	constructor(toCopy: Vector2d) : this(toCopy.x, toCopy.y)

	override fun getX(): Double {
		return x
	}

	override fun getY(): Double {
		return y
	}

	operator fun plus(vector: Vector2d): KVector2d {
		return KVector2d(x + vector.x, y + vector.y)
	}

	operator fun plusAssign(other: Vector2d) {
		x += other.x
		y += other.y
	}

	operator fun unaryMinus(): KVector2d {
		return KVector2d(if (x == 0.0) 0 else -x, if (y == 0.0) 0 else -y)
	}

	operator fun minus(other: Vector2d): KVector2d {
		return KVector2d(x - other.x, y - other.y)
	}

	operator fun minusAssign(other: Vector2d) {
		x -= other.x
		y -= other.y
	}

	operator fun times(scalar: Number): KVector2d {
		return KVector2d(x * scalar.toDouble(), y * scalar.toDouble())
	}

	operator fun timesAssign(scalar: Number) {
		x *= scalar.toDouble()
		y *= scalar.toDouble()
	}

	operator fun times(vector: Vector2d): KVector2d {
		return KVector2d(x * vector.x, y * vector.y)
	}

	operator fun timesAssign(vector: Vector2d) {
		x *= vector.x
		y *= vector.y
	}

	operator fun div(scalar: Number): KVector2d {
		return KVector2d(x / scalar.toDouble(), y / scalar.toDouble())
	}

	operator fun divAssign(scalar: Number) {
		x /= scalar.toDouble()
		y /= scalar.toDouble()
	}

	operator fun div(vector: Vector2d): KVector2d {
		return KVector2d(x / vector.x, y / vector.y)
	}

	operator fun divAssign(vector: Vector2d) {
		x /= vector.x
		y /= vector.y
	}

	fun length(): Double {
		return sqrt(lengthSquare())
	}

	fun lengthSquare(): Double {
		return x * x + y * y
	}

	fun normalized(): KVector2d {
		val length = length()
		if (length == 0.0) {
			return KVector2d(0, 0)
		}
		return KVector2d(x / length, y / length)
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) {
			return true
		}
		return other is Vector2d && x.compareTo(other.x) == 0 && y.compareTo(other.y) == 0
	}

	override fun hashCode(): Int {
		var result = x.hashCode()
		result = 31 * result + y.hashCode()
		return result
	}

}
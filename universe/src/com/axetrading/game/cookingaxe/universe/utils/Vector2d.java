package com.axetrading.game.cookingaxe.universe.utils;

public class Vector2d {

	private final double x;
	private final double y;

	public Vector2d(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public Vector2d add(Vector2d vector) {
		return new Vector2d(this.x + vector.x, this.y + vector.y);
	}

	public Vector2d subtract(Vector2d vector) {
		return new Vector2d(this.x - vector.x, this.y - vector.y);
	}

	public Vector2d multiply(double scalar) {
		return new Vector2d(this.x * scalar, this.y * scalar);
	}

	public Vector2d multiply(Vector2d vector) {
		return new Vector2d(this.x * vector.x, this.y * vector.y);
	}

	public Vector2d divide(double scalar) {
		return new Vector2d(this.x / scalar, this.y / scalar);
	}

	public Vector2d divide(Vector2d vector) {
		return new Vector2d(this.x / vector.x, this.y / vector.y);
	}

	public double length() {
		return Math.sqrt(this.lengthSquare());
	}

	public double lengthSquare() {
		return this.x * this.x + this.y * this.y;
	}

	public Vector2d normalized() {
		double length = this.length();
		return new Vector2d(this.x / length, this.y / length);
	}
}

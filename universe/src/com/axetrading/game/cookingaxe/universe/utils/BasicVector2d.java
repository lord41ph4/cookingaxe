package com.axetrading.game.cookingaxe.universe.utils;

import java.util.Objects;

import com.axetrading.game.cookingaxe.universe.Vector2d;

public class BasicVector2d implements Vector2d {

	private final double x;
	private final double y;

	public BasicVector2d(Number x, Number y) {
		this.x = x.doubleValue();
		this.y = y.doubleValue();
	}

	@Override
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		return this.y;
	}

	public BasicVector2d add(Vector2d vector) {
		return new BasicVector2d(this.getX() + vector.getX(), this.getY() + vector.getY());
	}

	public BasicVector2d subtract(Vector2d vector) {
		return new BasicVector2d(this.getX() - vector.getX(), this.getY() - vector.getY());
	}

	public BasicVector2d multiply(double scalar) {
		return new BasicVector2d(this.getX() * scalar, this.getY() * scalar);
	}

	public BasicVector2d multiply(Vector2d vector) {
		return new BasicVector2d(this.getX() * vector.getX(), this.getY() * vector.getY());
	}

	public BasicVector2d divide(double scalar) {
		return new BasicVector2d(this.getX() / scalar, this.getY() / scalar);
	}

	public BasicVector2d divide(Vector2d vector) {
		return new BasicVector2d(this.getX() / vector.getX(), this.getY() / vector.getY());
	}

	public double length() {
		return Math.sqrt(this.lengthSquare());
	}

	public double lengthSquare() {
		return this.getX() * this.getX() + this.getY() * this.getY();
	}

	public BasicVector2d normalized() {
		double length = this.length();
		return new BasicVector2d(this.getX() / length, this.getY() / length);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		BasicVector2d vector2d = (BasicVector2d) o;
		return Double.compare(vector2d.getX(), this.getX()) == 0 && Double.compare(vector2d.getY(), this.getY()) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getX(), this.getY());
	}

	@Override
	public String toString() {
		return "Vector2d{" + "x=" + this.getX() + ", y=" + this.getY() + '}';
	}
}

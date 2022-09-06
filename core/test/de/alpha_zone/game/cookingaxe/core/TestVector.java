package de.alpha_zone.game.cookingaxe.core;

import de.alpha_zone.game.cookingaxe.universe.Vector2d;

public class TestVector implements Vector2d {

	private final double x;
	private final double y;

	public TestVector(Number x, Number y) {
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
}

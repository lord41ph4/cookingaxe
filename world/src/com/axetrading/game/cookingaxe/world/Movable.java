package com.axetrading.game.cookingaxe.world;

import com.axetrading.game.cookingaxe.world.utils.Vector2d;

public interface Movable extends Positionable {

	Vector2d getDirection();

	void setDirection(Vector2d direction);

	default double getMaxSpeed() {
		return 1d;
	}

	default void move() {
		Vector2d moveVector = this.getDirection()
				.multiply(this.getMaxSpeed());
		this.setDirection(moveVector);
	}

}

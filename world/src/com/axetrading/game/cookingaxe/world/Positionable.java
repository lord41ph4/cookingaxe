package com.axetrading.game.cookingaxe.world;

import com.axetrading.game.cookingaxe.world.utils.Vector2d;

public interface Positionable {

	Vector2d getPosition();

	Vector2d getOrientation();

	void place(Vector2d position, Vector2d orientation);

	default boolean isPositioned() {
		return this.getPosition() != null && this.getOrientation() != null;
	}

}

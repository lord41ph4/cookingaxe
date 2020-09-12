package com.axetrading.game.cookingaxe.universe;

public interface Movable extends Positionable {

	Vector2d getDirection();

	void move(Vector2d direction);

}

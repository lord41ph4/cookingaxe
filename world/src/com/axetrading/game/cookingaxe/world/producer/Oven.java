package com.axetrading.game.cookingaxe.world.producer;

import com.axetrading.game.cookingaxe.world.Positionable;
import com.axetrading.game.cookingaxe.world.utils.Vector2d;

public class Oven implements Positionable {

	private Vector2d position;
	private Vector2d orientation;

	public Oven() {
	}

	@Override
	public Vector2d getPosition() {
		return this.position;
	}

	@Override
	public Vector2d getOrientation() {
		return this.orientation;
	}

	@Override
	public void place(Vector2d position, Vector2d orientation) {
		if (this.position == null && this.orientation == null) {
			this.position = position;
			this.orientation = orientation;
		}
	}
}

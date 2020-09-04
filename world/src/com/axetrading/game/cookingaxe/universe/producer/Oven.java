package com.axetrading.game.cookingaxe.universe.producer;

import com.axetrading.game.cookingaxe.universe.Positionable;
import com.axetrading.game.cookingaxe.universe.Turnable;
import com.axetrading.game.cookingaxe.universe.utils.Vector2d;

public class Oven implements Positionable, Turnable {

	private Vector2d position;
	private Vector2d orientation;

	public Oven() {
	}

	@Override
	public Vector2d getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Vector2d position) {

	}

	@Override
	public Vector2d getOrientation() {
		return this.orientation;
	}

	@Override
	public void setOrientation(Vector2d orientation) {

	}
}

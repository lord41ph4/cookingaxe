package com.axetrading.game.cookingaxe.arena;

import com.axetrading.game.cookingaxe.universe.Action;
import com.axetrading.game.cookingaxe.universe.Figure;
import com.axetrading.game.cookingaxe.universe.Inventory;
import com.axetrading.game.cookingaxe.universe.Player;
import com.axetrading.game.cookingaxe.universe.Vector2d;
import com.axetrading.game.cookingaxe.universe.utils.BasicVector2d;

class TestFigure implements Figure {

	@Override
	public Action getAction() {
		return null;
	}

	@Override
	public Inventory getInventory() {
		return null;
	}

	@Override
	public BasicVector2d getDirection() {
		return null;
	}

	@Override
	public void move(Vector2d direction) {
	}

	@Override
	public Player getOwner() {
		return null;
	}

	@Override
	public BasicVector2d getPosition() {
		return null;
	}

	@Override
	public void setPosition(Vector2d position) {

	}

	@Override
	public Vector2d getOrientation() {
		return null;
	}

	@Override
	public void setOrientation(Vector2d orientation) {

	}

	@Override
	public long getId() {
		return 0;
	}
}

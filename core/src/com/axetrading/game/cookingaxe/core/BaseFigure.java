package com.axetrading.game.cookingaxe.core;

import com.axetrading.game.cookingaxe.universe.Figure;
import com.axetrading.game.cookingaxe.universe.Player;
import com.axetrading.game.cookingaxe.universe.Vector2d;

/**
 * BaseFigure represents a movable Figure in the Game it already handles
 * positioning, orientation and movement
 */
public class BaseFigure implements Figure {

	private final long id;
	private final Player owner;
	private Vector2d position;
	private Vector2d orientation;
	private Vector2d direction;

	public BaseFigure(long id, Player owner) {
		this.id = id;
		this.owner = owner;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public Vector2d getDirection() {
		return this.direction;
	}

	@Override
	public void move(Vector2d direction) {
		this.direction = new KVector2d(direction);
	}

	@Override
	public Player getOwner() {
		return this.owner;
	}

	@Override
	public Vector2d getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Vector2d position) {
		this.position = new KVector2d(position);
	}

	@Override
	public Vector2d getOrientation() {
		return this.orientation;
	}

	@Override
	public void setOrientation(Vector2d orientation) {
		this.orientation = new KVector2d(orientation);
	}
}

package de.alpha_zone.game.cookingaxe.core;

import de.alpha_zone.game.cookingaxe.universe.Action;
import de.alpha_zone.game.cookingaxe.universe.Figure;
import de.alpha_zone.game.cookingaxe.universe.Inventory;
import de.alpha_zone.game.cookingaxe.universe.Player;
import de.alpha_zone.game.cookingaxe.universe.Vector2d;

public class TestFigure implements Figure {

	private final Player owner;

	public TestFigure() {
		this(null);
	}

	public TestFigure(Player owner) {
		this.owner = owner;
	}

	@Override
	public Action getAction() {
		return null;
	}

	@Override
	public Inventory getInventory() {
		return null;
	}

	@Override
	public Vector2d getDirection() {
		return null;
	}

	@Override
	public void move(Vector2d direction) {
	}

	@Override
	public Player getOwner() {
		return this.owner;
	}

	@Override
	public Vector2d getPosition() {
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

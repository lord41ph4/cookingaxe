package com.axetrading.game.cookingaxe.world.actions;

import com.axetrading.game.cookingaxe.world.Action;
import com.axetrading.game.cookingaxe.world.Figure;
import com.axetrading.game.cookingaxe.world.Player;
import com.axetrading.game.cookingaxe.world.WorldMap;
import com.axetrading.game.cookingaxe.world.utils.Vector2d;

public final class Move implements Action {

	private final Figure toBeMoved;
	private final Vector2d direction;

	public Move(Figure toBeMoved, Vector2d direction) {
		this.toBeMoved = toBeMoved;
		this.direction = direction.normalized();
	}

	@Override
	public void perform(Player player, WorldMap worldMap) {
		Figure figureOnWorldMap = null;
		if (this.toBeMoved != null) {
			figureOnWorldMap = worldMap.findById(this.toBeMoved.getId());
		}
		// same instance of player is wanted, intended ==
		if (figureOnWorldMap != null && figureOnWorldMap.getOwner() == player) {
			figureOnWorldMap.setDirection(this.direction);
			figureOnWorldMap.move();
		}
	}
}

package com.axetrading.game.cookingaxe.world;

/**
 *
 */
public interface Figure extends Movable, Turnable, Ownable, Unique {

	Action getAction();

	Inventory getInventory();

}

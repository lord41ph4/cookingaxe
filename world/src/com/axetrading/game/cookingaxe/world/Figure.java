package com.axetrading.game.cookingaxe.world;

public interface Figure extends Movable, Ownable {

	Action getAction();

	Inventory getInventory();

}

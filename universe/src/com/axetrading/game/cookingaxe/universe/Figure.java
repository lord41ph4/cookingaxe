package com.axetrading.game.cookingaxe.universe;

/**
 * Represents a Figure on the world map.
 */
public interface Figure extends Positionable, Movable, Turnable, Ownable, Unique {

	/**
	 * @return current action the figure is performing
	 */
	Action getAction();

	/**
	 * @return figures current inventory
	 */
	Inventory getInventory();

}

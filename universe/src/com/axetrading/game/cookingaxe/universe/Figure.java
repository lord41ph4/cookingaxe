package com.axetrading.game.cookingaxe.universe;

/**
 * Represents a Figure on the world map.
 */
public interface Figure extends Positionable, Movable, Turnable, Ownable, Unique {

	/**
	 * @return current action the figure is performing, by default no action
	 */
	default Action getAction() {
		return null;
	}

	/**
	 * @return figures current inventory, by default no inventory
	 */
	default Inventory getInventory() {
		return null;
	}

}

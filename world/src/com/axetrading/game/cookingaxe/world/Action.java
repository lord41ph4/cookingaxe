package com.axetrading.game.cookingaxe.world;

/**
 * Represents an activity a Figure can do on the world map.
 */
public interface Action {

	/**
	 * Perform the action on a world map
	 *
	 * @param player   Player performing action
	 * @param worldMap WorldMap on which the action is performed
	 */
	void perform(Player player, WorldMap worldMap);

}

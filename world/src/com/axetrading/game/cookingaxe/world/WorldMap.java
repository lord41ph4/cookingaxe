package com.axetrading.game.cookingaxe.world;

import java.util.List;

public interface WorldMap {

	List<Figure> getFigures();

	<T extends Unique> T findById(long id);

	List<Item> getItems();

}

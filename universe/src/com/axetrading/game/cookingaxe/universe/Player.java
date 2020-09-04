package com.axetrading.game.cookingaxe.universe;

import java.util.List;

public interface Player {

	String getName();

	void think(WorldMap worldMap, List<Figure> ownFigures);

}

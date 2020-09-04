package com.axetrading.game.cookingaxe;

import com.axetrading.game.cookingaxe.universe.Figure;
import com.axetrading.game.cookingaxe.universe.WorldMap;

public interface SceneModifier {

	void initialize(WorldMap worldMap);

	void updateWorldMap(WorldMap updated);

	void updateUpdate(Figure figure);

}

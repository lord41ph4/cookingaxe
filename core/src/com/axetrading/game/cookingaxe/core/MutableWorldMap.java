package com.axetrading.game.cookingaxe.core;

import com.axetrading.game.cookingaxe.universe.Figure;
import com.axetrading.game.cookingaxe.universe.Vector2d;
import com.axetrading.game.cookingaxe.universe.WorldMap;

public interface MutableWorldMap extends WorldMap {

	void setPosition(Figure figure, Vector2d position);

}

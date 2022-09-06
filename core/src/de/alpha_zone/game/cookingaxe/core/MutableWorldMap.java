package de.alpha_zone.game.cookingaxe.core;

import de.alpha_zone.game.cookingaxe.universe.Figure;
import de.alpha_zone.game.cookingaxe.universe.Vector2d;
import de.alpha_zone.game.cookingaxe.universe.WorldMap;

public interface MutableWorldMap extends WorldMap {

	void setPosition(Figure figure, Vector2d position);

}

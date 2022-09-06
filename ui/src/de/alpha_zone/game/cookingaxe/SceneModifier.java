package de.alpha_zone.game.cookingaxe;

import de.alpha_zone.game.cookingaxe.universe.Figure;
import de.alpha_zone.game.cookingaxe.universe.WorldMap;

public interface SceneModifier {

	void initialize(WorldMap worldMap);

	void updateWorldMap(WorldMap updated);

	void updateUpdate(Figure figure);

}

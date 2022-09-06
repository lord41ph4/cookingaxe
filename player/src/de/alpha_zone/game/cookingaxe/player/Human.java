package de.alpha_zone.game.cookingaxe.player;

import java.util.List;

import de.alpha_zone.game.cookingaxe.universe.Figure;
import de.alpha_zone.game.cookingaxe.universe.Player;
import de.alpha_zone.game.cookingaxe.universe.WorldMap;

public class Human implements Player {
	@Override
	public String getName() {
		return "Human";
	}

	@Override
	public void think(WorldMap worldMap, List<Figure> ownFigures) {

	}
}

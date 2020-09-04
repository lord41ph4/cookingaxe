package com.axetrading.game.cookingaxe.player;

import java.util.List;

import com.axetrading.game.cookingaxe.universe.Figure;
import com.axetrading.game.cookingaxe.universe.Player;
import com.axetrading.game.cookingaxe.universe.WorldMap;

public class Human implements Player {
	@Override
	public String getName() {
		return "Human";
	}

	@Override
	public void think(WorldMap worldMap, List<Figure> ownFigures) {

	}
}

package de.alpha_zone.game.cookingaxe.universe;

import java.util.List;

public interface WorldMap {

	List<Figure> getFigures();

	Vector2d getPosition(Figure figure);
}

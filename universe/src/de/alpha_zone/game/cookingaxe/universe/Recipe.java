package de.alpha_zone.game.cookingaxe.universe;

import java.util.Map;

public interface Recipe extends Item {

	Map<Class<? extends Ingredient>, Integer> getIngredients();

}

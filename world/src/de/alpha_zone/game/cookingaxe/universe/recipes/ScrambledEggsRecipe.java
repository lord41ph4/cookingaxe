package de.alpha_zone.game.cookingaxe.universe.recipes;

import java.util.Map;

import de.alpha_zone.game.cookingaxe.universe.Ingredient;
import de.alpha_zone.game.cookingaxe.universe.Recipe;
import de.alpha_zone.game.cookingaxe.universe.ingredients.Egg;

public class ScrambledEggsRecipe implements Recipe {

	@Override
	public String getName() {
		return "Recipe for tasty scrambled eggs!";
	}

	@Override
	public Map<Class<? extends Ingredient>, Integer> getIngredients() {
		return Map.of(Egg.class, 2);
	}
}

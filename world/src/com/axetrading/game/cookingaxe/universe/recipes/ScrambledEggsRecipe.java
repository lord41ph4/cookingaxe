package com.axetrading.game.cookingaxe.universe.recipes;

import java.util.Map;

import com.axetrading.game.cookingaxe.universe.Ingredient;
import com.axetrading.game.cookingaxe.universe.Recipe;
import com.axetrading.game.cookingaxe.universe.ingredients.Egg;

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

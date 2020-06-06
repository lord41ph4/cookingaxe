package com.axetrading.game.cookingaxe.world.recipes;

import java.util.Map;

import com.axetrading.game.cookingaxe.world.Ingredient;
import com.axetrading.game.cookingaxe.world.Recipe;
import com.axetrading.game.cookingaxe.world.ingredients.Egg;

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

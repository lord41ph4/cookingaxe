package com.axetrading.game.cookingaxe.world;

import java.util.Map;

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

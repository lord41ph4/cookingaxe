package com.axetrading.game.cookingaxe.world;

import java.util.Map;

import org.jetbrains.annotations.NotNull;

public class ScrambledEggsRecipe implements Recipe {

	@NotNull
	@Override
	public String getName() {
		return "Recipe for tasty scrambled eggs!";
	}

	@NotNull
	@Override
	public Map<Class<? extends Ingredient>, Integer> getIngredients() {
		return Map.of(Egg.class, 2);
	}
}

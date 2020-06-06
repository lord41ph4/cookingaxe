package com.axetrading.game.cookingaxe;

import java.util.ServiceLoader;

import com.axetrading.game.cookingaxe.world.Ingredient;
import com.axetrading.game.cookingaxe.world.Player;
import com.axetrading.game.cookingaxe.world.Recipe;

public class ResourceLoader {

	public static void main(String... args) {
		ServiceLoader<Player> playerLoader = ServiceLoader.load(Player.class);
		for (Player player : playerLoader) {
			System.out.println("Player " + player.getName() + " loaded");
		}

		ServiceLoader<Ingredient> ingredientsLoader = ServiceLoader.load(Ingredient.class);
		for (Ingredient ingredient : ingredientsLoader) {
			System.out.println("Ingredient " + ingredient.getName() + " loaded");
		}

		ServiceLoader<Recipe> recipeServiceLoader = ServiceLoader.load(Recipe.class);
		for (Recipe recipe : recipeServiceLoader) {
			System.out.println("Recipe " + recipe.getName() + " loaded");
		}

	}

}

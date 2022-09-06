package de.alpha_zone.game.cookingaxe;

import java.util.ServiceLoader;

import de.alpha_zone.game.cookingaxe.universe.Ingredient;
import de.alpha_zone.game.cookingaxe.universe.Player;
import de.alpha_zone.game.cookingaxe.universe.Recipe;
import de.alpha_zone.game.cookingaxe.universe.Scenario;

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

		ServiceLoader<Scenario> scenarioServiceLoader = ServiceLoader.load(Scenario.class);
		for (Scenario scenario : scenarioServiceLoader) {
			System.out.println("Recipe " + scenario.getClass() + " loaded");
		}

	}

}

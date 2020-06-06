package com.axetrading.game.cookingaxe.world.recipes

import com.axetrading.game.cookingaxe.world.Ingredient
import com.axetrading.game.cookingaxe.world.Recipe
import com.axetrading.game.cookingaxe.world.ingredients.Egg

class PanCakeRecipe : Recipe {

	override fun getName(): String {
		return "Recipe for tasty pancake!";
	}

	override fun getIngredients(): Map<Class<out Ingredient>, Int> {
		return mapOf(Egg::class.java to 3)
	}

}
package com.axetrading.game.cookingaxe.world

class PanCakeRecipe : Recipe {

	override fun getName(): String {
		return "Recipe for tasty pancake!";
	}

	override fun getIngredients(): Map<Class<out Ingredient>, Int> {
		return mapOf(Egg::class.java to 3)
	}

}
package com.axetrading.game.cookingaxe.world

class PanCakeRecipe : Recipe {
	override val ingredients: Map<Class<out Ingredient>, Int>
		get() = mapOf(Egg::class.java to 3)
	override val name: String
		get() = "Recipe for tasty pancake!"

}
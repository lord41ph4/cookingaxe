package com.axetrading.game.cookingaxe.universe.recipes

import com.axetrading.game.cookingaxe.universe.Ingredient
import com.axetrading.game.cookingaxe.universe.Recipe
import com.axetrading.game.cookingaxe.universe.ingredients.Egg

class PanCakeRecipe : Recipe {

    override fun getName(): String {
        return "Recipe for tasty pancake!"
    }

    override fun getIngredients(): Map<Class<out Ingredient>, Int> {
        return mapOf(Egg::class.java to 3)
    }

}
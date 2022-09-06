package de.alpha_zone.game.cookingaxe.universe.recipes

import de.alpha_zone.game.cookingaxe.universe.Ingredient
import de.alpha_zone.game.cookingaxe.universe.Recipe
import de.alpha_zone.game.cookingaxe.universe.ingredients.Egg

class PanCakeRecipe : Recipe {

    override fun getName(): String {
        return "Recipe for tasty pancake!"
    }

    override fun getIngredients(): Map<Class<out Ingredient>, Int> {
        return mapOf(Egg::class.java to 3)
    }

}
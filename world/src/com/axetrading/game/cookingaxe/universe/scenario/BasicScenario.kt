package com.axetrading.game.cookingaxe.universe.scenario

import com.axetrading.game.cookingaxe.universe.Action
import com.axetrading.game.cookingaxe.universe.Recipe
import com.axetrading.game.cookingaxe.universe.Scenario
import com.axetrading.game.cookingaxe.universe.actions.Craft
import com.axetrading.game.cookingaxe.universe.actions.Move
import com.axetrading.game.cookingaxe.universe.recipes.PanCakeRecipe
import com.axetrading.game.cookingaxe.universe.recipes.ScrambledEggsRecipe

class BasicScenario : Scenario {
    companion object {

        val actions: Set<Class<out Action>> = setOf(Move::class.java, Craft::class.java)
        val recipes: Set<Class<out Recipe>> = setOf(ScrambledEggsRecipe::class.java, PanCakeRecipe::class.java)

    }

    override fun allowedActions(): Set<Class<out Action>> {
        return actions
    }

    override fun allowedReceipts(): Set<Class<out Recipe>> {
       return recipes
    }
}
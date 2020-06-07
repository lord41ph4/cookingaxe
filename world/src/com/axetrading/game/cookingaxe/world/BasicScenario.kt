package com.axetrading.game.cookingaxe.world

import com.axetrading.game.cookingaxe.world.actions.Craft
import com.axetrading.game.cookingaxe.world.actions.Move

class BasicScenario : Scenario {
	companion object {

		val actions : Set<Class<out Action>> = setOf(Move::class.java, Craft::class.java)

	}

	override fun allowedActions(): Set<Class<out Action>> {
		return actions
	}

	override fun allowedReceipts(): Set<Class<Recipe>> {
		TODO("Not yet implemented")
	}
}
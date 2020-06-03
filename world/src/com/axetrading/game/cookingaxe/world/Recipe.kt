package com.axetrading.game.cookingaxe.world

interface Recipe : Item {

	val ingredients: Map<Class<out Ingredient>, Int>

}
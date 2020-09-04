package com.axetrading.game.cookingaxe.universe;

import java.util.Set;

public interface Scenario {

	Set<Class<? extends Recipe>> allowedReceipts();

	Set<Class<? extends Action>> allowedActions();

	default boolean isAllowed(Action action) {
		return this.allowedActions()
				.stream()
				.anyMatch(clazz -> clazz.isInstance(action));
	}

	default boolean isAllowed(Recipe recipe) {
		return this.allowedReceipts()
				.stream()
				.anyMatch(clazz -> clazz.isInstance(recipe));
	}

}

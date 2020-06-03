package com.axetrading.game.cookingaxe;

import java.util.ServiceLoader;

import com.axetrading.game.cookingaxe.world.Item;
import com.axetrading.game.cookingaxe.world.Player;

public class ResourceLoader {

	public static void main(String... args) {
		ServiceLoader<Player> playerLoader = ServiceLoader.load(Player.class);
		for (Player player : playerLoader) {
			System.out.println("Player " + player.getName() + " loaded");
		}

		ServiceLoader<Item> ingredientsLoader = ServiceLoader.load(Item.class);
		for (Item ingredient : ingredientsLoader) {
			System.out.println("Item " + ingredient.getName() + " loaded");
		}

	}

}

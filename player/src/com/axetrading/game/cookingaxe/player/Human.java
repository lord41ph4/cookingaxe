package com.axetrading.game.cookingaxe.player;

import com.axetrading.game.cookingaxe.world.Player;

public class Human implements Player {

	private String name;

	public Human() {
		this.name = "Human";
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

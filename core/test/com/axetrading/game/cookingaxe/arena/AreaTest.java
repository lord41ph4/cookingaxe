package com.axetrading.game.cookingaxe.arena;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.axetrading.game.cookingaxe.arena.Arena.MapInfo;
import com.axetrading.game.cookingaxe.player.PanCakeJoe;
import com.axetrading.game.cookingaxe.universe.Action;
import com.axetrading.game.cookingaxe.universe.Figure;
import com.axetrading.game.cookingaxe.universe.Inventory;
import com.axetrading.game.cookingaxe.universe.Item;
import com.axetrading.game.cookingaxe.universe.Player;
import com.axetrading.game.cookingaxe.universe.Unique;
import com.axetrading.game.cookingaxe.universe.WorldMap;
import com.axetrading.game.cookingaxe.universe.utils.Vector2d;

public class AreaTest {

	private static class TestFigure implements Figure {

		@Override
		public Action getAction() {
			return null;
		}

		@Override
		public Inventory getInventory() {
			return null;
		}

		@Override
		public Vector2d getDirection() {
			return null;
		}

		@Override
		public void setDirection(Vector2d direction) {

		}

		@Override
		public Player getOwner() {
			return null;
		}

		@Override
		public Vector2d getPosition() {
			return null;
		}

		@Override
		public void setPosition(Vector2d position) {

		}

		@Override
		public Vector2d getOrientation() {
			return null;
		}

		@Override
		public void setOrientation(Vector2d orientation) {

		}

		@Override
		public long getId() {
			return 0;
		}
	}

	private static class TestItem implements Item {

		@Override
		public String getName() {
			return "TestItem";
		}
	}

	private static class TestMap implements WorldMap {

		final List<Figure> figures = new ArrayList<>();
		final List<Item> items = new ArrayList<>();

		@Override
		public List<Figure> getFigures() {
			return figures;
		}

		@Override
		public List<Item> getItems() {
			return items;
		}

		@Override
		public <T extends Unique> T findById(long id) {
			return null;
		}
	}

	@Test
	public void figuresOfMapInfoExposedAsImmutable() {
		MapInfo mapInfo = new MapInfo(new PanCakeJoe(), new TestMap());
		assertThrows(UnsupportedOperationException.class, () -> mapInfo.getFigures()
				.add(new TestFigure()));
		assertThat(mapInfo.getFigures()
				.size(), is(0));
	}

	@Test
	public void itemsOfMapInfoExposedAsImmutable() {
		MapInfo mapInfo = new MapInfo(new PanCakeJoe(), new TestMap());
		assertThrows(UnsupportedOperationException.class, () -> mapInfo.getItems()
				.add(new TestItem()));
		assertThat(mapInfo.getItems()
				.size(), is(0));
	}

}

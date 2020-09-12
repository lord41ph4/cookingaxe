package com.axetrading.game.cookingaxe.arena;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.axetrading.game.cookingaxe.arena.Arena.MapInfo;
import com.axetrading.game.cookingaxe.player.PanCakeJoe;
import com.axetrading.game.cookingaxe.universe.utils.BasicVector2d;

public class MapInfoTest {

	@Test
	public void figuresOfMapInfoExposedAsImmutable() {
		MapInfo mapInfo = new MapInfo(new PanCakeJoe(), new World());
		assertThrows(UnsupportedOperationException.class, () -> mapInfo.getFigures()
				.add(new TestFigure()));
		assertThat(mapInfo.getFigures()
				.size(), is(0));
	}

	@Test
	public void changesOfFiguresInWorldAreReflectedInMapInfo() {
		World world = new World();
		MapInfo mapInfo = new MapInfo(new PanCakeJoe(), world);
		assertThat(mapInfo.getFigures()
				.size(), is(0));
		world.place(new BasicVector2d(0,0), new TestFigure());
		assertThat(mapInfo.getFigures()
				.size(), is(1));
	}

}

package de.alpha_zone.game.cookingaxe.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.alpha_zone.game.cookingaxe.core.Arena.MapInfo;
import de.alpha_zone.game.cookingaxe.player.PanCakeJoe;

public class MapInfoTest {

	@Test
	public void figures_of_MapInfo_exposed_as_immutable() {
		MapInfo mapInfo = new MapInfo(new PanCakeJoe(), new World());
		assertThrows(UnsupportedOperationException.class, () -> mapInfo.getFigures()
				.add(new TestFigure()));
		assertThat(mapInfo.getFigures()
				.size(), is(0));
	}

	@Test
	public void changes_of_figures_in_world_are_reflected_in_MapInfo() {
		World world = new World();
		MapInfo mapInfo = new MapInfo(new PanCakeJoe(), world);
		assertThat(mapInfo.getFigures()
				.size(), is(0));
		world.place(new TestVector(0, 0), new TestFigure());
		assertThat(mapInfo.getFigures()
				.size(), is(1));
	}

}

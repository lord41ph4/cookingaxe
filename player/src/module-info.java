import com.axetrading.game.cookingaxe.player.PanCakeJoe;
import com.axetrading.game.cookingaxe.world.Player;

module cooking.axe.player {

	requires cooking.axe.world;

	provides Player with PanCakeJoe;

}
import com.axetrading.game.cookingaxe.player.Human;
import com.axetrading.game.cookingaxe.player.PanCakeJoe;
import com.axetrading.game.cookingaxe.universe.Player;

module cooking.axe.player {

	requires transitive cooking.axe.universe;

	provides Player with PanCakeJoe, Human;

}
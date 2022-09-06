import de.alpha_zone.game.cookingaxe.player.Human;
import de.alpha_zone.game.cookingaxe.player.PanCakeJoe;
import de.alpha_zone.game.cookingaxe.universe.Player;

module cooking.axe.player {

	requires transitive cooking.axe.universe;

	provides Player with PanCakeJoe, Human;

}
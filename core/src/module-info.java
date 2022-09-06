import de.alpha_zone.game.cookingaxe.universe.Ingredient;
import de.alpha_zone.game.cookingaxe.universe.Player;
import de.alpha_zone.game.cookingaxe.universe.Recipe;
import de.alpha_zone.game.cookingaxe.universe.Scenario;

module cooking.axe.core {

	requires java.base;
	requires kotlin.stdlib;
	requires cooking.axe.universe;
	requires kotlinx.coroutines.core;
	requires kotlinx.coroutines.core.jvm;

	uses Player;
	uses Recipe;
	uses Ingredient;
	uses Scenario;
}
import com.axetrading.game.cookingaxe.universe.Ingredient;
import com.axetrading.game.cookingaxe.universe.Player;
import com.axetrading.game.cookingaxe.universe.Recipe;
import com.axetrading.game.cookingaxe.universe.Scenario;

module cooking.axe.core {

	requires java.base;
	requires kotlin.stdlib;
	requires cooking.axe.universe;
	requires kotlinx.coroutines.core;

	uses Player;
	uses Recipe;
	uses Ingredient;
	uses Scenario;
}
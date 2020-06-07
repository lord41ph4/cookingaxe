import com.axetrading.game.cookingaxe.world.Ingredient;
import com.axetrading.game.cookingaxe.world.Player;
import com.axetrading.game.cookingaxe.world.Recipe;
import com.axetrading.game.cookingaxe.world.Scenario;

module cooking.axe.core {

	requires java.base;
	requires kotlin.stdlib;
	requires cooking.axe.world;
	requires kotlinx.coroutines.core;

	uses Player;
	uses Recipe;
	uses Ingredient;
	uses Scenario;
}
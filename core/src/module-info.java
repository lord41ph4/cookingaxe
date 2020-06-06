import com.axetrading.game.cookingaxe.world.Ingredient;
import com.axetrading.game.cookingaxe.world.Player;
import com.axetrading.game.cookingaxe.world.Recipe;

module cooking.axe.core {

	requires java.base;
	requires kotlin.stdlib;
	requires cooking.axe.world;
	requires kotlinx.coroutines.core;

	uses Player;
	uses Recipe;
	uses Ingredient;
}
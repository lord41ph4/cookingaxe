import com.axetrading.game.cookingaxe.world.Egg;
import com.axetrading.game.cookingaxe.world.Item;
import com.axetrading.game.cookingaxe.world.PanCakeRecipe;
import com.axetrading.game.cookingaxe.world.ScrambledEggsRecipe;

module cooking.axe.world {
	requires annotations;
	requires kotlin.stdlib;

	exports com.axetrading.game.cookingaxe.world;

	provides Item with Egg, PanCakeRecipe, ScrambledEggsRecipe;

}
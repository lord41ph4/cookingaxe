import com.axetrading.game.cookingaxe.world.BasicScenario;
import com.axetrading.game.cookingaxe.world.Ingredient;
import com.axetrading.game.cookingaxe.world.Recipe;
import com.axetrading.game.cookingaxe.world.Scenario;
import com.axetrading.game.cookingaxe.world.ingredients.Egg;
import com.axetrading.game.cookingaxe.world.ingredients.EggWhite;
import com.axetrading.game.cookingaxe.world.ingredients.EggYolk;
import com.axetrading.game.cookingaxe.world.recipes.PanCakeRecipe;
import com.axetrading.game.cookingaxe.world.recipes.ScrambledEggsRecipe;

module cooking.axe.world {
	requires annotations;
	requires kotlin.stdlib;

	exports com.axetrading.game.cookingaxe.world;
	exports com.axetrading.game.cookingaxe.world.utils;

	provides Recipe with PanCakeRecipe, ScrambledEggsRecipe;
	provides Ingredient with Egg, EggWhite, EggYolk;
	provides Scenario with BasicScenario;

}
import com.axetrading.game.cookingaxe.universe.scenario.BasicScenario;
import com.axetrading.game.cookingaxe.universe.Ingredient;
import com.axetrading.game.cookingaxe.universe.Recipe;
import com.axetrading.game.cookingaxe.universe.Scenario;
import com.axetrading.game.cookingaxe.universe.ingredients.Egg;
import com.axetrading.game.cookingaxe.universe.ingredients.EggWhite;
import com.axetrading.game.cookingaxe.universe.ingredients.EggYolk;
import com.axetrading.game.cookingaxe.universe.recipes.PanCakeRecipe;
import com.axetrading.game.cookingaxe.universe.recipes.ScrambledEggsRecipe;

module cooking.axe.world {
	requires annotations;
	requires kotlin.stdlib;
	requires transitive cooking.axe.universe;

	provides Recipe with PanCakeRecipe, ScrambledEggsRecipe;
	provides Ingredient with Egg, EggWhite, EggYolk;
	provides Scenario with BasicScenario;

}
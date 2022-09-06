import de.alpha_zone.game.cookingaxe.universe.Ingredient;
import de.alpha_zone.game.cookingaxe.universe.Recipe;
import de.alpha_zone.game.cookingaxe.universe.ingredients.Egg;
import de.alpha_zone.game.cookingaxe.universe.ingredients.EggWhite;
import de.alpha_zone.game.cookingaxe.universe.ingredients.EggYolk;
import de.alpha_zone.game.cookingaxe.universe.recipes.PanCakeRecipe;
import de.alpha_zone.game.cookingaxe.universe.recipes.ScrambledEggsRecipe;

module cooking.axe.world {
	requires annotations;
	requires kotlin.stdlib;
	requires transitive cooking.axe.universe;

	provides Recipe with PanCakeRecipe, ScrambledEggsRecipe;
	provides Ingredient with Egg, EggWhite, EggYolk;

}
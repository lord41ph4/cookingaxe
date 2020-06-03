import com.axetrading.game.cookingaxe.world.Item;
import com.axetrading.game.cookingaxe.world.Player;

module cooking.axe.core {

	requires java.base;
	requires kotlin.stdlib;
	requires cooking.axe.world;

	uses Player;
	uses Item;
}
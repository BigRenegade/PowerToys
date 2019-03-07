package powertoys.crafting;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import powertoys.registry.RegistryHelper;
import powertoys.util.Reference;

/** Helps with crafting recipe management */
public class RecipeHelper {

	private static final List<IRecipe> RECIPES = RegistryHelper.RECIPES_TO_REGISTER;
	private static int recipeCounter = 0;
	
	/** Add a generic recipe */
	public static void addRecipe(IRecipe recipe) {
		RECIPES.add(recipe.setRegistryName(new ResourceLocation(Reference.MODID, "recipe" + recipeCounter++)));
	}
	
	/** Add a shaped ore recipe */
	public static void addShapedRecipe(ItemStack result, Object... recipe) {
		addRecipe(new ShapedOreRecipe(new ResourceLocation(Reference.MODID, "recipe" + recipeCounter), result, recipe));
	}
	
	/** Add a shapeless ore recipe */
	public static void addShapelessRecipe(ItemStack result, Object... recipe) {
		addRecipe(new ShapelessOreRecipe(new ResourceLocation(Reference.MODID, "recipe" + recipeCounter), result, recipe));
	}

}

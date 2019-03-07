package powertoys.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import powertoys.config.PRConfig;
import powertoys.init.PRBlocks;
import powertoys.init.PRItems;

/** Mod recipes */
public class CraftingManager {

	public static void mainRegistry() {
		addCraftingRecipes();
	}

	/** Add the crafting recipes */
	private static void addCraftingRecipes() {
		// primary recipes

		// blank box
		RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.blank_box, 2), "ABA", "BCB", "ABA", 'A', "logWood", 'B', "plankWood", 'C',
				"stickWood");

		// old recipes enabled
		if (PRConfig.classicRecipes) {

			// storage core
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.storage_core), "ABA", "BCB", "ABA", 'A', "logWood", 'B', "ingotIron", 'C',
					Blocks.CHEST);

			// basic storage box
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.storage_box), "ABA", "B B", "ABA", 'A', "logWood", 'B', Blocks.CHEST);

			// input port
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.input_port), "ABA", "BCB", "ABA", 'A', Blocks.HOPPER, 'B', Blocks.PISTON, 'C',
					"blockQuartz");

			// crafting box
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.crafting_box), "ABA", "BCB", "ABA", 'A', Items.ENDER_EYE, 'B',
					Blocks.CRAFTING_TABLE, 'C', "gemDiamond");

			// search box
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.search_box), "ABA", "BCB", "ABA", 'A', "blockIron", 'B', Items.ENCHANTED_BOOK, 'C',
					Items.COMPASS);

			// sorting box
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.sort_box), "ABA", "BCB", "ABA", 'A', "logWood", 'B', Items.COMPARATOR, 'C',
					Items.MAP);

			// security box
			if (PRConfig.enableSecurity)
				RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.security_box), "ABA", "BCB", "ABA", 'A', "blockIron", 'B', Blocks.IRON_BARS,
						'C', PRItems.key);

		} else { // blank box recipes

			// storage core
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.storage_core), "C", "B", "I", 'B', new ItemStack(PRBlocks.blank_box), 'C',
					Blocks.CHEST, 'I', "ingotIron");

			// basic storage box
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.storage_box), " C ", "CBC", " C ", 'B', new ItemStack(PRBlocks.blank_box), 'C',
					Blocks.CHEST);

			// input port
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.input_port), "HQH", "PBP", "PHP", 'B', new ItemStack(PRBlocks.blank_box), 'H',
					Blocks.HOPPER, 'P', Blocks.PISTON, 'Q', "blockQuartz");

			// crafting box
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.crafting_box), "EDE", "CBC", "CEC", 'B', new ItemStack(PRBlocks.blank_box), 'E',
					Items.ENDER_EYE, 'C', Blocks.CRAFTING_TABLE, 'D', "gemDiamond");

			// search box
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.search_box), "EDE", "CBC", "CEC", 'B', new ItemStack(PRBlocks.blank_box), 'E',
					Items.ENCHANTED_BOOK, 'C', "blockIron", 'D', Items.COMPASS);

			// sorting box
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.sort_box), "EDE", "CBC", "CEC", 'B', new ItemStack(PRBlocks.blank_box), 'E',
					Items.COMPARATOR, 'C', "logWood", 'D', Items.MAP);

			// security box
			if (PRConfig.enableSecurity)
				RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.security_box), "EDE", "CBC", "CEC", 'B', new ItemStack(PRBlocks.blank_box),
						'E', "blockIron", 'C', Blocks.IRON_BARS, 'D', PRItems.key);

		}

		// secondary recipes

		// condensed storage box
		RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.condensed_storage_box), "ACA", "CBC", "ACA", 'A', "blockIron", 'B',
				PRBlocks.storage_box, 'C', Blocks.IRON_BARS);

		// super storage box
		RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.super_storage_box), "ACA", "CBC", "ACA", 'A', "blockGold", 'B',
				PRBlocks.condensed_storage_box, 'C', "nuggetGold");

		// ultra storage box
		RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.ultra_storage_box), "ACA", "CBC", "ACA", 'A', "blockDiamond", 'B',
				PRBlocks.super_storage_box, 'C', "gemDiamond");

		// hyper storage box
		RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.hyper_storage_box), "ABA", "ACA", PRConfig.toughHyper ? "ABA" : "AAA", 'A',
				Blocks.OBSIDIAN, 'B', Items.NETHER_STAR, 'C', PRBlocks.ultra_storage_box);

		// ejection port
		RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.output_port), " D ", "ABA", " A ", 'A', Blocks.PISTON, 'D', Blocks.DISPENSER, 'B',
				PRBlocks.input_port);

		// extraction port
		RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.extract_port), "ICI", "ABA", "ICI", 'A', Blocks.HOPPER, 'C', Items.COMPARATOR, 'I',
				Blocks.IRON_BARS, 'B', PRBlocks.input_port);

		// terminal
		if (PRConfig.enableTerminal)
			RecipeHelper.addShapedRecipe(new ItemStack(PRBlocks.access_terminal), "IXI", "XAX", "IXI", 'X', "paneGlass", 'I', Blocks.IRON_BARS,
					'A', PRBlocks.storage_core);

		// key
		if (PRConfig.enableSecurity)
			RecipeHelper.addShapedRecipe(new ItemStack(PRItems.key), "XXI", "XX ", 'I', "ingotGold", 'X', "nuggetGold");
		
		// dollies
		if (PRConfig.enableDolly) {
			RecipeHelper.addShapedRecipe(new ItemStack(PRItems.dolly_basic), "X X","X X","PPP", 'X',"ingotIron", 'P',Blocks.STONE_PRESSURE_PLATE);
			RecipeHelper.addShapedRecipe(new ItemStack(PRItems.dolly_super), " X "," D "," X ", 'X',"ingotGold", 'D',PRItems.dolly_basic);
		}

	}

}

package powertoys.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import powertoys.config.PRConfig;
import powertoys.util.Reference;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class GuiFactory implements IModGuiFactory
{
	//this class is accessed when Forge needs a GUI made relating to your mod (e.g. mbe.config GUI)

	@Override
	public void initialize(Minecraft minecraftInstance)
	{
		//needed to implement IModGuiFactory but doesn't need to do anything
		// for the configuration gui
	}

  // called when your GUI needs to be created
  public GuiScreen createConfigGui(GuiScreen parentScreen)
  {
    return new PRConfigGui(parentScreen);
  }

  public boolean hasConfigGui() {
    return true;
  }

  // This function is needed for implementation only, the mbe.config gui does not require them
  @Override
  public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
  {
    return null;
  }

  //This class inherits from GuiConfig, a specialized GuiScreen designed to display your
	// configuration categories
	public static class PRConfigGui extends GuiConfig
	{
		public PRConfigGui(GuiScreen parentScreen)
		{
			//I18n function basically "translates" or localizes the given key using the appropriate .lang file
			super(parentScreen, getConfigElements(), Reference.MODID,
            false, false, I18n.format(Reference.mainTitle));
		}

		private static List<IConfigElement> getConfigElements()
		{
			List<IConfigElement> list = new ArrayList<IConfigElement>();
			//Add the two buttons that will go to each mbe.config category edit screen
			list.add(new DummyCategoryElement("Main", "gui.ctgy.Main", CategoryEntryMain.class));
			return list;
		}

		//the next two classes are the edit screens for each configuration category
		public static class CategoryEntryMain extends CategoryEntry
		{
			public CategoryEntryMain(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen()
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the mbe.config file for the category as
				// the title for the category mbe.config screen

        Configuration configuration = PRConfig.getConfig();
        ConfigElement cat_general = new ConfigElement(configuration.getCategory(PRConfig.CATEGORY_NAME_MAIN));
        List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
        String windowTitle = configuration.toString();

        return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                              this.owningScreen.modID,
                              PRConfig.CATEGORY_NAME_MAIN,
                              this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                              this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                              windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}

		public static class CategoryEntryMisc extends CategoryEntry
		{
			public CategoryEntryMisc(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen()
			{
        Configuration configuration = PRConfig.getConfig();
        ConfigElement cat_general = new ConfigElement(configuration.getCategory(PRConfig.CATEGORY_NAME_MISC));
        List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
        String windowTitle = configuration.toString();

        return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                             this.owningScreen.modID,
                             PRConfig.CATEGORY_NAME_MISC,
                             this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                             this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                             windowTitle);
        //this is a complicated object that specifies the category's gui screen, to better understand
        // how it works, look into the definitions of the called functions and objects
			}
		}
		
		//the next two classes are the edit screens for each configuration category
		public static class CategoryEntryStorage extends CategoryEntry
		{
			public CategoryEntryStorage(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen()
			{
				//The following GuiConfig object specifies the configID of the object and thus will force-save
				// when closed.
				//Parent GuiConfig object's entryList will also be refreshed to reflect the changes.
				// --see GuiFactory of Forge for more info
				//Additionally, Forge best practices say to put the path to the mbe.config file for the category as
				// the title for the category mbe.config screen

        Configuration configuration = PRConfig.getConfig();
        ConfigElement cat_general = new ConfigElement(configuration.getCategory(PRConfig.CATEGORY_NAME_MAIN));
        List<IConfigElement> propertiesOnThisScreen = cat_general.getChildElements();
        String windowTitle = configuration.toString();

        return new GuiConfig(this.owningScreen, propertiesOnThisScreen,
                              this.owningScreen.modID,
                              PRConfig.CATEGORY_NAME_STORAGE,
                              this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
                              this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
                              windowTitle);
				//this is a complicated object that specifies the category's gui screen, to better understand
				// how it works, look into the definitions of the called functions and objects
			}
		}
	}
}

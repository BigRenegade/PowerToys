package powertoys.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import powertoys.PowerToys;
import powertoys.util.Log;
import powertoys.util.Reference;

/** The config settings */
public class PRConfig {

	public static int basicCapacity;
	public static int condensedCapacity;
	public static int superCapacity;
	public static int ultraCapacity;
	public static int hyperCapacity;
	public static boolean classicRecipes;
	public static boolean toughHyper;
	public static boolean enableTerminal;
	public static boolean enableSecurity;
	public static boolean enableSearchModes;
	public static boolean enableOpOverride;
	public static boolean enableDolly;
	public static boolean jeiIntegration;
	
	public static final String CATEGORY_NAME_MAIN = "Main";
	public static final String CATEGORY_NAME_MISC = "Misc";
	public static final String CATEGORY_NAME_STORAGE = "Storage";

	public static void preInit()
	{
		/*
		 * Here is where you specify the location from where your config file
		 * will be read, or created if it is not present.
		 *
		 * Loader.instance().getConfigDir() returns the default config directory
		 * and you specify the name of the config file, together this works
		 * similar to the old getSuggestedConfigurationFile() function.
		 */
		File configFile = new File(Loader.instance().getConfigDir(), Reference.MODID + ".cfg");

		// initialize your configuration object with your configuration file values.
		config = new Configuration(configFile);

		// load config from file (see mbe70 package for more info)
		syncFromFile();
	}

	public static Configuration getConfig() {
		return config;
	}

	/**
	 * load the configuration values from the configuration file
	 */
	public static void syncFromFile() {
		syncConfig(true, true);
	}

	/**
	 * save the GUI-altered values to disk
	 */
	public static void syncFromGUI() {
		syncConfig(false, true);
	}

	/**
	 * save the HBTConfiguration variables (fields) to disk
	 */
	public static void syncFromFields() {
		syncConfig(false, false);
	}

	/**
	 * Synchronise the three copies of the data
	 * 1) loadConfigFromFile && readFieldsFromConfig -> initialise everything from the disk file.
	 * 2) !loadConfigFromFile && readFieldsFromConfig --> copy everything from the config file (altered by GUI).
	 * 3) !loadConfigFromFile && !readFieldsFromConfig --> copy everything from the native fields.
	 *
	 * @param loadConfigFromFile if true, load the config field from the configuration file on disk.
	 * @param readFieldsFromConfig if true, reload the member variables from the config field.
	 */

	public static void syncConfig(boolean loadConfigFromFile, boolean readFieldsFromConfig)
	{
		/*
		 * ---- step 1 - load raw values from config file (if loadFromFile true) -------------------
		 *
		 * Check if this configuration object is the main config file or a child
		 * configuration For simple configuration setups, this only matters if
		 * you enable global configuration for your configuration object by
		 * using config.enableGlobalConfiguration(), this will cause your config
		 * file to be 'global.cfg' in the default configuration directory and
		 * use it to read/write your configuration options
		 */
		if (loadConfigFromFile) {
			config.load();
		}

		/*
		 * Using language keys are a good idea if you are using a config GUI
		 * This allows you to provide "pretty" names for the config properties
		 * in a .assets.lang file as well as allow others to provide other
		 * localizations for your mod.
		 *
		 * The language key is also used to get the tooltip for your property,
		 * the language key for each properties tooltip is langKey + ".tooltip"
		 * If no tooltip assets.lang key is specified in a .assets.lang file, it will default
		 * to the property's comment field.
		 *
		 * prop.setRequiresWorldRestart(true); and
		 * prop.setRequiresMcRestart(true); can be used to tell Forge if that
		 * specific property requires a world or complete Minecraft restart,
		 * respectively.
		 *
		 * Note: if a property requires a world restart it cannot be edited in
		 * the in-world mod settings (which hasn't been implemented yet by
		 * Forge), only when a world isn't loaded.
		 *
		 * -See the function definitions for more info
		 */

		/*
		 * ---- step 2 - define the properties in the configuration file -------------------
		 *
		 * The following code is used to define the properties in the
		 * configuration file: their name, type, default / min / max values, a
		 * comment. These affect what is displayed on the GUI. If the file
		 * already exists, the property values will already have been read from
		 * the file, otherwise they will be assigned the default value.
		 */


		final int BASIC_CAPACITY_MIN_VALUE = 100;
		final int BASIC_CAPACITY_MAX_VALUE = 4000;
		final int BASIC_CAPACITY_DEFAULT_VALUE = 400;
		Property propBasicCapacityInt = config.get(CATEGORY_NAME_MAIN, "basicCapacity", BASIC_CAPACITY_DEFAULT_VALUE);
		propBasicCapacityInt.setComment("Configuration integer (basicCapacity)   MIN: " + BASIC_CAPACITY_MIN_VALUE + "     Max: " + BASIC_CAPACITY_MAX_VALUE + "     Default:  " + BASIC_CAPACITY_DEFAULT_VALUE);
		propBasicCapacityInt.setLanguageKey("basicCapacity");

		final int CONDENSED_CAPACITY_MIN_VALUE = 100;
		final int CONDENSED_CAPACITY_MAX_VALUE = 40000;
		final int CONDENSED_CAPACITY_DEFAULT_VALUE = 4000;
		Property propCondensedCapacityInt = config.get(CATEGORY_NAME_MAIN, "condensedCapacity", CONDENSED_CAPACITY_DEFAULT_VALUE);
		propCondensedCapacityInt.setComment("Configuration integer (condensedCapacity)   MIN: " + CONDENSED_CAPACITY_MIN_VALUE + "     Max: " + CONDENSED_CAPACITY_MAX_VALUE + "     Default:  " + CONDENSED_CAPACITY_DEFAULT_VALUE);
		propCondensedCapacityInt.setLanguageKey("condensedCapacity");

		final int SUPER_CAPACITY_MIN_VALUE = 100;
		final int SUPER_CAPACITY_MAX_VALUE = 100000;
		final int SUPER_CAPACITY_DEFAULT_VALUE = 20000;
		Property propSuperCapacityInt = config.get(CATEGORY_NAME_MAIN, "superCapacity", SUPER_CAPACITY_DEFAULT_VALUE, "Configuration integer (superCapacity)", SUPER_CAPACITY_MIN_VALUE, SUPER_CAPACITY_MAX_VALUE);
		propSuperCapacityInt.setComment("Configuration integer (superCapacity)   MIN: " + SUPER_CAPACITY_MIN_VALUE + "     Max: " + SUPER_CAPACITY_MAX_VALUE + "     Default:  " + SUPER_CAPACITY_DEFAULT_VALUE);
		propSuperCapacityInt.setLanguageKey("superCapacity");

		final int ULTRA_CAPACITY_MIN_VALUE = 100;
		final int ULTRA_CAPACITY_MAX_VALUE = 400000;
		final int ULTRA_CAPACITY_DEFAULT_VALUE = 80000;
		Property propUltraCapacityInt = config.get(CATEGORY_NAME_MAIN, "ultraCapacity", ULTRA_CAPACITY_DEFAULT_VALUE);
		propUltraCapacityInt.setComment("Configuration integer (ultraCapacity)   MIN: " + ULTRA_CAPACITY_MIN_VALUE + "     Max: " + ULTRA_CAPACITY_MAX_VALUE + "     Default:  " + ULTRA_CAPACITY_DEFAULT_VALUE);
		propUltraCapacityInt.setLanguageKey("ultraCapacity");

		final int HYPER_CAPACITY_MIN_VALUE = 100;
		final int HYPER_CAPACITY_MAX_VALUE = 4000000;
		final int HYPER_CAPACITY_DEFAULT_VALUE = 400000;
		Property propHyperCapacityInt = config.get(CATEGORY_NAME_MAIN, "hyperCapacity", HYPER_CAPACITY_DEFAULT_VALUE);
		propHyperCapacityInt.setComment("Configuration integer (hyperCapacity)   MIN: " + HYPER_CAPACITY_MIN_VALUE + "     Max: " + HYPER_CAPACITY_MAX_VALUE + "     Default:  " + HYPER_CAPACITY_DEFAULT_VALUE);
		propHyperCapacityInt.setLanguageKey("hyperCapacity");

		final boolean RECIPE_DEFAULT_VALUE = true;
		Property propClassicRecipesBool = config.get(CATEGORY_NAME_MAIN, "classicRecipes", RECIPE_DEFAULT_VALUE);
		propClassicRecipesBool.setComment("If true, classic recipes (not using blank boxes) will be used.");
		propClassicRecipesBool.setLanguageKey("classicRecipes");

		final boolean TOUGH_HYPER_DEFAULT_VALUE = false;
		Property propToughHyperBool = config.get(CATEGORY_NAME_MAIN, "toughHyper", TOUGH_HYPER_DEFAULT_VALUE);
		propToughHyperBool.setComment("If true, the hyper storage box will use 2 nether stars instead of 1.");
		propToughHyperBool.setLanguageKey("toughHyper");

		final boolean ENABLE_TERMINAL_DEFAULT_VALUE = true;
		Property propEnableTerminalBool = config.get(CATEGORY_NAME_MAIN, "enableTerminal", ENABLE_TERMINAL_DEFAULT_VALUE);
		propEnableTerminalBool.setComment("Should the access terminal be enabled?");
		propEnableTerminalBool.setLanguageKey("enableTerminal");

		final boolean ENABLE_SECURITY_DEFAULT_VALUE = true;
		Property propEnableSecurityBool = config.get(CATEGORY_NAME_MAIN, "enableSecurity", ENABLE_SECURITY_DEFAULT_VALUE);
		propEnableSecurityBool.setComment("Should the security features be enabled?");
		propEnableSecurityBool.setLanguageKey("enableSecurity");

		final boolean ENABLE_SEARCH_DEFAULT_VALUE = true;
		Property propEnableSearchModesBool = config.get(CATEGORY_NAME_MAIN, "enableSearchModes", ENABLE_SEARCH_DEFAULT_VALUE);
		propEnableSearchModesBool.setComment("Should '$' in front of a term search ore dictionary names, '@' search mod ids and names, and '%' search creative tab names?");
		propEnableSearchModesBool.setLanguageKey("enableSearchModes");

		final boolean ENABLE_OPOVERRIDE_DEFAULT_VALUE = true;
		Property propEnableOpOverrideBool = config.get(CATEGORY_NAME_MAIN, "enableOpOverride", ENABLE_OPOVERRIDE_DEFAULT_VALUE);
		propEnableOpOverrideBool.setComment("Should a server op with permission level 2+ in creative mode be able to override the security of systems on their server?");
		propEnableOpOverrideBool.setLanguageKey("enableOpOverride");

		final boolean ENABLE_DOLLY_DEFAULT_VALUE = true;
		Property propEnableDollyBool = config.get(CATEGORY_NAME_MAIN, "enableDolly", ENABLE_DOLLY_DEFAULT_VALUE);
		propEnableDollyBool.setComment("Should dollies, which can move storage cores (while respecting security), be enabled?");
		propEnableDollyBool.setLanguageKey("enableDolly");

		final boolean JEI_INTEGRATION_DEFAULT_VALUE = true;
		Property propEnableJeiBool = config.get(CATEGORY_NAME_MAIN, "jeiIntegration", JEI_INTEGRATION_DEFAULT_VALUE);
		propEnableJeiBool.setComment("Integrate "  + Reference.MODNAME + " with JEI?");
		propEnableJeiBool.setLanguageKey("jeiIntegration");

		// By defining a property order we can control the order of the
		// properties in the config file and GUI. This is defined on a per config-category basis.

		List<String> propOrderMain = new ArrayList<String>();
		propOrderMain.add(propBasicCapacityInt.getName());
		propOrderMain.add(propCondensedCapacityInt.getName());
		propOrderMain.add(propSuperCapacityInt.getName());
		propOrderMain.add(propUltraCapacityInt.getName());
		propOrderMain.add(propHyperCapacityInt.getName());
		propOrderMain.add(propClassicRecipesBool.getName());
		propOrderMain.add(propToughHyperBool.getName());
		propOrderMain.add(propEnableTerminalBool.getName());
		propOrderMain.add(propEnableSecurityBool.getName());
		propOrderMain.add(propEnableSearchModesBool.getName());
		propOrderMain.add(propEnableOpOverrideBool.getName());
		propOrderMain.add(propEnableOpOverrideBool.getName());
		propOrderMain.add(propEnableDollyBool.getName());
		propOrderMain.add(propEnableJeiBool.getName());
		config.setCategoryPropertyOrder(CATEGORY_NAME_MAIN, propOrderMain);

		
		/*
		 * ---- step 3 - read the configuration property values into the class's  -------------------
		 *               variables (if readFieldsFromConfig)
		 *
		 * As each value is read from the property, it should be checked to make
		 * sure it is valid, in case someone has manually edited or corrupted
		 * the value. The get() methods don't check that the value is in range
		 * even if you have specified a MIN and MAX value of the property.
		 */

		if (readFieldsFromConfig)
		{
			// If getInt() cannot get an integer value from the config file
			// value of myInteger (e.g. corrupted file).
			// It will set it to the default value passed to the function.

			basicCapacity = propBasicCapacityInt.getInt(BASIC_CAPACITY_DEFAULT_VALUE);
			if (basicCapacity > BASIC_CAPACITY_MAX_VALUE || basicCapacity < BASIC_CAPACITY_MIN_VALUE) {
				basicCapacity = BASIC_CAPACITY_DEFAULT_VALUE;
			}

			condensedCapacity = propCondensedCapacityInt.getInt(CONDENSED_CAPACITY_DEFAULT_VALUE);
			if (condensedCapacity > CONDENSED_CAPACITY_MAX_VALUE || condensedCapacity < CONDENSED_CAPACITY_MIN_VALUE) {
				condensedCapacity = CONDENSED_CAPACITY_DEFAULT_VALUE;
			}

			superCapacity = propSuperCapacityInt.getInt(SUPER_CAPACITY_DEFAULT_VALUE);
			if (superCapacity > SUPER_CAPACITY_MAX_VALUE || superCapacity < SUPER_CAPACITY_MIN_VALUE) {
				superCapacity = SUPER_CAPACITY_DEFAULT_VALUE;
			}

			ultraCapacity = propUltraCapacityInt.getInt(ULTRA_CAPACITY_DEFAULT_VALUE);
			if (ultraCapacity > ULTRA_CAPACITY_MAX_VALUE || ultraCapacity < ULTRA_CAPACITY_MIN_VALUE) {
				ultraCapacity = ULTRA_CAPACITY_DEFAULT_VALUE;
			}

			hyperCapacity = propHyperCapacityInt.getInt(HYPER_CAPACITY_DEFAULT_VALUE);
			if (hyperCapacity > HYPER_CAPACITY_MAX_VALUE || hyperCapacity < HYPER_CAPACITY_MIN_VALUE) {
				hyperCapacity = HYPER_CAPACITY_DEFAULT_VALUE;
			}

			classicRecipes = propClassicRecipesBool.getBoolean(RECIPE_DEFAULT_VALUE); // can also use a literal (see integer example) if desired

			toughHyper = propToughHyperBool.getBoolean(TOUGH_HYPER_DEFAULT_VALUE); // can also use a literal (see integer example) if desired

			enableTerminal = propEnableTerminalBool.getBoolean(ENABLE_TERMINAL_DEFAULT_VALUE); // can also use a literal (see integer example) if desired

			enableSecurity = propEnableSecurityBool.getBoolean(ENABLE_SECURITY_DEFAULT_VALUE); // can also use a literal (see integer example) if desired

			enableSearchModes = propEnableSearchModesBool.getBoolean(ENABLE_SEARCH_DEFAULT_VALUE); // can also use a literal (see integer example) if desired

			enableOpOverride = propEnableOpOverrideBool.getBoolean(ENABLE_OPOVERRIDE_DEFAULT_VALUE); // can also use a literal (see integer example) if desired
			
			enableDolly = propEnableDollyBool.getBoolean(ENABLE_DOLLY_DEFAULT_VALUE); // can also use a literal (see integer example) if desired
			
			jeiIntegration = propEnableJeiBool.getBoolean(JEI_INTEGRATION_DEFAULT_VALUE); // can also use a literal (see integer example) if desired

		}

		/*
		 * ---- step 4 - write the class's variables back into the config  -------------------
		 *               properties and save to disk
		 *
		 * This is done even for a 'loadFromFile==true', because some of the
		 * properties may have been assigned default values if the file was empty or corrupt.
		 */

		propBasicCapacityInt.set(basicCapacity);
		propCondensedCapacityInt.set(condensedCapacity);
		propSuperCapacityInt.set(superCapacity);
		propUltraCapacityInt.set(ultraCapacity);
		propHyperCapacityInt.set(hyperCapacity);
		propClassicRecipesBool.set(classicRecipes);
		propToughHyperBool.set(toughHyper);
		propEnableTerminalBool.set(enableTerminal);
		propEnableSecurityBool.set(enableSecurity);
		propEnableSearchModesBool.set(enableSearchModes);
		propEnableOpOverrideBool.set(enableOpOverride);
		propEnableDollyBool.set(enableDolly);
		propEnableJeiBool.set(jeiIntegration);
		if (config.hasChanged()) {
			config.save();
		}
	}

	// Define your configuration object
	private static Configuration config = null;

	public static class ConfigEventHandler
	{
		/*
	     * This class, when instantiated as an object, will listen on the Forge
	     * event bus for an OnConfigChangedEvent
	     */
		@SubscribeEvent(priority = EventPriority.NORMAL)
		public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event)
		{
			if (Reference.MODID.equals(event.getModID()) && !event.isWorldRunning())
			{
				if (event.getConfigID().equals(CATEGORY_NAME_MAIN)
						|| event.getConfigID().equals(CATEGORY_NAME_MAIN)
						|| event.getConfigID().equals(CATEGORY_NAME_MISC) 
						)
				{
					syncFromGUI();
				}
			}
		}
	}
	
}

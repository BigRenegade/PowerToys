package powertoys.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.ResourceLocation;
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
public class StorageConfig {

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
	public static final String CATEGORY_NAME_MUSIC = "Music";
	public static final String CATEGORY_NAME_STORAGE = "Storage";
	private static final String writeJSON = null;

	public static String Record001;
	public static String Record002;
	public static String Record003;
	public static String Record004;
	public static String Record005;
	public static String Record006;
	public static String Record007;
	public static String Record008;
	public static String Record009;
	public static String Record010;
	public static String Record011;
	public static String Record012;
	public static String Record013;
	public static String Record014;
	public static String Record015;
	public static String Record016;
	public static String Record017;
	public static String Record018;
	public static String Record019;
	public static String Record020;
	public static String Record021;
	public static String Record022;
	public static String Record023;
	public static String Record024;
	public static String Record025;
	
	
	
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
		File configFile = new File(Loader.instance().getConfigDir() + "/" + Reference.MODID, "Storage.cfg");

		String tmp;
		
		tmp = Loader.instance().getConfigDir().toString() + "\\" + Reference.MODID + "\\sounds\\";
		PowerToys.resourceLocale = tmp;
		tmp = tmp.substring(0, 3);
		
		//PowerToys.resourceLocale = tmp + PowerToys.resourceLocale.substring(34, PowerToys.resourceLocale.length());
		
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
		Property propBasicCapacityInt = config.get(CATEGORY_NAME_STORAGE, "basicCapacity", BASIC_CAPACITY_DEFAULT_VALUE);
		propBasicCapacityInt.setComment("Configuration integer (basicCapacity)   MIN: " + BASIC_CAPACITY_MIN_VALUE + "     Max: " + BASIC_CAPACITY_MAX_VALUE + "     Default:  " + BASIC_CAPACITY_DEFAULT_VALUE);
		propBasicCapacityInt.setLanguageKey("basicCapacity");

		final int CONDENSED_CAPACITY_MIN_VALUE = 100;
		final int CONDENSED_CAPACITY_MAX_VALUE = 40000;
		final int CONDENSED_CAPACITY_DEFAULT_VALUE = 4000;
		Property propCondensedCapacityInt = config.get(CATEGORY_NAME_STORAGE, "condensedCapacity", CONDENSED_CAPACITY_DEFAULT_VALUE);
		propCondensedCapacityInt.setComment("Configuration integer (condensedCapacity)   MIN: " + CONDENSED_CAPACITY_MIN_VALUE + "     Max: " + CONDENSED_CAPACITY_MAX_VALUE + "     Default:  " + CONDENSED_CAPACITY_DEFAULT_VALUE);
		propCondensedCapacityInt.setLanguageKey("condensedCapacity");

		final int SUPER_CAPACITY_MIN_VALUE = 100;
		final int SUPER_CAPACITY_MAX_VALUE = 100000;
		final int SUPER_CAPACITY_DEFAULT_VALUE = 20000;
		Property propSuperCapacityInt = config.get(CATEGORY_NAME_STORAGE, "superCapacity", SUPER_CAPACITY_DEFAULT_VALUE, "Configuration integer (superCapacity)", SUPER_CAPACITY_MIN_VALUE, SUPER_CAPACITY_MAX_VALUE);
		propSuperCapacityInt.setComment("Configuration integer (superCapacity)   MIN: " + SUPER_CAPACITY_MIN_VALUE + "     Max: " + SUPER_CAPACITY_MAX_VALUE + "     Default:  " + SUPER_CAPACITY_DEFAULT_VALUE);
		propSuperCapacityInt.setLanguageKey("superCapacity");
		

		final int ULTRA_CAPACITY_MIN_VALUE = 100;
		final int ULTRA_CAPACITY_MAX_VALUE = 400000;
		final int ULTRA_CAPACITY_DEFAULT_VALUE = 80000;
		Property propUltraCapacityInt = config.get(CATEGORY_NAME_STORAGE, "ultraCapacity", ULTRA_CAPACITY_DEFAULT_VALUE);
		propUltraCapacityInt.setComment("Configuration integer (ultraCapacity)   MIN: " + ULTRA_CAPACITY_MIN_VALUE + "     Max: " + ULTRA_CAPACITY_MAX_VALUE + "     Default:  " + ULTRA_CAPACITY_DEFAULT_VALUE);
		propUltraCapacityInt.setLanguageKey("ultraCapacity");

		final int HYPER_CAPACITY_MIN_VALUE = 100;
		final int HYPER_CAPACITY_MAX_VALUE = 4000000;
		final int HYPER_CAPACITY_DEFAULT_VALUE = 400000;
		Property propHyperCapacityInt = config.get(CATEGORY_NAME_STORAGE, "hyperCapacity", HYPER_CAPACITY_DEFAULT_VALUE);
		propHyperCapacityInt.setComment("Configuration integer (hyperCapacity)   MIN: " + HYPER_CAPACITY_MIN_VALUE + "     Max: " + HYPER_CAPACITY_MAX_VALUE + "     Default:  " + HYPER_CAPACITY_DEFAULT_VALUE);
		propHyperCapacityInt.setLanguageKey("hyperCapacity");

		final boolean RECIPE_DEFAULT_VALUE = true;
		Property propClassicRecipesBool = config.get(CATEGORY_NAME_STORAGE, "classicRecipes", RECIPE_DEFAULT_VALUE);
		propClassicRecipesBool.setComment("If true, classic recipes (not using blank boxes) will be used.");
		propClassicRecipesBool.setLanguageKey("classicRecipes");

		final boolean TOUGH_HYPER_DEFAULT_VALUE = false;
		Property propToughHyperBool = config.get(CATEGORY_NAME_STORAGE, "toughHyper", TOUGH_HYPER_DEFAULT_VALUE);
		propToughHyperBool.setComment("If true, the hyper storage box will use 2 nether stars instead of 1.");
		propToughHyperBool.setLanguageKey("toughHyper");

		final boolean ENABLE_TERMINAL_DEFAULT_VALUE = true;
		Property propEnableTerminalBool = config.get(CATEGORY_NAME_STORAGE, "enableTerminal", ENABLE_TERMINAL_DEFAULT_VALUE);
		propEnableTerminalBool.setComment("Should the access terminal be enabled?");
		propEnableTerminalBool.setLanguageKey("enableTerminal");

		final boolean ENABLE_SECURITY_DEFAULT_VALUE = true;
		Property propEnableSecurityBool = config.get(CATEGORY_NAME_STORAGE, "enableSecurity", ENABLE_SECURITY_DEFAULT_VALUE);
		propEnableSecurityBool.setComment("Should the security features be enabled?");
		propEnableSecurityBool.setLanguageKey("enableSecurity");

		final boolean ENABLE_SEARCH_DEFAULT_VALUE = true;
		Property propEnableSearchModesBool = config.get(CATEGORY_NAME_STORAGE, "enableSearchModes", ENABLE_SEARCH_DEFAULT_VALUE);
		propEnableSearchModesBool.setComment("Should '$' in front of a term search ore dictionary names, '@' search mod ids and names, and '%' search creative tab names?");
		propEnableSearchModesBool.setLanguageKey("enableSearchModes");

		final boolean ENABLE_OPOVERRIDE_DEFAULT_VALUE = true;
		Property propEnableOpOverrideBool = config.get(CATEGORY_NAME_STORAGE, "enableOpOverride", ENABLE_OPOVERRIDE_DEFAULT_VALUE);
		propEnableOpOverrideBool.setComment("Should a server op with permission level 2+ in creative mode be able to override the security of systems on their server?");
		propEnableOpOverrideBool.setLanguageKey("enableOpOverride");

		final boolean ENABLE_DOLLY_DEFAULT_VALUE = true;
		Property propEnableDollyBool = config.get(CATEGORY_NAME_STORAGE, "enableDolly", ENABLE_DOLLY_DEFAULT_VALUE);
		propEnableDollyBool.setComment("Should dollies, which can move storage cores (while respecting security), be enabled?");
		propEnableDollyBool.setLanguageKey("enableDolly");

		final boolean JEI_INTEGRATION_DEFAULT_VALUE = true;
		Property propEnableJeiBool = config.get(CATEGORY_NAME_STORAGE, "jeiIntegration", JEI_INTEGRATION_DEFAULT_VALUE);
		propEnableJeiBool.setComment("Integrate "  + Reference.MODNAME + " with JEI?");
		propEnableJeiBool.setLanguageKey("jeiIntegration");

		// By defining a property order we can control the order of the
		// properties in the config file and GUI. This is defined on a per config-category basis.

		final boolean WRITE_JSON_DEFAULT_VALUE = false;
		Property propEnableWriteJSONBool = config.get(CATEGORY_NAME_MAIN, "writeJSON", WRITE_JSON_DEFAULT_VALUE);
		propEnableWriteJSONBool.setComment("Allow mod to write the sounds.json file for you? (true/false)   deault = false");
		propEnableWriteJSONBool.setLanguageKey("PowerToys.writeJSON");

		List<String> propOrderMain = new ArrayList<String>();
		propOrderMain.add(propEnableWriteJSONBool.getName());
		config.setCategoryPropertyOrder(CATEGORY_NAME_MAIN, propOrderMain);

		
		List<String> propOrderSTORAGE = new ArrayList<String>();
		propOrderSTORAGE.add(propBasicCapacityInt.getName());
		propOrderSTORAGE.add(propCondensedCapacityInt.getName());
		propOrderSTORAGE.add(propSuperCapacityInt.getName());
		propOrderSTORAGE.add(propUltraCapacityInt.getName());
		propOrderSTORAGE.add(propHyperCapacityInt.getName());
		propOrderSTORAGE.add(propClassicRecipesBool.getName());
		propOrderSTORAGE.add(propToughHyperBool.getName());
		propOrderSTORAGE.add(propEnableTerminalBool.getName());
		propOrderSTORAGE.add(propEnableSecurityBool.getName());
		propOrderSTORAGE.add(propEnableSearchModesBool.getName());
		propOrderSTORAGE.add(propEnableOpOverrideBool.getName());
		propOrderSTORAGE.add(propEnableOpOverrideBool.getName());
		propOrderSTORAGE.add(propEnableDollyBool.getName());
		propOrderSTORAGE.add(propEnableJeiBool.getName());
		config.setCategoryPropertyOrder(CATEGORY_NAME_STORAGE, propOrderSTORAGE);

		
		final String RECORD001 = "Your song name";
		Property propRecord001String = config.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord001String.setComment("You must set up your songs in the following manner:  \n"
				+ "1)  Place your song in the powertoys/sounds folder.  " + PowerToys.resourceLocale + "\n"
				
				+ "2)  All songs should be in lower case with NO special\n"
				+ "    characters. You can use _ to separate words\n"
				+ "3)  After each record name place the name of your song, like so:\n"
				+ "    Record001 = kissthis    or    Record001 = kiss_this\n");
		propRecord001String.setLanguageKey("Record001");


		final String RECORD002 = "Your song name";
		Property propRecord002String = config.get(CATEGORY_NAME_MUSIC, "Record002", RECORD002);
		propRecord002String.setLanguageKey("Record002");

		final String RECORD003 = "Your song name";
		Property propRecord003String = config.get(CATEGORY_NAME_MUSIC, "Record003", RECORD003);
		propRecord003String.setLanguageKey("Record003");

		final String RECORD004 = "Your song name";
		Property propRecord004String = config.get(CATEGORY_NAME_MUSIC, "Record004", RECORD004);
		propRecord004String.setLanguageKey("Record004");

		final String RECORD005 = "Your song name";
		Property propRecord005String = config.get(CATEGORY_NAME_MUSIC, "Record005", RECORD005);
		propRecord005String.setLanguageKey("Record005");

		final String RECORD006 = "Your song name";
		Property propRecord006String = config.get(CATEGORY_NAME_MUSIC, "Record006", RECORD006);
		propRecord006String.setLanguageKey("Record006");

		final String RECORD007 = "Your song name";
		Property propRecord007String = config.get(CATEGORY_NAME_MUSIC, "Record007", RECORD007);
		propRecord007String.setLanguageKey("Record007");

		final String RECORD008 = "Your song name";
		Property propRecord008String = config.get(CATEGORY_NAME_MUSIC, "Record008", RECORD008);
		propRecord008String.setLanguageKey("Record008");

		final String RECORD009 = "Your song name";
		Property propRecord009String = config.get(CATEGORY_NAME_MUSIC, "Record009", RECORD009);
		propRecord009String.setLanguageKey("Record009");

		final String RECORD010 = "Your song name";
		Property propRecord010String = config.get(CATEGORY_NAME_MUSIC, "Record010", RECORD010);
		propRecord010String.setLanguageKey("Record010");

		final String RECORD011 = "Your song name";
		Property propRecord011String = config.get(CATEGORY_NAME_MUSIC, "Record011", RECORD011);
		propRecord011String.setLanguageKey("Record011");

		final String RECORD012 = "Your song name";
		Property propRecord012String = config.get(CATEGORY_NAME_MUSIC, "Record012", RECORD012);
		propRecord012String.setLanguageKey("Record012");

		final String RECORD013 = "Your song name";
		Property propRecord013String = config.get(CATEGORY_NAME_MUSIC, "Record013", RECORD013);
		propRecord013String.setLanguageKey("Record013");

		final String RECORD014 = "Your song name";
		Property propRecord014String = config.get(CATEGORY_NAME_MUSIC, "Record014", RECORD014);
		propRecord014String.setLanguageKey("Record014");

		final String RECORD015 = "Your song name";
		Property propRecord015String = config.get(CATEGORY_NAME_MUSIC, "Record015", RECORD015);
		propRecord015String.setLanguageKey("Record015");

		final String RECORD016 = "Your song name";
		Property propRecord016String = config.get(CATEGORY_NAME_MUSIC, "Record016", RECORD016);
		propRecord016String.setLanguageKey("Record016");

		final String RECORD017 = "Your song name";
		Property propRecord017String = config.get(CATEGORY_NAME_MUSIC, "Record017", RECORD017);
		propRecord017String.setLanguageKey("Record017");

		final String RECORD018 = "Your song name";
		Property propRecord018String = config.get(CATEGORY_NAME_MUSIC, "Record018", RECORD018);
		propRecord018String.setLanguageKey("Record018");

		final String RECORD019 = "Your song name";
		Property propRecord019String = config.get(CATEGORY_NAME_MUSIC, "Record019", RECORD019);
		propRecord019String.setLanguageKey("Record019");

		final String RECORD020 = "Your song name";
		Property propRecord020String = config.get(CATEGORY_NAME_MUSIC, "Record020", RECORD020);
		propRecord020String.setLanguageKey("Record020");

		final String RECORD021 = "Your song name";
		Property propRecord021String = config.get(CATEGORY_NAME_MUSIC, "Record021", RECORD021);
		propRecord021String.setLanguageKey("Record021");

		final String RECORD022 = "Your song name";
		Property propRecord022String = config.get(CATEGORY_NAME_MUSIC, "Record022", RECORD022);
		propRecord022String.setLanguageKey("Record022");

		final String RECORD023 = "Your song name";
		Property propRecord023String = config.get(CATEGORY_NAME_MUSIC, "Record023", RECORD023);
		propRecord023String.setLanguageKey("Record023");

		final String RECORD024 = "Your song name";
		Property propRecord024String = config.get(CATEGORY_NAME_MUSIC, "Record024", RECORD024);
		propRecord024String.setLanguageKey("Record024");

		final String RECORD025 = "Your song name";
		Property propRecord025String = config.get(CATEGORY_NAME_MUSIC, "Record025", RECORD025);
		propRecord025String.setLanguageKey("Record025");

		List<String> propOrderRecords = new ArrayList<String>();
		propOrderRecords.add(propRecord001String.getName());
		propOrderRecords.add(propRecord002String.getName());
		propOrderRecords.add(propRecord003String.getName());
		propOrderRecords.add(propRecord004String.getName());
		propOrderRecords.add(propRecord005String.getName());
		propOrderRecords.add(propRecord006String.getName());
		propOrderRecords.add(propRecord007String.getName());
		propOrderRecords.add(propRecord008String.getName());
		propOrderRecords.add(propRecord009String.getName());
		propOrderRecords.add(propRecord010String.getName());
		propOrderRecords.add(propRecord011String.getName());
		propOrderRecords.add(propRecord012String.getName());
		propOrderRecords.add(propRecord013String.getName());
		propOrderRecords.add(propRecord014String.getName());
		propOrderRecords.add(propRecord015String.getName());
		propOrderRecords.add(propRecord016String.getName());
		propOrderRecords.add(propRecord017String.getName());
		propOrderRecords.add(propRecord018String.getName());
		propOrderRecords.add(propRecord019String.getName());
		propOrderRecords.add(propRecord020String.getName());
		propOrderRecords.add(propRecord021String.getName());
		propOrderRecords.add(propRecord022String.getName());
		propOrderRecords.add(propRecord023String.getName());
		propOrderRecords.add(propRecord024String.getName());
		propOrderRecords.add(propRecord025String.getName());
		config.setCategoryPropertyOrder(CATEGORY_NAME_MUSIC, propOrderRecords);

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

			Record001 = propRecord001String.getString(); // can also use a literal (see integer example) if desired
			Record002 = propRecord002String.getString(); // can also use a literal (see integer example) if desired
			Record003 = propRecord003String.getString(); // can also use a literal (see integer example) if desired
			Record004 = propRecord004String.getString(); // can also use a literal (see integer example) if desired
			Record005 = propRecord005String.getString(); // can also use a literal (see integer example) if desired
			Record006 = propRecord006String.getString(); // can also use a literal (see integer example) if desired
			Record007 = propRecord007String.getString(); // can also use a literal (see integer example) if desired
			Record008 = propRecord008String.getString(); // can also use a literal (see integer example) if desired
			Record009 = propRecord009String.getString(); // can also use a literal (see integer example) if desired
			Record010 = propRecord010String.getString(); // can also use a literal (see integer example) if desired
			Record011 = propRecord011String.getString(); // can also use a literal (see integer example) if desired
			Record012 = propRecord012String.getString(); // can also use a literal (see integer example) if desired
			Record013 = propRecord013String.getString(); // can also use a literal (see integer example) if desired
			Record014 = propRecord014String.getString(); // can also use a literal (see integer example) if desired
			Record015 = propRecord015String.getString(); // can also use a literal (see integer example) if desired
			Record016 = propRecord016String.getString(); // can also use a literal (see integer example) if desired
			Record017 = propRecord017String.getString(); // can also use a literal (see integer example) if desired
			Record018 = propRecord018String.getString(); // can also use a literal (see integer example) if desired
			Record019 = propRecord019String.getString(); // can also use a literal (see integer example) if desired
			Record020 = propRecord020String.getString(); // can also use a literal (see integer example) if desired
			Record021 = propRecord021String.getString(); // can also use a literal (see integer example) if desired
			Record022 = propRecord022String.getString(); // can also use a literal (see integer example) if desired
			Record023 = propRecord023String.getString(); // can also use a literal (see integer example) if desired
			Record024 = propRecord024String.getString(); // can also use a literal (see integer example) if desired
			Record025 = propRecord025String.getString(); // can also use a literal (see integer example) if desired

			PowerToys.writeJSON = propEnableWriteJSONBool.getBoolean(WRITE_JSON_DEFAULT_VALUE); // can also use a literal (see integer example) if desired
		}

		/*
		 * ---- step 4 - write the class's variables back into the RecordsConfig  -------------------
		 *               properties and save to disk
		 *
		 * This is done even for a 'loadFromFile==true', because some of the
		 * properties may have been assigned default values if the file was empty or corrupt.
		 */

		propRecord001String.set(Record001);
		propRecord002String.set(Record002);
		propRecord003String.set(Record003);
		propRecord004String.set(Record004);
		propRecord005String.set(Record005);
		propRecord006String.set(Record006);
		propRecord007String.set(Record007);
		propRecord008String.set(Record008);
		propRecord009String.set(Record009);
		propRecord010String.set(Record010);
		propRecord011String.set(Record011);
		propRecord012String.set(Record012);
		propRecord013String.set(Record013);
		propRecord014String.set(Record014);
		propRecord015String.set(Record015);
		propRecord016String.set(Record016);
		propRecord017String.set(Record017);
		propRecord018String.set(Record018);
		propRecord019String.set(Record019);
		propRecord020String.set(Record020);
		propRecord021String.set(Record021);
		propRecord022String.set(Record022);
		propRecord023String.set(Record023);
		propRecord024String.set(Record024);
		propRecord025String.set(Record025);
		propEnableWriteJSONBool.set(PowerToys.writeJSON);

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
						|| event.getConfigID().equals(CATEGORY_NAME_STORAGE)
						|| event.getConfigID().equals(CATEGORY_NAME_MUSIC) 
						)
				{
					syncFromGUI();
				}
			}
		}
	}
	
}

package powertoys.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import powertoys.PowerToys;
import powertoys.util.Reference;

public class RecordsConfig {


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
	
	
	public static final String CATEGORY_NAME_MAIN = "Main";
	public static final String CATEGORY_NAME_MUSIC = "Music";
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
		File MusicConfigFile = new File(Loader.instance().getConfigDir() + "/" + Reference.MODID, "Sounds.cfg");

		// initialize your configuration object with your configuration file values.
		MusicConfig = new Configuration(MusicConfigFile);

		// load RecordsConfig from file (see mbe70 package for more info)
		syncFromFile();
	}

	public static Configuration getConfig() {
		return MusicConfig;
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
	 * 2) !loadConfigFromFile && readFieldsFromConfig --> copy everything from the RecordsConfig file (altered by GUI).
	 * 3) !loadConfigFromFile && !readFieldsFromConfig --> copy everything from the native fields.
	 *
	 * @param loadConfigFromFile if true, load the RecordsConfig field from the configuration file on disk.
	 * @param readFieldsFromConfig if true, reload the member variables from the RecordsConfig field.
	 */

	public static void syncConfig(boolean loadConfigFromFile, boolean readFieldsFromConfig)
	{
		/*
		 * ---- step 1 - load raw values from RecordsConfig file (if loadFromFile true) -------------------
		 *
		 * Check if this configuration object is the main RecordsConfig file or a child
		 * configuration For simple configuration setups, this only matters if
		 * you enable global configuration for your configuration object by
		 * using RecordsConfig.enableGlobalConfiguration(), this will cause your RecordsConfig
		 * file to be 'global.cfg' in the default configuration directory and
		 * use it to read/write your configuration options
		 */
		if (loadConfigFromFile) {
			MusicConfig.load();
		}

		/*
		 * Using language keys are a good idea if you are using a RecordsConfig GUI
		 * This allows you to provide "pretty" names for the RecordsConfig properties
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


		final String RECORD001 = "Your song name";
		Property propRecord001String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord001String.setComment("Record001 RecordsConfig (basicCapacity)   MIN:      Max:      Default:  ");
		propRecord001String.setLanguageKey("Record001");


		final String RECORD002 = "Your song name";
		Property propRecord002String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record002", RECORD002);
		propRecord002String.setLanguageKey("Record002");

		final String RECORD003 = "Your song name";
		Property propRecord003String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record003", RECORD003);
		propRecord003String.setLanguageKey("Record003");

		final String RECORD004 = "Your song name";
		Property propRecord004String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record004", RECORD004);
		propRecord004String.setLanguageKey("Record004");

		final String RECORD005 = "Your song name";
		Property propRecord005String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record005", RECORD005);
		propRecord005String.setLanguageKey("Record005");

		final String RECORD006 = "Your song name";
		Property propRecord006String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record006", RECORD006);
		propRecord006String.setLanguageKey("Record006");

		final String RECORD007 = "Your song name";
		Property propRecord007String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record007", RECORD007);
		propRecord007String.setLanguageKey("Record007");

		final String RECORD008 = "Your song name";
		Property propRecord008String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record008", RECORD008);
		propRecord008String.setLanguageKey("Record008");

		final String RECORD009 = "Your song name";
		Property propRecord009String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord009String.setLanguageKey("Record001");

		final String RECORD010 = "Your song name";
		Property propRecord010String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord010String.setLanguageKey("Record001");

		final String RECORD011 = "Your song name";
		Property propRecord011String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord011String.setLanguageKey("Record001");

		final String RECORD012 = "Your song name";
		Property propRecord012String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord012String.setLanguageKey("Record001");

		final String RECORD013 = "Your song name";
		Property propRecord013String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord013String.setLanguageKey("Record001");

		final String RECORD014 = "Your song name";
		Property propRecord014String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord014String.setLanguageKey("Record001");

		final String RECORD015 = "Your song name";
		Property propRecord015String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord015String.setLanguageKey("Record001");

		final String RECORD016 = "Your song name";
		Property propRecord016String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord016String.setLanguageKey("Record001");

		final String RECORD017 = "Your song name";
		Property propRecord017String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord017String.setLanguageKey("Record001");

		final String RECORD018 = "Your song name";
		Property propRecord018String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord018String.setLanguageKey("Record001");

		final String RECORD019 = "Your song name";
		Property propRecord019String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord019String.setLanguageKey("Record001");

		final String RECORD020 = "Your song name";
		Property propRecord020String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord020String.setLanguageKey("Record001");

		final String RECORD021 = "Your song name";
		Property propRecord021String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord021String.setLanguageKey("Record001");

		final String RECORD022 = "Your song name";
		Property propRecord022String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord022String.setLanguageKey("Record001");

		final String RECORD023 = "Your song name";
		Property propRecord023String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord023String.setLanguageKey("Record001");

		final String RECORD024 = "Your song name";
		Property propRecord024String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord024String.setLanguageKey("Record001");

		final String RECORD025 = "Your song name";
		Property propRecord025String = MusicConfig.get(CATEGORY_NAME_MUSIC, "Record001", RECORD001);
		propRecord025String.setLanguageKey("Record001");

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
		MusicConfig.setCategoryPropertyOrder(CATEGORY_NAME_MUSIC, propOrderRecords);

		
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
			// If getInt() cannot get an integer value from the RecordsConfig file
			// value of myInteger (e.g. corrupted file).
			// It will set it to the default value passed to the function.

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

		if (MusicConfig.hasChanged()) {
			MusicConfig.save();
		}
	}

	// Define your configuration object
	private static Configuration MusicConfig = null;

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
						|| event.getConfigID().equals(CATEGORY_NAME_STORAGE)
						|| event.getConfigID().equals(CATEGORY_NAME_MUSIC) 
						)
				{
					syncFromGUI();
				}
			}
		}
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		PowerToys.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MODID);
		PowerToys.config.mkdirs();
//		init(new File(PowerToys.config.getPath(), "Sounds.cfg"));

		PowerToys.MusicConfig = new File(PowerToys.config.getPath() + "/sounds");
		PowerToys.MusicConfig.mkdirs();
//		init(new File(PowerToys.MusicConfig.getPath(), Reference.MODID + "Sounds.cfg"));
	}
} 

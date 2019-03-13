package powertoys;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import powertoys.config.RecordsConfig;
import powertoys.config.StorageConfig;
import powertoys.config.StorageConfig.ConfigEventHandler;
import powertoys.events.CoreEvents;
import powertoys.events.SecurityEvents;
import powertoys.gui.GuiHandler;
import powertoys.init.PRBlocks;
import powertoys.init.PRItems;
import powertoys.item.record.RecordSoundsBase;
import powertoys.network.PRNetwork;
import powertoys.proxy.CommonProxy;
import powertoys.registry.RegistryHelper;
import powertoys.util.Log;
import powertoys.util.PRStorageUtils;
import powertoys.util.Reference;

/** PowerToys main mod class */
@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION, guiFactory= Reference.GUI_FACTORY)
public class PowerToys {

	@Mod.Instance(Reference.MODID)
	public static PowerToys instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;

    public static final String GUIFACTORY = Reference.GUI_FACTORY;
	public static SimpleNetworkWrapper nw;
	public static File config;
	public static File MusicConfig;
	
	public static final CreativeTabs tabPowerRings = (new CreativeTabs("PTRingsTab") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(PRItems.COMMON_RING);
		}
	});	

	public static final CreativeTabs tabStorage = (new CreativeTabs("PTStorageTab") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(PRBlocks.condensed_storage_box);
		}
	});	

	public static final CreativeTabs tabRecords = (new CreativeTabs("PTRecordsTab") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.RECORD_13);
		}
	});	


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
//		RecordSoundsBase.registerSounds();
		RecordsConfig.registerConfig(event);
		proxy.preInit();
		proxy.initRegistryEvents();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		nw = PRNetwork.registerNetwork();
		MinecraftForge.EVENT_BUS.register(new CoreEvents());
		MinecraftForge.EVENT_BUS.register(new SecurityEvents());
		MinecraftForge.EVENT_BUS.register(new ConfigEventHandler());
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
		PRStorageUtils.getModNameFromID(Reference.MODID); // build the mod map
		Log.logger.info("Loading complete.");
	}

}

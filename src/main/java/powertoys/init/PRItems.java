package powertoys.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import powertoys.config.PRConfig;
import powertoys.item.ItemDolly;
import powertoys.item.ItemKey;
import powertoys.item.PRItem;
import powertoys.item.amulet.InvisibleAmulet;
import powertoys.item.belt.BaseBelt;
import powertoys.item.body.MinerVest;
import powertoys.item.head.NightVisionGlasses;
import powertoys.item.rings.CommonRing;
import powertoys.item.rings.FireRing;
import powertoys.item.rings.FlightRing;
import powertoys.item.rings.LavaWalkerRing;
import powertoys.item.rings.MagnetRing;
import powertoys.item.rings.RegenRing;
import powertoys.item.rings.SaturationRing;
import powertoys.item.rings.WaterRing;
import powertoys.item.rings.WaterWalkerRing;
import powertoys.registry.IRegistryItem;
import powertoys.registry.RegistryHelper;
import powertoys.util.JointList;

/** Mod items */
public class PRItems {

	private static JointList<IRegistryItem> items;

	public static void mainRegistry() {
		items = new JointList();
		init();
		register();
	}

	public static PRItem key;
	public static PRItem dolly_basic;
	public static PRItem dolly_super;
	// Power Rings Stuff
	public static PRItem COMMON_RING;
	public static PRItem FIRE_RING;
	public static PRItem FLIGHT_RING;
	public static PRItem LAVA_WALKER_RING;
	public static PRItem MAGNET_RING;
	public static PRItem SATURATION_RING;
	public static PRItem WATER_RING;
	public static PRItem WATER_WALKER_RING;
	public static PRItem REGEN_RING;
	public static PRItem NIGHT_VISION_GLASSES;
	public static PRItem BASE_BELT;
	public static PRItem MINER_VEST;
	public static PRItem INVISIBLE_AMULET;
	

	private static void init() {
		items.join(
			key = new ItemKey(),
			dolly_basic = new ItemDolly(6, "dolly"),
			dolly_super = new ItemDolly(16, "dolly_super"),
			COMMON_RING = new CommonRing("commonring"),
			FIRE_RING = new FireRing("firering"),
			FLIGHT_RING = new FlightRing("flightring"),
			LAVA_WALKER_RING = new LavaWalkerRing("lavawalkerring"),	
			MAGNET_RING = new MagnetRing("magnetring", 7),
			SATURATION_RING = new SaturationRing("saturationring"),
			WATER_RING = new WaterRing("waterring"),
			WATER_WALKER_RING = new WaterWalkerRing("waterwalkerring"),	
			REGEN_RING = new RegenRing("regenring"),
			NIGHT_VISION_GLASSES = new NightVisionGlasses("nightvisionglasses"),
			BASE_BELT = new BaseBelt("basebelt"),
			MINER_VEST = new MinerVest("minervest"),
			INVISIBLE_AMULET = new InvisibleAmulet("invisibleamulet")
			
		);
		if(!PRConfig.enableSecurity) items.remove(key); // security disabled
		if(!PRConfig.enableDolly) {
			items.remove(dolly_basic); // dollies disabled
			items.remove(dolly_super);
		}
	}

	private static void register() {
		RegistryHelper.registerItems(items);
	}

	/** Register model information */
	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		for (IRegistryItem item : items) {
			item.registerRender();
		}
	}

}

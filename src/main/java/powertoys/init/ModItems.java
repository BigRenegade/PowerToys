package powertoys.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
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

public class ModItems 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Power Rings Stuff
	public static final Item COMMON_RING = new CommonRing("commonring");
	public static final Item FIRE_RING = new FireRing("firering");
	public static final Item FLIGHT_RING = new FlightRing("flightring");
	public static final Item LAVA_WALKER_RING = new LavaWalkerRing("lavawalkerring");	
	public static final Item MAGNET_RING = new MagnetRing("magnetring", 7);
	public static final Item SATURATION_RING = new SaturationRing("saturationring");
	public static final Item WATER_RING = new WaterRing("waterring");
	public static final Item WATER_WALKER_RING = new WaterWalkerRing("waterwalkerring");	
	public static final Item REGEN_RING = new RegenRing("regenring");

	public static final Item NIGHT_VISION_GLASSES = new NightVisionGlasses("nightvisionglasses");
	public static final Item BASE_BELT = new BaseBelt("basebelt");
	public static final Item MINER_VEST = new MinerVest("minervest");
	public static final Item INVISIBLE_AMULET = new InvisibleAmulet("invisibleamulet");
	
}

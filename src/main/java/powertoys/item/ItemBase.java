package powertoys.item;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import powertoys.PowerToys;
import powertoys.init.ModItems;
import powertoys.registry.IRegistryItem;
import powertoys.util.IHasModel;

public class ItemBase extends Item implements IRegistryItem {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(PowerToys.tabPowerRings);
		
		ModItems.ITEMS.add(this);
	}
	
	public void registerModels() 
	{
		PowerToys.proxy.registerItemRenderer(this, 0, "inventory");
	}
}

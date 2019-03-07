package powertoys.item.food;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import powertoys.PowerToys;
import powertoys.init.ModItems;
import powertoys.util.IHasModel;

public class FoodBase extends ItemFood implements IHasModel 
{
	
	public FoodBase(String name, int amount, float saturation, boolean isAnimalFood) 
	{
		super(amount, saturation, isAnimalFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(PowerToys.tabPowerRings);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		PowerToys.proxy.registerItemRenderer(this, 0, "inventory");
	}

}

package powertoys.item.rings;


import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import powertoys.PowerToys;
import powertoys.item.ItemBase;
import powertoys.item.PRItem;
import powertoys.util.Reference;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonRing extends PRItem implements IBauble
{
	@GameRegistry.ObjectHolder(Reference.COMMONRING)
	public static final Item RING = null;

	public CommonRing(String name)
	{
		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setCreativeTab(PowerToys.tabPowerRings);
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (this.isInCreativeTab(tab)) {
			list.add(new ItemStack(this, 1, 0));
		}
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.COMMON;
	}

}

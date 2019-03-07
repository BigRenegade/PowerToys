package powertoys;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import powertoys.init.PRBlocks;

public class PRTab extends CreativeTabs {

	public PRTab() {
		super("PowerToys");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		return new ItemStack(PRBlocks.condensed_storage_box);
	}
}

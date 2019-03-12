package powertoys;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import powertoys.init.PRBlocks;

public class PTStorageTab extends CreativeTabs {

	public PTStorageTab() {
		super("PowerToys Storage");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		return new ItemStack(PRBlocks.condensed_storage_box);
	}
}

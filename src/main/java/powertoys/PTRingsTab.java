package powertoys;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import powertoys.init.ModItems;
import powertoys.item.rings.CommonRing;

public class PTRingsTab extends CreativeTabs  {

		public PTRingsTab() {
		super("Power Toys Rings");
		// TODO Auto-generated constructor stub
	}

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(CommonRing.RING);
		}


	}


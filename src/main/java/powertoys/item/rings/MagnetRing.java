/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [May 17, 2014, 3:16:36 PM (GMT)]
 */
package powertoys.item.rings;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.items.IItemHandler;
import powertoys.PowerToys;
import powertoys.item.PRItem;
import powertoys.util.Reference;

import java.util.List;
@Mod.EventBusSubscriber

public class MagnetRing extends PRItem implements IBauble {

	@GameRegistry.ObjectHolder(Reference.MAGNETRING)
	public static final Item RING = null;

	private static int range;

	public MagnetRing(String name, int range) {

		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setCreativeTab(PowerToys.tabPowerRings);
		this.range = range;
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
	public void onWornTick(ItemStack stack, EntityLivingBase player) {

    	if (player instanceof EntityPlayer) {
            EntityPlayer iplayer = ((EntityPlayer) player);
    		if (stack.getItemDamage()==0)
    			if  (player.ticksExisted%1==0) {
    				
    				double x = player.posX;
    				double y = player.posY + 0.75;
    				double z = player.posZ;
    				
    				List<EntityItem> items = player.world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
    				int pulled = 0;
    				for(EntityItem item : items)
    					if(canPullItem(item)) {
    						if(pulled > 200)
    							break;
    						((EntityPlayer) player).addItemStackToInventory(item.getItem());
    						pulled++;
    					}
    			}
    		}
	}

	private boolean canPullItem(EntityItem item) {
		if(item.isDead)
			return false;

		ItemStack stack = item.getItem();
		if(stack.isEmpty())
			return false;

		BlockPos pos = new BlockPos(item);

		return true;
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 1.9f);
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 2f);
	}


}

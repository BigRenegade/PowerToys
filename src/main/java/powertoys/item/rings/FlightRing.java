package powertoys.item.rings;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import powertoys.PowerToys;
import powertoys.item.PRItem;
import powertoys.util.Reference;

@Mod.EventBusSubscriber
public class FlightRing extends PRItem implements IBauble
{
	@GameRegistry.ObjectHolder(Reference.FLIGHTRING)
	public static final Item RING = null;

	public FlightRing (String name)
	{
		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setCreativeTab(PowerToys.tabPowerRings);
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
    public void onUnequipped(ItemStack itemstack, EntityLivingBase entity) {
        stopFlying((EntityPlayer) entity);
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase entity) {
        startFlying((EntityPlayer) entity);
    }


    private void startFlying(EntityPlayer player) {

    	if(!player.isCreative()) {
            player.capabilities.allowFlying = true;
            if (!player.getEntityWorld().isRemote) {
                player.sendPlayerAbilities();
            }
        }
    }

    private void stopFlying(EntityPlayer player) {
        if(!player.isCreative()){
            player.capabilities.isFlying = false;
            player.capabilities.allowFlying = false;

            if (!player.getEntityWorld().isRemote) {
                player.sendPlayerAbilities();
            }
        }
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity) {
   
    	
    	if (entity instanceof EntityPlayer) {
            EntityPlayer player = ((EntityPlayer) entity);
    		if (stack.getItemDamage()==0)
    			if  (player.ticksExisted%60==0) {
                startFlying(player);
            }
        }
    }

    public int getMaxLevel()
    {
        return 2;
    }

}

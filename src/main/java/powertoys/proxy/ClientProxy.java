package powertoys.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import powertoys.gui.client.GuiStorageCore;
import powertoys.init.PRBlocks;
import powertoys.init.PRItems;
import powertoys.registry.ClientRegistryHelper;

/** The mod's client proxy */
public class ClientProxy extends CommonProxy {
	
	@Override
	public void initRegistryEvents() {
		super.initRegistryEvents();
		MinecraftForge.EVENT_BUS.register(new ClientRegistryHelper());
	}

	@Override
	public void registerRenders() {
		PRBlocks.registerRenders();
		PRItems.registerRenders();
	}

	@Override
	public EntityPlayer getClientPlayer() {
		return Minecraft.getMinecraft().player;
	}

	@Override
	public void markGuiDirty() {
		GuiScreen scr = Minecraft.getMinecraft().currentScreen;
		if (scr instanceof GuiStorageCore) {
			GuiStorageCore gui = (GuiStorageCore) scr;
			gui.markFilterUpdate();
		}
	}

	@Override
	public boolean playerIsInCreativeMode(EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
	      EntityPlayerMP entityPlayerMP = (EntityPlayerMP)player;
	      return entityPlayerMP.interactionManager.isCreative();
	    } else if (player instanceof EntityPlayerSP) {
	      return Minecraft.getMinecraft().playerController.isInCreativeMode();
	    }
	    return false;
	  }

	  @Override
	  public boolean isDedicatedServer() {return false;}


}

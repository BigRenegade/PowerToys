package powertoys.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import powertoys.config.PRConfig;
import powertoys.registry.RegistryHelper;
import powertoys.util.Reference;

/** The mod's shared proxy */
public class CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id) {}
	
	  public void preInit()
	  {
		   //read mbe.config first
		    PRConfig.preInit();
	  }

	  /**
	   * Do your mod setup. Build whatever data structures you care about. Register recipes,
	   * send FMLInterModComms messages to other mods.
	   */
	  public void init()
	  {
		  
	  }

	  /**
	   * Handle interaction with other mods, complete your setup based on this.
	   */
	  public void postInit()
	  {
		  
	  }

	
	/** Register the events used to register stuff */
	public void initRegistryEvents() {
		MinecraftForge.EVENT_BUS.register(new RegistryHelper());
	}

	/** Register stuff related to rendering */
	public void registerRenders() {}

	/** Gets the client player clientside, or null serverside */
	public EntityPlayer getClientPlayer() {
		return null;
	}

	/** Marks the system as needing a filter update clientside */
	public void markGuiDirty() {}

	  public boolean playerIsInCreativeMode(EntityPlayer player) {
		    if (player instanceof EntityPlayerMP) {
		      EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
		      return entityPlayerMP.interactionManager.isCreative();
		    }
		    return false;
		  }

		  public boolean isDedicatedServer() {return true;}

	
}

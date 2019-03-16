package powertoys.item.record;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import powertoys.PowerToys;
import powertoys.util.Reference;

@ObjectHolder(Reference.MODID)
public class RecordSoundsBase {
	
//	public static final List<SoundEvent> SOUNDS = new ArrayList<SoundEvent>();

	
	public static SoundEvent perspectives = registerSound("perspectives");
	public static SoundEvent kissthis = registerSound("kissthis");
	public static SoundEvent kissass = registerSound("kissass");
	public static SoundEvent DierksBentley5150 = registerSound("DierksBentley5150");
	
	public static void registerSounds() {
	}
	
	private static SoundEvent registerSound(String soundName) {
		final SoundEvent sound = new SoundEvent(new ResourceLocation(Reference.MODID, soundName)).setRegistryName(new ResourceLocation(Reference.MODID, soundName));
		ForgeRegistries.SOUND_EVENTS.register(sound);
		return (sound);
	}
	
}

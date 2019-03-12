package powertoys.item.record;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import powertoys.util.Reference;

@ObjectHolder(Reference.MODID)
public class RecordSoundsBase {
	
	public static SoundEvent perspectives;
	public static SoundEvent kissthis;
	public static SoundEvent kissass;
	
	public static void registerSounds() {
		perspectives = registerSound("perspectives");
		kissthis = registerSound("kissthis");
		kissass = registerSound("kissass");
	}
	
	private static SoundEvent registerSound(String soundName) {
		final SoundEvent sound = new SoundEvent(new ResourceLocation(Reference.MODID, soundName)).setRegistryName(new ResourceLocation(Reference.MODID, soundName));
		ForgeRegistries.SOUND_EVENTS.register(sound);
		return (sound);
	}
	
}

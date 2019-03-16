package powertoys.item.record;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import powertoys.PowerToys;
import powertoys.init.RecordItems;
import powertoys.util.Reference;

public class RecordBase extends ItemRecord {

	public RecordBase(String name, SoundEvent soundIn) {
		super(name, soundIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(Reference.MODID + ":" + name);
		this.setCreativeTab(PowerToys.tabRecords);
		
//		RecordItems.RECORDS.add(this);
	}

}

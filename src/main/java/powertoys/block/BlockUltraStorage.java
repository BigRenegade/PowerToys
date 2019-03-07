package powertoys.block;

import net.minecraft.block.material.Material;
import powertoys.config.PRConfig;

/** An ultra storage box */
public class BlockUltraStorage extends BlockStorage {

	public BlockUltraStorage() {
		super("ultra_storage_box", Material.IRON);
	}

	@Override
	public int getCapacity() {
		return PRConfig.ultraCapacity;
	}

}

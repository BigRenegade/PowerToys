package powertoys.block;

import net.minecraft.block.material.Material;
import powertoys.config.StorageConfig;

public class BlockHyperStorage extends BlockStorage {

	public BlockHyperStorage() {
		super("hyper_storage_box", Material.IRON);
	}

	@Override
	public int getCapacity() {
		return StorageConfig.hyperCapacity;
	}
}
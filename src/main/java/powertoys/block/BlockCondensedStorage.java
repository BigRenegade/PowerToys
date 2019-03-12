package powertoys.block;

import net.minecraft.block.material.Material;
import powertoys.config.StorageConfig;

public class BlockCondensedStorage extends BlockStorage {

	public BlockCondensedStorage() {
		super("condensed_storage_box", Material.IRON);
	}

	@Override
	public int getCapacity() {
		return StorageConfig.condensedCapacity;
	}
}

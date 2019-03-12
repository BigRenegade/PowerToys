package powertoys.block;

import net.minecraft.block.material.Material;
import powertoys.config.StorageConfig;
import powertoys.registry.IRegistryBlock;

/** A super storage box */
public class BlockSuperStorage extends BlockStorage implements IRegistryBlock {

	public BlockSuperStorage() {
		super("super_storage_box", Material.IRON);
	}

	@Override
	public int getCapacity() {
		return StorageConfig.superCapacity;
	}

}

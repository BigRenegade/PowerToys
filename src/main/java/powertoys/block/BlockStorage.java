package powertoys.block;

import net.minecraft.block.material.Material;
import powertoys.config.StorageConfig;

public class BlockStorage extends StorageMultiblock {

	public BlockStorage() {
		super("storage_box", Material.WOOD);
	}

	public BlockStorage(String name, Material material) {
		super(name, material);
	}

	public int getCapacity() {
		return StorageConfig.basicCapacity;
	}
}
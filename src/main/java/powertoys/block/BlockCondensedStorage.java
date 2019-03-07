package powertoys.block;

import net.minecraft.block.material.Material;
import powertoys.config.PRConfig;

public class BlockCondensedStorage extends BlockStorage {

	public BlockCondensedStorage() {
		super("condensed_storage_box", Material.IRON);
	}

	@Override
	public int getCapacity() {
		return PRConfig.condensedCapacity;
	}
}

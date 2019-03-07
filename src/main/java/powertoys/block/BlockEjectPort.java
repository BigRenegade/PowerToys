package powertoys.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import powertoys.tileentity.TileEntityEjectPort;

public class BlockEjectPort extends PRBlockContainer {

	public BlockEjectPort() {
		super("output_port", Material.IRON);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityEjectPort();
	}

}

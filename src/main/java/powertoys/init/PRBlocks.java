package powertoys.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import powertoys.block.BlockAccessTerminal;
import powertoys.block.BlockBlankBox;
import powertoys.block.BlockCondensedStorage;
import powertoys.block.BlockCraftingBox;
import powertoys.block.BlockEjectPort;
import powertoys.block.BlockExtractPort;
import powertoys.block.BlockHyperStorage;
import powertoys.block.BlockInputPort;
import powertoys.block.BlockSearchBox;
import powertoys.block.BlockSecurityBox;
import powertoys.block.BlockSortBox;
import powertoys.block.BlockStorage;
import powertoys.block.BlockStorageCore;
import powertoys.block.BlockSuperStorage;
import powertoys.block.BlockUltraStorage;
import powertoys.block.PRBlock;
import powertoys.config.PRConfig;
import powertoys.registry.IRegistryBlock;
import powertoys.registry.RegistryHelper;
import powertoys.tileentity.TileEntityEjectPort;
import powertoys.tileentity.TileEntityExtractPort;
import powertoys.tileentity.TileEntityInputPort;
import powertoys.tileentity.TileEntitySecurityBox;
import powertoys.tileentity.TileEntityStorageCore;
import powertoys.util.JointList;
import powertoys.util.Reference;

/** Mod blocks */
public class PRBlocks {

	private static JointList<IRegistryBlock> blocks;

	public static void mainRegistry() {
		blocks = new JointList();
		init();
		register();
	}

	public static PRBlock blank_box;
	public static PRBlock storage_core;
	public static PRBlock storage_box;
	public static PRBlock condensed_storage_box;
	public static PRBlock super_storage_box;
	public static PRBlock ultra_storage_box;
	public static PRBlock hyper_storage_box;
	public static PRBlock input_port;
	public static PRBlock output_port;
	public static PRBlock extract_port;
	public static PRBlock crafting_box;
	public static PRBlock search_box;
	public static PRBlock sort_box;
	public static PRBlock access_terminal;
	public static PRBlock security_box;

	private static void init() {
		blocks.join(blank_box = new BlockBlankBox(), storage_core = new BlockStorageCore(), storage_box = new BlockStorage(),
				condensed_storage_box = new BlockCondensedStorage(), super_storage_box = new BlockSuperStorage(),
				ultra_storage_box = new BlockUltraStorage(), hyper_storage_box = new BlockHyperStorage(), input_port = new BlockInputPort(),
				output_port = new BlockEjectPort(), extract_port = new BlockExtractPort(), crafting_box = new BlockCraftingBox(),
				search_box = new BlockSearchBox(), sort_box = new BlockSortBox(), access_terminal = new BlockAccessTerminal(),
				security_box = new BlockSecurityBox());
		if (!PRConfig.enableTerminal)
			blocks.remove(access_terminal); // terminal disabled
		if (!PRConfig.enableSecurity)
			blocks.remove(security_box); // security disabled
	}

	/** Register the blocks and tile entities */
	private static void register() {
		RegistryHelper.registerBlocks(blocks);
		GameRegistry.registerTileEntity(TileEntityStorageCore.class, Reference.MODID + ":TileEntityStorageCore");
		GameRegistry.registerTileEntity(TileEntityInputPort.class, Reference.MODID + ":TileEntityInputPort");
		GameRegistry.registerTileEntity(TileEntityEjectPort.class, Reference.MODID + ":TileEntityOutputPort");
		GameRegistry.registerTileEntity(TileEntityExtractPort.class, Reference.MODID + ":TileEntityExtractPort");
		GameRegistry.registerTileEntity(TileEntitySecurityBox.class, Reference.MODID + ":TileEntitySecurityBox");
	}

	/** Register model information */
	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		for (IRegistryBlock block : blocks) {
			block.registerRender();
		}
	}
}

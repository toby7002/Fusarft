package fusarft.block

import fusarft.Fusarft
import io.wispforest.owo.itemgroup.OwoItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.DyeColor
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.StainedGlassBlock

class FBlocks {
	companion object {
		val HAFNIUM_ORE = register("hafnium_ore", Block(FabricBlockSettings.create()))
		val DEEPSLATE_HAFNIUM_ORE = register("deepslate_hafnium_ore", DeepslateHafniumOre())

		val BASIC_REACTOR_CASING = register("basic_reactor_casing", Block(FabricBlockSettings.create()))
		val ADVANCED_REACTOR_CASING = register("advanced_reactor_casing", Block(FabricBlockSettings.create()))
		val IC_GLASS = register("ic_glass", StainedGlassBlock(DyeColor.WHITE, FabricBlockSettings.copyOf(Blocks.GLASS)))
		val MC_GLASS = register("mc_glass", StainedGlassBlock(DyeColor.WHITE, FabricBlockSettings.copyOf(Blocks.GLASS)))
		val LASER_PORT = register("laser_port", StainedGlassBlock(DyeColor.WHITE, FabricBlockSettings.copyOf(Blocks.GLASS)))

		private fun register(
			name: String,
			block: Block,
		): Block {
			Registry.register(
				BuiltInRegistries.ITEM,
				ResourceLocation(Fusarft.MOD_ID, name),
				BlockItem(block, OwoItemSettings().group(Fusarft.ITEM_GROUP)),
			)
			return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation(Fusarft.MOD_ID, name), block)
		}

		fun init() {}
	}
}

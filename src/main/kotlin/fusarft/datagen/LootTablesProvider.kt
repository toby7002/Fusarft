package fusarft.datagen

import fusarft.block.FBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.world.level.block.Block

class LootTablesProvider(dataOutput: FabricDataOutput) : FabricBlockLootTableProvider(dataOutput) {
	override fun generate() {
		registerSelfDropping()
	}

	private fun registerSelfDropping() {
		val blocks =
			arrayOf(
				FBlocks.IC_GLASS,
				FBlocks.MC_GLASS,
				FBlocks.LASER_PORT,
				FBlocks.IC_REACTOR_CASING,
				FBlocks.MC_REACTOR_CASING,
			)

		blocks.forEach { block: Block -> dropSelf(block) }
	}
}

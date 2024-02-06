package fusarft.datagen

import fusarft.block.FBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import java.util.concurrent.CompletableFuture

class BlockTagsProvider(
	output: FabricDataOutput,
	completableFuture: CompletableFuture<HolderLookup.Provider>,
) :
	FabricTagProvider.BlockTagProvider(
			output,
			completableFuture,
		) {
	override fun addTags(arg: HolderLookup.Provider) {
		registerMineableWithPickaxeBlocks()
	}

	private fun registerMineableWithPickaxeBlocks() {
		getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(FBlocks.HAFNIUM_ORE)
			.add(FBlocks.DEEPSLATE_HAFNIUM_ORE)
			.add(FBlocks.IC_REACTOR_CASING)
			.add(FBlocks.MC_REACTOR_CASING)
			.add(FBlocks.LASER_PORT)
			.add(FBlocks.MC_GLASS)
			.add(FBlocks.IC_GLASS)
	}
}

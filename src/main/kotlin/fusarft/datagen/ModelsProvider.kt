package fusarft.datagen

import fusarft.block.FBlocks
import fusarft.item.FItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelTemplates
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

class ModelsProvider(output: FabricDataOutput) : FabricModelProvider(output) {
	override fun generateBlockStateModels(gen: BlockModelGenerators) {
		basicBlock(gen, FBlocks.HAFNIUM_ORE)
		basicBlock(gen, FBlocks.DEEPSLATE_HAFNIUM_ORE)
	}

	override fun generateItemModels(gen: ItemModelGenerators) {
		basicItem(gen, FItems.HAFNIUM_INGOT)
		basicItem(gen, FItems.RAW_HAFNIUM)
		basicItem(gen, FItems.GRAPHITE_INGOT)
	}

	private fun basicItem(
		gen: ItemModelGenerators,
		item: Item,
	) {
		gen.generateFlatItem(item, ModelTemplates.FLAT_ITEM)
	}

	private fun basicBlock(
		gen: BlockModelGenerators,
		block: Block,
	) {
		gen.createTrivialCube(block)
	}
}

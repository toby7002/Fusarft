package fusarft

import fusarft.block.FBlocks
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.renderer.RenderType
import net.minecraft.world.level.block.Block

class FusarftClient : ClientModInitializer {
	override fun onInitializeClient() {
		val glasses = listOf(FBlocks.IC_GLASS, FBlocks.MC_GLASS, FBlocks.LASER_PORT)
		registerGlassRenderType(glasses)
	}

	private fun registerGlassRenderType(glasses: List<Block>) {
		glasses.forEach { glass -> BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.translucent()) }
	}
}

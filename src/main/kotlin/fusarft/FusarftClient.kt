package fusarft

import fusarft.block.FBlocks
import fusarft.fluid.FFluids
import fusarft.fluid.FluidRender
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation

class FusarftClient : ClientModInitializer {
    override fun onInitializeClient() {
        registerGlassRenderType()
		FluidRender.init()
    }

    private fun registerGlassRenderType() {
        val glasses = listOf(FBlocks.IC_GLASS, FBlocks.MC_GLASS, FBlocks.LASER_PORT)
        glasses.forEach { glass ->
            BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.translucent())
        }
    }
}

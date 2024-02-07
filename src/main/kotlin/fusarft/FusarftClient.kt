package fusarft

import fusarft.block.FBlocks
import fusarft.fluid.FFluids
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation

class FusarftClient : ClientModInitializer {
    override fun onInitializeClient() {
        registerGlassRenderType()
		registerFluidRender()
    }

    private fun registerGlassRenderType() {
        val glasses = listOf(FBlocks.IC_GLASS, FBlocks.MC_GLASS, FBlocks.LASER_PORT)
        glasses.forEach { glass ->
            BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderType.translucent())
        }
    }

    private fun registerFluidRender() {
        FluidRenderHandlerRegistry.INSTANCE.register(
            FFluids.TRITIUM,
            FFluids.FLOWING_TRITIUM,
            SimpleFluidRenderHandler(
                ResourceLocation("fusarft:block/liquid"),
                ResourceLocation("fusarft:block/liquid_flow"),
				0x50fa7b,
            ),
        )
		FluidRenderHandlerRegistry.INSTANCE.register(
			FFluids.DEUTERIUM,
			FFluids.FLOWING_DEUTERIUM,
			SimpleFluidRenderHandler(
				ResourceLocation("fusarft:block/liquid"),
				ResourceLocation("fusarft:block/liquid_flow"),
				0xff5555,
			),
		)

        BlockRenderLayerMap.INSTANCE.putFluids(
            RenderType.translucent(),
            FFluids.TRITIUM,
            FFluids.FLOWING_TRITIUM,
        )
		BlockRenderLayerMap.INSTANCE.putFluids(
			RenderType.translucent(),
			FFluids.DEUTERIUM,
			FFluids.FLOWING_DEUTERIUM,
		)
    }
}

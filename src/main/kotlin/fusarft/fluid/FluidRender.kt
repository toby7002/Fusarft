package fusarft.fluid

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler
import net.minecraft.client.renderer.RenderType
import net.minecraft.resources.ResourceLocation

class FluidRender {
	companion object {
		fun init() {
			registerDeuterium()
			registerTritium()
			registerSteam()
		}

		private fun registerDeuterium() {
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
				FFluids.DEUTERIUM,
				FFluids.FLOWING_DEUTERIUM,
			)
		}

		private fun registerTritium() {
			FluidRenderHandlerRegistry.INSTANCE.register(
				FFluids.TRITIUM,
				FFluids.FLOWING_TRITIUM,
				SimpleFluidRenderHandler(
					ResourceLocation("fusarft:block/liquid"),
					ResourceLocation("fusarft:block/liquid_flow"),
					0x50fa7b,
				),
			)
			BlockRenderLayerMap.INSTANCE.putFluids(
				RenderType.translucent(),
				FFluids.TRITIUM,
				FFluids.FLOWING_TRITIUM,
			)
		}
		private fun registerSteam() {
			FluidRenderHandlerRegistry.INSTANCE.register(
				FFluids.STEAM,
				FFluids.FLOWING_STEAM,
				SimpleFluidRenderHandler(
					ResourceLocation("fusarft:block/liquid"),
					ResourceLocation("fusarft:block/liquid_flow"),
					0xf8f8f2,
				),
			)
			BlockRenderLayerMap.INSTANCE.putFluids(
				RenderType.translucent(),
				FFluids.STEAM,
				FFluids.FLOWING_STEAM,
			)
		}
	}
}

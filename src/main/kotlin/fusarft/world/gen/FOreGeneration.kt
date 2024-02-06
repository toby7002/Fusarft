package fusarft.world.gen

import fusarft.world.FPlacedFeatures
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.world.level.levelgen.GenerationStep

class FOreGeneration {
	companion object {
		fun generateOres() {
			BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				FPlacedFeatures.SMALL_ORE_PLACED_KEY,
			)
			BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				FPlacedFeatures.MIDDLE_HAFNIUM_ORE_PLACED_KEY,
			)
			BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				FPlacedFeatures.UPPER_HAFNIUM_ORE_PLACED_KEY,
			)
		}
	}
}

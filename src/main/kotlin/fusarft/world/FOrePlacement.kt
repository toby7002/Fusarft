package fusarft.world

import net.minecraft.world.level.levelgen.placement.BiomeFilter
import net.minecraft.world.level.levelgen.placement.CountPlacement
import net.minecraft.world.level.levelgen.placement.InSquarePlacement
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import net.minecraft.world.level.levelgen.placement.RarityFilter

class FOrePlacement {
	companion object {
		fun modifiers(
			countModifier: PlacementModifier,
			heightModifier: PlacementModifier,
		): List<PlacementModifier> {
			return listOf(
				countModifier,
				InSquarePlacement.spread(),
				heightModifier,
				BiomeFilter.biome(),
			)
		}

		fun modifiersWithCount(
			count: Int,
			heightModifier: PlacementModifier,
		): List<PlacementModifier> {
			return modifiers(CountPlacement.of(count), heightModifier)
		}

		fun modifiersWithRarity(
			chance: Int,
			heightModifier: PlacementModifier,
		): List<PlacementModifier> {
			return modifiers(RarityFilter.onAverageOnceEvery(chance), heightModifier)
		}
	}
}

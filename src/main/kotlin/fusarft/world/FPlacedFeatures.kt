package fusarft.world

import fusarft.Fusarft
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier

class FPlacedFeatures {
    companion object {
        val UPPER_HAFNIUM_ORE_PLACED_KEY: ResourceKey<PlacedFeature> =
            registerKey("upper_hafnium_ore_placed")
        val MIDDLE_HAFNIUM_ORE_PLACED_KEY: ResourceKey<PlacedFeature> =
            registerKey("middle_hafnium_ore_placed")
        val SMALL_ORE_PLACED_KEY: ResourceKey<PlacedFeature> =
            registerKey("small_hafnium_ore_placed")

        fun boostrap(context: BootstapContext<PlacedFeature>) {
            val configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE)

            register(
                context,
                UPPER_HAFNIUM_ORE_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(
                    FConfiguredFeatures.HAFNIUM_ORE_KEY
                ),
                FOrePlacement.modifiersWithCount(
                    5,
                    HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(80),
                        VerticalAnchor.absolute(384)
                    ),
                ),
            )

            register(
                context,
                MIDDLE_HAFNIUM_ORE_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(
                    FConfiguredFeatures.HAFNIUM_ORE_KEY
                ),
                FOrePlacement.modifiersWithCount(
                    25,
                    HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(-63),
                        VerticalAnchor.absolute(0)
                    ),
                ),
            )

            register(
                context,
                SMALL_ORE_PLACED_KEY,
                configuredFeatureRegistryEntryLookup.getOrThrow(
                    FConfiguredFeatures.SMALL_HAFNIUM_ORE_KEY
                ),
                FOrePlacement.modifiersWithCount(
                    5,
                    HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(0),
                        VerticalAnchor.absolute(72)
                    ),
                ),
            )
        }

        fun registerKey(name: String?): ResourceKey<PlacedFeature> {
            return ResourceKey.create(
                Registries.PLACED_FEATURE,
                ResourceLocation(Fusarft.MOD_ID, name)
            )
        }

        private fun register(
            context: BootstapContext<PlacedFeature>,
            key: ResourceKey<PlacedFeature>,
            configuration: Holder<ConfiguredFeature<*, *>>,
            modifiers: List<PlacementModifier>,
        ) {
            context.register(key, PlacedFeature(configuration, modifiers.toList()))
        }
    }
}

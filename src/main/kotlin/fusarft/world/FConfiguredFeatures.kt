package fusarft.world

import fusarft.Fusarft
import fusarft.block.FBlocks
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest

class FConfiguredFeatures {
    companion object {
        val HAFNIUM_ORE_KEY = registerKey("hafnium_ore")
        val SMALL_HAFNIUM_ORE_KEY = registerKey("small_hafnium_ore")

        fun boostrap(context: BootstapContext<ConfiguredFeature<*, *>>) {
            val stoneReplacables: RuleTest = TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)
            val deepslateReplacables: RuleTest = TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)

            val overworldHafniumOres: List<OreConfiguration.TargetBlockState> =
                listOf(
                    OreConfiguration.target(
                        stoneReplacables,
                        FBlocks.HAFNIUM_ORE.defaultBlockState()
                    ),
                    OreConfiguration.target(
                        deepslateReplacables,
                        FBlocks.DEEPSLATE_HAFNIUM_ORE.defaultBlockState()
                    ),
                )

            register(
                context,
                HAFNIUM_ORE_KEY,
                Feature.ORE,
                OreConfiguration(overworldHafniumOres, 9)
            )
            register(
                context,
                SMALL_HAFNIUM_ORE_KEY,
                Feature.ORE,
                OreConfiguration(overworldHafniumOres, 9)
            )
        }

        private fun registerKey(name: String): ResourceKey<ConfiguredFeature<*, *>> {
            return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                ResourceLocation(Fusarft.MOD_ID, name)
            )
        }

        private fun <FC : FeatureConfiguration, F : Feature<FC>> register(
            context: BootstapContext<ConfiguredFeature<*, *>>,
            key: ResourceKey<ConfiguredFeature<*, *>>,
            feature: F,
            configuration: FC,
        ) {
            context.register(key, ConfiguredFeature(feature, configuration))
        }
    }
}

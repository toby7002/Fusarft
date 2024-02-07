package fusarft.datagen

import fusarft.datagen.lang.EnglishLangProvider
import fusarft.world.FConfiguredFeatures
import fusarft.world.FPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries

class DataGenerators : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack: FabricDataGenerator.Pack = gen.createPack()

        pack.addProvider(::RecipesProvider)
        pack.addProvider(::ModelsProvider)
        pack.addProvider(::EnglishLangProvider)
        pack.addProvider(::WorldFeaturesProvider)
        pack.addProvider(::LootTablesProvider)
        pack.addProvider(::ItemTagsProvider)
        pack.addProvider(::BlockTagsProvider)
    }

    override fun buildRegistry(registryBuilder: RegistrySetBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, FConfiguredFeatures::boostrap)
        registryBuilder.add(Registries.PLACED_FEATURE, FPlacedFeatures::boostrap)
    }
}

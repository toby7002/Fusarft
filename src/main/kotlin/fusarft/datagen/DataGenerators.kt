package fusarft.datagen

import fusarft.datagen.lang.EnglishLangProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

class DataGenerators : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
		val pack: FabricDataGenerator.Pack = gen.createPack()

		pack.addProvider(::RecipesProvider)
		pack.addProvider(::ModelsProvider)
		pack.addProvider(::EnglishLangProvider)
	}
}

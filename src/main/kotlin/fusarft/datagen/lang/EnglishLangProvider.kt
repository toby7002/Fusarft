package fusarft.datagen.lang

import fusarft.Fusarft
import fusarft.block.FBlocks
import fusarft.item.FItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider

class EnglishLangProvider(output: FabricDataOutput) : FabricLanguageProvider(output, "en_us") {
	override fun generateTranslations(gen: TranslationBuilder) {
		gen.add("itemGroup.${Fusarft.MOD_ID}.${Fusarft.MOD_ID}", "Fusarft")
		gen.add("itemGroup.${Fusarft.MOD_ID}.${Fusarft.MOD_ID}.button.github", "GitHub")
		gen.add("itemGroup.${Fusarft.MOD_ID}.${Fusarft.MOD_ID}.button.modrinth", "Modrinth")

		gen.add(FItems.HAFNIUM_INGOT, "Hafnium Ingot")
		gen.add(FItems.RAW_HAFNIUM, "Raw Hafnium")
		gen.add(FItems.GRAPHITE_INGOT, "Graphite Ingot")

		gen.add(FBlocks.HAFNIUM_ORE, "Hafnium Ore")
		gen.add(FBlocks.DEEPSLATE_HAFNIUM_ORE, "Deepslate Hafnium Ore")
		gen.add(FBlocks.BASIC_REACTOR_CASING, "Basic Reactor Casing")
		gen.add(FBlocks.ADVANCED_REACTOR_CASING, "Advanced Reactor Casing")
		gen.add(FBlocks.IC_GLASS, "Inertial Confinement Reactor Glass")
		gen.add(FBlocks.MC_GLASS, "Magnetic Confinement Reactor Glass")
		gen.add(FBlocks.LASER_PORT, "Laser Port")
	}
}

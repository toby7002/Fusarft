package fusarft.item

import fusarft.Fusarft
import io.wispforest.owo.itemgroup.OwoItemSettings
import io.wispforest.owo.registration.reflect.ItemRegistryContainer
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item

class FItems : ItemRegistryContainer {
	companion object {
		val HAFNIUM_INGOT = register("hafnium_ingot", Item(OwoItemSettings().group(Fusarft.ITEM_GROUP)))
		val RAW_HAFNIUM = register("raw_hafnium", RawHafnium())
		val GRAPHITE_INGOT = register("graphite_ingot", Item(OwoItemSettings().group(Fusarft.ITEM_GROUP)))
		val ZERO_ONE = register("zero_one", ZeroOne())

		private fun register(
			name: String,
			item: Item,
		): Item {
			return Registry.register(BuiltInRegistries.ITEM, ResourceLocation(Fusarft.MOD_ID, name), item)
		}

		fun init() {}
	}
}

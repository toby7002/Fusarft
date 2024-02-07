package fusarft

import fusarft.block.FBlocks
import fusarft.fluid.FFluids
import fusarft.item.FItems
import fusarft.world.gen.FWorldGeneration
import io.wispforest.owo.itemgroup.Icon
import io.wispforest.owo.itemgroup.OwoItemGroup
import io.wispforest.owo.itemgroup.gui.ItemGroupButton
import net.fabricmc.api.ModInitializer
import net.minecraft.resources.ResourceLocation

class Fusarft : ModInitializer {
    companion object {
        const val MOD_ID: String = "fusarft"
        val ITEM_GROUP: OwoItemGroup =
            OwoItemGroup.builder(ResourceLocation(MOD_ID, MOD_ID)) { Icon.of(FItems.HAFNIUM_INGOT) }
                .initializer { group ->
                    run {
                        group.addButton(
                            ItemGroupButton.github(group, "https://github.com/toby7002/Fusarft")
                        )
                        group.addButton(
                            ItemGroupButton.modrinth(group, "https://github.com/toby7002/Fusarft")
                        )
                    }
                }
                .build()
    }

    override fun onInitialize() {
        ITEM_GROUP.initialize()
        FItems.init()
        FBlocks.init()
        FWorldGeneration.init()
        FFluids.init()
    }
}

package fusarft.datagen

import fusarft.block.FBlocks
import fusarft.item.FItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.world.item.Items

class RecipesProvider(output: FabricDataOutput) : FabricRecipeProvider(output) {
    override fun buildRecipes(exporter: RecipeOutput) {
        registerOreSmeltingRecipes(exporter)
    }

    private fun registerOreSmeltingRecipes(exporter: RecipeOutput) {
        oreBlasting(
            exporter,
            listOf(FBlocks.HAFNIUM_ORE),
            RecipeCategory.TOOLS,
            FItems.HAFNIUM_INGOT,
            0.7f,
            100,
            "wtf"
        )
        oreBlasting(
            exporter,
            listOf(Items.COAL),
            RecipeCategory.TOOLS,
            FItems.GRAPHITE_INGOT,
            0.7f,
            100,
            "wqwerty"
        )
    }
}

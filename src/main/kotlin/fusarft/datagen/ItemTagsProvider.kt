package fusarft.datagen

import java.util.concurrent.CompletableFuture
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider
import net.minecraft.core.HolderLookup

class ItemTagsProvider(
    output: FabricDataOutput,
    completableFuture: CompletableFuture<HolderLookup.Provider>
) :
    ItemTagProvider(
        output,
        completableFuture,
    ) {
    override fun addTags(arg: HolderLookup.Provider) {}
}

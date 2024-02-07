package fusarft.datagen

import java.util.concurrent.CompletableFuture
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries

class WorldFeaturesProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<HolderLookup.Provider>,
) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun getName(): String {
        return "World features provider"
    }

    override fun configure(
        registries: HolderLookup.Provider,
        entries: Entries,
    ) {
        entries.addAll(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE))
        entries.addAll(registries.lookupOrThrow(Registries.PLACED_FEATURE))
    }
}

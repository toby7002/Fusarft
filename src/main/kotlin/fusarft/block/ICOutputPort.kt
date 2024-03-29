package fusarft.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.block.Block

class ICOutputPort : Block(FabricBlockSettings.create()) {
    companion object {
        fun getName(): String {
            return "ic_output_port"
        }
    }
}

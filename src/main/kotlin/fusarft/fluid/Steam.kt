package fusarft.fluid

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.item.Item
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.material.FlowingFluid
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState
import net.minecraft.world.level.material.Fluids

open class Steam : FlowingFluid() {
	companion object {
		const val STEAM: String = "steam"
		const val FLOWING_STEAM: String = "flowing_steam"
		const val STEAM_BLOCK: String = "steam_block"
		const val STEAM_BUCKET: String = "steam_bucket"
	}
    override fun getBucket(): Item? {
        return FFluids.STEAM_BUCKET
    }

    override fun canBeReplacedWith(
        state: FluidState,
        level: BlockGetter,
        pos: BlockPos,
        fluid: Fluid,
        direction: Direction,
    ): Boolean {
        return false
    }

    override fun getTickDelay(level: LevelReader): Int {
        return 5
    }

    override fun getExplosionResistance(): Float {
        return 0f
    }

	override fun isSame(fluid: Fluid): Boolean {
		return fluid === FFluids.STEAM || fluid === FFluids.FLOWING_STEAM
	}

    override fun createLegacyBlock(state: FluidState): BlockState? {
        return FFluids.STEAM_BLOCK?.defaultBlockState()
            ?.setValue(BlockStateProperties.LEVEL, getLegacyLevel(state))
    }

    override fun isSource(state: FluidState): Boolean {
        return false
    }

    override fun getAmount(state: FluidState): Int {
        return 8
    }

    override fun getFlowing(): FlowingFluid? {
        return FFluids.FLOWING_STEAM
    }

    override fun getSource(): FlowingFluid? {
        return FFluids.STEAM
    }

    override fun canConvertToSource(level: Level): Boolean {
        return false
    }

    override fun beforeDestroyingBlock(
        level: LevelAccessor,
        pos: BlockPos,
        state: BlockState,
    ) {
        val blockEntity = if (state.hasBlockEntity()) level.getBlockEntity(pos) else null
        Block.dropResources(state, level, pos, blockEntity)
    }

    override fun getSlopeFindDistance(level: LevelReader): Int {
        return 4
    }

    override fun getDropOff(level: LevelReader): Int {
        return 1
    }

    class FLOWING : Steam() {
        override fun createFluidStateDefinition(
            builder: StateDefinition.Builder<Fluid, FluidState>
        ) {
            super.createFluidStateDefinition(builder)
            builder.add(LEVEL)
        }

        override fun getAmount(state: FluidState): Int {
            return state.getValue(LEVEL)
        }

        override fun isSource(state: FluidState): Boolean {
            return false
        }
    }

    class SOURCE : Steam() {
        override fun getAmount(state: FluidState): Int {
            return 8
        }

        override fun isSource(state: FluidState): Boolean {
            return true
        }
    }
}

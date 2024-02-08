package fusarft.fluid

import fusarft.Fusarft
import fusarft.item.SteamBucket
import io.wispforest.owo.itemgroup.OwoItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BucketItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.LiquidBlock
import net.minecraft.world.level.material.FlowingFluid

class FFluids {
    companion object {
        var TRITIUM: FlowingFluid? = null
        var FLOWING_TRITIUM: FlowingFluid? = null
        var TRITIUM_BLOCK: Block? = null
        var TRITIUM_BUCKET: Item? = null

		var DEUTERIUM: FlowingFluid? = null
		var FLOWING_DEUTERIUM: FlowingFluid? = null
		var DEUTERIUM_BLOCK: Block? = null
		var DEUTERIUM_BUCKET: Item? = null

		var STEAM: FlowingFluid? = null
		var FLOWING_STEAM: FlowingFluid? = null
		var STEAM_BLOCK: Block? = null
		var STEAM_BUCKET: Item? = null

        fun init() {
            registerTritium()
			registerDeuterium()
			registerSteam()
        }

		private fun registerTritium() {
			TRITIUM =
				Registry.register(
					BuiltInRegistries.FLUID,
					ResourceLocation(Fusarft.MOD_ID, Tritium.TRITIUM),
					Tritium.SOURCE(),
				)
			FLOWING_TRITIUM =
				Registry.register(
					BuiltInRegistries.FLUID,
					ResourceLocation(Fusarft.MOD_ID, Tritium.FLOWING_TRITIUM),
					Tritium.FLOWING(),
				)

			TRITIUM_BLOCK =
				TRITIUM?.let {
					Registry.register(
						BuiltInRegistries.BLOCK,
						ResourceLocation(Fusarft.MOD_ID, Tritium.TRITIUM_BLOCK),
						object : LiquidBlock(it, FabricBlockSettings.copyOf(Blocks.WATER)) {},
					)
				}

			TRITIUM_BUCKET =
				TRITIUM?.let {
					BucketItem(
						it,
						OwoItemSettings()
							.group(Fusarft.ITEM_GROUP)
							.recipeRemainder(Items.BUCKET)
							.maxCount(1),
					)
				}
					?.let {
						Registry.register(
							BuiltInRegistries.ITEM,
							ResourceLocation(Fusarft.MOD_ID, Tritium.TRITIUM_BUCKET),
							it,
						)
					}
		}
		private fun registerDeuterium() {
			DEUTERIUM =
				Registry.register(
					BuiltInRegistries.FLUID,
					ResourceLocation(Fusarft.MOD_ID, Deuterium.DEUTERIUM),
					Deuterium.SOURCE(),
				)
			FLOWING_DEUTERIUM =
				Registry.register(
					BuiltInRegistries.FLUID,
					ResourceLocation(Fusarft.MOD_ID, Deuterium.FLOWING_DEUTERIUM),
					Deuterium.FLOWING(),
				)

			DEUTERIUM_BLOCK =
				DEUTERIUM?.let {
					Registry.register(
						BuiltInRegistries.BLOCK,
						ResourceLocation(Fusarft.MOD_ID, Deuterium.DEUTERIUM_BLOCK),
						object : LiquidBlock(it, FabricBlockSettings.copyOf(Blocks.WATER)) {},
					)
				}

			DEUTERIUM_BUCKET =
				DEUTERIUM?.let {
					BucketItem(
						it,
						OwoItemSettings()
							.group(Fusarft.ITEM_GROUP)
							.recipeRemainder(Items.BUCKET)
							.maxCount(1),
					)
				}
					?.let {
						Registry.register(
							BuiltInRegistries.ITEM,
							ResourceLocation(Fusarft.MOD_ID, Deuterium.DEUTERIUM_BUCKET),
							it,
						)
					}
		}
		private fun registerSteam() {
			STEAM =
				Registry.register(
					BuiltInRegistries.FLUID,
					ResourceLocation(Fusarft.MOD_ID, Steam.STEAM),
					Steam.SOURCE(),
				)
			FLOWING_STEAM =
				Registry.register(
					BuiltInRegistries.FLUID,
					ResourceLocation(Fusarft.MOD_ID, Steam.FLOWING_STEAM),
					Steam.FLOWING(),
				)

			STEAM_BLOCK =
				STEAM?.let {
					Registry.register(
						BuiltInRegistries.BLOCK,
						ResourceLocation(Fusarft.MOD_ID, Steam.STEAM_BLOCK),
						object : LiquidBlock(it, FabricBlockSettings.copyOf(Blocks.WATER)) {},
					)
				}

			STEAM_BUCKET =
				STEAM?.let {
					SteamBucket()
				}
					?.let {
						Registry.register(
							BuiltInRegistries.ITEM,
							ResourceLocation(Fusarft.MOD_ID, Steam.STEAM_BUCKET),
							it,
						)
					}
		}
    }
}

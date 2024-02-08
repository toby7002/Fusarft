package fusarft.item

import fusarft.Fusarft
import fusarft.fluid.FFluids
import io.wispforest.owo.itemgroup.OwoItemSettings
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.BucketItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class SteamBucket: BucketItem(FFluids.STEAM!!, OwoItemSettings().group(Fusarft.ITEM_GROUP)) {
	override fun use(level: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
		val itemStack = player.getItemInHand(usedHand)

		return InteractionResultHolder.fail(itemStack)
	}
}

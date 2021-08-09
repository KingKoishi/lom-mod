
package net.mcreator.lom.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.lom.LomModElements;

@LomModElements.ModElement.Tag
public class UnobtainableItemsItemGroup extends LomModElements.ModElement {
	public UnobtainableItemsItemGroup(LomModElements instance) {
		super(instance, 95);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabunobtainable_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.COMMAND_BLOCK, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}

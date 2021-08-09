
package net.mcreator.lom.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.lom.item.AncientShardItem;
import net.mcreator.lom.LomModElements;

@LomModElements.ModElement.Tag
public class LOMItemsItemGroup extends LomModElements.ModElement {
	public LOMItemsItemGroup(LomModElements instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablom_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AncientShardItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}

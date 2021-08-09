
package net.mcreator.lom.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.lom.item.CitriumItem;
import net.mcreator.lom.LomModElements;

@LomModElements.ModElement.Tag
public class LOMArmorItemGroup extends LomModElements.ModElement {
	public LOMArmorItemGroup(LomModElements instance) {
		super(instance, 90);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablom_armor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CitriumItem.body, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}

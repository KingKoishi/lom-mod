
package net.mcreator.lom.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.lom.itemgroup.UnobtainableItemsItemGroup;
import net.mcreator.lom.LomModElements;

@LomModElements.ModElement.Tag
public class FireSpellBulletItem extends LomModElements.ModElement {
	@ObjectHolder("lom:fire_spell_bullet")
	public static final Item block = null;
	public FireSpellBulletItem(LomModElements instance) {
		super(instance, 119);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(UnobtainableItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("fire_spell_bullet");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}

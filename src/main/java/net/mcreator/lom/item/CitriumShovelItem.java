
package net.mcreator.lom.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.lom.itemgroup.LOMToolsItemGroup;
import net.mcreator.lom.LomModElements;

@LomModElements.ModElement.Tag
public class CitriumShovelItem extends LomModElements.ModElement {
	@ObjectHolder("lom:citrium_shovel")
	public static final Item block = null;
	public CitriumShovelItem(LomModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 400;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 1.5f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CitriumIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(LOMToolsItemGroup.tab)) {
		}.setRegistryName("citrium_shovel"));
	}
}

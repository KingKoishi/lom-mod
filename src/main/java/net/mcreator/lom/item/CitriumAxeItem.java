
package net.mcreator.lom.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.lom.itemgroup.LOMToolsItemGroup;
import net.mcreator.lom.LomModElements;

@LomModElements.ModElement.Tag
public class CitriumAxeItem extends LomModElements.ModElement {
	@ObjectHolder("lom:citrium_axe")
	public static final Item block = null;
	public CitriumAxeItem(LomModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 400;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 7f;
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
		}, 1, -3.1f, new Item.Properties().group(LOMToolsItemGroup.tab)) {
		}.setRegistryName("citrium_axe"));
	}
}

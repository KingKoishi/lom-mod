
package net.mcreator.lom.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.lom.itemgroup.LOMToolsItemGroup;
import net.mcreator.lom.LomModElements;

@LomModElements.ModElement.Tag
public class VirulentGreatbladeItem extends LomModElements.ModElement {
	@ObjectHolder("lom:virulent_greatblade")
	public static final Item block = null;
	public VirulentGreatbladeItem(LomModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 775;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(VirulIngotItem.block, (int) (1)));
			}
		}, 3, -3.2f, new Item.Properties().group(LOMToolsItemGroup.tab)) {
		}.setRegistryName("virulent_greatblade"));
	}
}

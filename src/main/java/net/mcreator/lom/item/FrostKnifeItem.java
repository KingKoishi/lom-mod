
package net.mcreator.lom.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.lom.procedures.FrostKnifeLivingEntityIsHitWithToolProcedure;
import net.mcreator.lom.itemgroup.LOMToolsItemGroup;
import net.mcreator.lom.LomModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@LomModElements.ModElement.Tag
public class FrostKnifeItem extends LomModElements.ModElement {
	@ObjectHolder("lom:frost_knife")
	public static final Item block = null;
	public FrostKnifeItem(LomModElements instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 150;
			}

			public float getEfficiency() {
				return 3f;
			}

			public float getAttackDamage() {
				return 0.5f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 9;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FrostGemItem.block, (int) (1)));
			}
		}, 3, -2.2f, new Item.Properties().group(LOMToolsItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Inflicts:"));
				list.add(new StringTextComponent("Slowness (0:10)"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					FrostKnifeLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("frost_knife"));
	}
}

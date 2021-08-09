
package net.mcreator.lom.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.lom.itemgroup.LOMBlocksItemGroup;
import net.mcreator.lom.LomModElements;

import java.util.List;
import java.util.Collections;

@LomModElements.ModElement.Tag
public class BlockOfVirulBlock extends LomModElements.ModElement {
	@ObjectHolder("lom:block_of_virul")
	public static final Block block = null;
	public BlockOfVirulBlock(LomModElements instance) {
		super(instance, 138);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LOMBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(6f, 5f).setLightLevel(s -> 0).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("block_of_virul");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}

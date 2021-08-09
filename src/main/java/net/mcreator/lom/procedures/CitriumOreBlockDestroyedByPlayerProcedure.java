package net.mcreator.lom.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.lom.LomModElements;
import net.mcreator.lom.LomMod;

import java.util.Map;

@LomModElements.ModElement.Tag
public class CitriumOreBlockDestroyedByPlayerProcedure extends LomModElements.ModElement {
	public CitriumOreBlockDestroyedByPlayerProcedure(LomModElements instance) {
		super(instance, 128);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LomMod.LOGGER.warn("Failed to load dependency entity for procedure CitriumOreBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("lom:citrium_ingot_furnace_recipe")});
		}
		if (entity instanceof ServerPlayerEntity) {
			((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("lom:citrium_ingot_blast_recipe")});
		}
	}
}

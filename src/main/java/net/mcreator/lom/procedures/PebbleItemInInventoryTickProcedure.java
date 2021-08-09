package net.mcreator.lom.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.lom.LomModElements;
import net.mcreator.lom.LomMod;

import java.util.Map;

@LomModElements.ModElement.Tag
public class PebbleItemInInventoryTickProcedure extends LomModElements.ModElement {
	public PebbleItemInInventoryTickProcedure(LomModElements instance) {
		super(instance, 120);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LomMod.LOGGER.warn("Failed to load dependency entity for procedure PebbleItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("lom:cobblestone_recipe")});
		}
	}
}

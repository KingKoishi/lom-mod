package net.mcreator.lom.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.lom.LomModElements;
import net.mcreator.lom.LomMod;

import java.util.Map;

@LomModElements.ModElement.Tag
public class RockLizardOnInitialEntitySpawnProcedure extends LomModElements.ModElement {
	public RockLizardOnInitialEntitySpawnProcedure(LomModElements instance) {
		super(instance, 117);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LomMod.LOGGER.warn("Failed to load dependency entity for procedure RockLizardOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPosY()) > 60)) {
			if (!entity.world.isRemote())
				entity.remove();
		}
	}
}

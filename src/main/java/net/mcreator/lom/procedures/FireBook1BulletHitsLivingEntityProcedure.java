package net.mcreator.lom.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.lom.LomModElements;
import net.mcreator.lom.LomMod;

import java.util.Map;

@LomModElements.ModElement.Tag
public class FireBook1BulletHitsLivingEntityProcedure extends LomModElements.ModElement {
	public FireBook1BulletHitsLivingEntityProcedure(LomModElements instance) {
		super(instance, 124);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				LomMod.LOGGER.warn("Failed to load dependency entity for procedure FireBook1BulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.MAGIC, (float) 1.5);
		entity.attackEntityFrom(DamageSource.IN_FIRE, (float) 3);
		entity.setFire((int) 5);
	}
}

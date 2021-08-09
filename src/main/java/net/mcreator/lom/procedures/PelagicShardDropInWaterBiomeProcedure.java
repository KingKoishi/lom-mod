package net.mcreator.lom.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.RegistryKey;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.mcreator.lom.item.PelagicShardItem;
import net.mcreator.lom.LomModElements;
import net.mcreator.lom.LomMod;

import java.util.Map;
import java.util.HashMap;

@LomModElements.ModElement.Tag
public class PelagicShardDropInWaterBiomeProcedure extends LomModElements.ModElement {
	public PelagicShardDropInWaterBiomeProcedure(LomModElements instance) {
		super(instance, 77);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				LomMod.LOGGER.warn("Failed to load dependency x for procedure PelagicShardDropInWaterBiome!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				LomMod.LOGGER.warn("Failed to load dependency y for procedure PelagicShardDropInWaterBiome!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				LomMod.LOGGER.warn("Failed to load dependency z for procedure PelagicShardDropInWaterBiome!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				LomMod.LOGGER.warn("Failed to load dependency world for procedure PelagicShardDropInWaterBiome!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
				&& BiomeDictionary
						.hasType(
								RegistryKey
										.getOrCreateKey(Registry.BIOME_KEY,
												world.func_241828_r().getRegistry(Registry.BIOME_KEY)
														.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))),
								BiomeDictionary.Type.OCEAN))) {
			if ((Math.random() < 0.76)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PelagicShardItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}

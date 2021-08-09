package net.mcreator.lom.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.lom.entity.TinyLizardEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class TinyLizardRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(TinyLizardEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelshard_lizard(), 0.1f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("lom:textures/tiny_lizard.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelshard_lizard extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer front_leg_left;
		private final ModelRenderer front_leg_right;
		private final ModelRenderer back_leg_left;
		private final ModelRenderer back_leg_right;
		private final ModelRenderer tail;
		public Modelshard_lizard() {
			textureWidth = 26;
			textureHeight = 18;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 20.75F, -4.0F);
			head.setTextureOffset(7, 12).addBox(-1.5F, -1.25F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -4.0F, 4.0F, 3.0F, 9.0F, 0.0F, false);
			front_leg_left = new ModelRenderer(this);
			front_leg_left.setRotationPoint(1.5F, 22.0F, -2.5F);
			front_leg_left.setTextureOffset(4, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			front_leg_right = new ModelRenderer(this);
			front_leg_right.setRotationPoint(-1.5F, 22.0F, -2.5F);
			front_leg_right.setTextureOffset(4, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			back_leg_left = new ModelRenderer(this);
			back_leg_left.setRotationPoint(1.5F, 22.0F, 3.5F);
			back_leg_left.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			back_leg_right = new ModelRenderer(this);
			back_leg_right.setRotationPoint(-1.5F, 22.0F, 3.5F);
			back_leg_right.setTextureOffset(0, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 20.825F, 5.0F);
			setRotationAngle(tail, -0.3054F, 0.0F, 0.0F);
			tail.setTextureOffset(0, 12).addBox(-0.5F, -0.709F, -1.2552F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			front_leg_left.render(matrixStack, buffer, packedLight, packedOverlay);
			front_leg_right.render(matrixStack, buffer, packedLight, packedOverlay);
			back_leg_left.render(matrixStack, buffer, packedLight, packedOverlay);
			back_leg_right.render(matrixStack, buffer, packedLight, packedOverlay);
			tail.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.back_leg_right.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.back_leg_left.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.tail.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.front_leg_right.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.front_leg_left.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}

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

import net.mcreator.lom.entity.CryptSaildonEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CryptSaildonRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(CryptSaildonEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelsaildon(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("lom:textures/crypt_saildon.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelsaildon extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer front_leg_left;
		private final ModelRenderer front_leg_right;
		private final ModelRenderer back_leg_left;
		private final ModelRenderer back_leg_right;
		public Modelsaildon() {
			textureWidth = 56;
			textureHeight = 44;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 10.0F, -9.0F);
			head.setTextureOffset(0, 28).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-5.0F, -17.0F, -9.0F, 10.0F, 10.0F, 18.0F, 0.0F, false);
			body.setTextureOffset(24, 14).addBox(0.0F, -23.0F, -7.0F, 0.0F, 6.0F, 14.0F, 0.0F, false);
			front_leg_left = new ModelRenderer(this);
			front_leg_left.setRotationPoint(2.5F, 17.0F, -6.5F);
			front_leg_left.setTextureOffset(32, 34).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			front_leg_right = new ModelRenderer(this);
			front_leg_right.setRotationPoint(-2.5F, 17.0F, -6.5F);
			front_leg_right.setTextureOffset(32, 34).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			back_leg_left = new ModelRenderer(this);
			back_leg_left.setRotationPoint(2.5F, 17.0F, 6.5F);
			back_leg_left.setTextureOffset(32, 34).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			back_leg_right = new ModelRenderer(this);
			back_leg_right.setRotationPoint(-2.5F, 17.0F, 6.5F);
			back_leg_right.setTextureOffset(32, 34).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
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
			this.front_leg_right.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.front_leg_left.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}

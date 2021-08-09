package net.mcreator.lom.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.lom.entity.DustDevilEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DustDevilRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DustDevilEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeltwister(), 0f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("lom:textures/dust_devil.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modeltwister extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body_1;
		private final ModelRenderer body_2;
		private final ModelRenderer body_3;
		public Modeltwister() {
			textureWidth = 62;
			textureHeight = 44;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 5.0F, 0.0F);
			head.setTextureOffset(0, 28).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			body_1 = new ModelRenderer(this);
			body_1.setRotationPoint(0.0F, 13.5F, 0.0F);
			setRotationAngle(body_1, 0.0F, 0.7854F, 0.0F);
			body_1.setTextureOffset(0, 0).addBox(-6.0F, -6.5F, -6.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);
			body_2 = new ModelRenderer(this);
			body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
			body_1.addChild(body_2);
			setRotationAngle(body_2, 0.0F, -0.7854F, 0.0F);
			body_2.setTextureOffset(0, 16).addBox(-5.0F, -0.5F, -5.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);
			body_3 = new ModelRenderer(this);
			body_3.setRotationPoint(0.0F, 0.0F, 0.0F);
			body_2.addChild(body_3);
			setRotationAngle(body_3, 0.0F, -0.7854F, 0.0F);
			body_3.setTextureOffset(30, 16).addBox(-4.0F, 3.5F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body_1.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.body_3.rotateAngleY = f2 / 20.f;
			this.body_1.rotateAngleY = f2 / 20.f;
			this.body_2.rotateAngleY = f2 / 20.f;
		}
	}
}

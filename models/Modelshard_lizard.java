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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.back_leg_right.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.back_leg_left.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.tail.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.front_leg_right.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.front_leg_left.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}
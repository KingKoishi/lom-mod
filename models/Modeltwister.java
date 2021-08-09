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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body_1.render(matrixStack, buffer, packedLight, packedOverlay);
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
		this.body_3.rotateAngleY = f2 / 20.f;
		this.body_1.rotateAngleY = f2 / 20.f;
		this.body_2.rotateAngleY = f2 / 20.f;
	}
}
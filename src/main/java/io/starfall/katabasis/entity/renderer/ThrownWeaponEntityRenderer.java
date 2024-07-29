package io.starfall.katabasis.entity.renderer;

import io.starfall.katabasis.entity.ThrownWeaponEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionf;

@Environment(EnvType.CLIENT)
public class ThrownWeaponEntityRenderer extends EntityRenderer<ThrownWeaponEntity> {

	private final HeldItemRenderer heldItemRenderer;

	public ThrownWeaponEntityRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		this.heldItemRenderer = ctx.getHeldItemRenderer();
	}

	@Override
	public void render(ThrownWeaponEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

		if(!(entity.getOwner() instanceof LivingEntity living)) return;

		ItemStack stack = entity.asItemStack();
		matrices.push();

			float lerpedYaw = MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw());
			float lerpedPitch = MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch());

			matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(lerpedYaw - 180.0F));
			matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(lerpedPitch - 90.0F));

//			float pitchModifier = MathHelper.clamp(
//				Math.abs(lerpedPitch) / 45.0F,
//				0.35F,
//				2.00F
//			);
//
//			if(pitchModifier >= 1.85F) {
//				pitchModifier = -1.0F;
//			}
//			matrices.translate(0.00F,0.00F,0.35F);

			heldItemRenderer.renderItem(
				living,
				stack,
				ModelTransformationMode.THIRD_PERSON_RIGHT_HAND,
				false,
				matrices,
				vertexConsumers,
				light
			);

		matrices.pop();

	}

	@Override
	public Identifier getTexture(ThrownWeaponEntity entity) {
		return null;
	}

}

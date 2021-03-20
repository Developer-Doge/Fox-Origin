package wiicustomorigins.mixin;

import io.github.apace100.origins.component.OriginComponent;
import wiicustomorigins.common.power.ModifySizePower;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TrackTargetGoal.class)
public abstract class TrackTargetGoalMixin {
	@Final
	@Shadow
	protected MobEntity mob;
	
	@Shadow
	protected LivingEntity target;
	
	@Inject(method = "getFollowRange", at = @At("RETURN"), cancellable = true)
	private void getFollowRange(CallbackInfoReturnable<Double> callbackInfo) {
		LivingEntity target = mob.getTarget();
		if (target == null) {
			target = this.target;
		}
		if (target instanceof PlayerEntity && OriginComponent.hasPower(target, ModifySizePower.class)) {
			callbackInfo.setReturnValue(callbackInfo.getReturnValue() * OriginComponent.getPowers(target, ModifySizePower.class).get(0).scale);
		}
	}
}

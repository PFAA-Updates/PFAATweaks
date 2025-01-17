package com.greenfirework.PFAATweaks.mixins.tg;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import techguns.damagesystem.DamageSystem;

@Mixin(value = DamageSystem.class, remap = false)
public abstract class TG_DamageRescale {


	@ModifyConstant(method = "getDamageFactor(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/entity/EntityLivingBase;)F", require = 1, constant = @Constant(floatValue = 1.0F))
	private static float constantValue(float oldValue) {
		return 35.0F;
	}
	
	
}

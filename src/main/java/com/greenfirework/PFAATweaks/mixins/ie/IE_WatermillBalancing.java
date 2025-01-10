package com.greenfirework.PFAATweaks.mixins.ie;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import blusunrize.immersiveengineering.common.blocks.TileEntityIEBase;
import blusunrize.immersiveengineering.common.blocks.wooden.TileEntityWatermill;

@Mixin(value = TileEntityWatermill.class, remap = false)
public abstract class IE_WatermillBalancing extends TileEntityIEBase {
	
	@Inject(method = "getPower()D", at=@At("RETURN"), cancellable = true)
	public void scalePower(CallbackInfoReturnable<Double> cir) {
		cir.setReturnValue(cir.getReturnValue() * 0.2);
	}
}

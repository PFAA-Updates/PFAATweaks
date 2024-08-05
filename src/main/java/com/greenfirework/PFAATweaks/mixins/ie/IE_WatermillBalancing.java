package com.greenfirework.PFAATweaks.mixins.ie;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At;

import blusunrize.immersiveengineering.common.blocks.TileEntityIEBase;
import blusunrize.immersiveengineering.common.blocks.wooden.TileEntityWatermill;

@Mixin(value = TileEntityWatermill.class, remap = false)
public abstract class IE_WatermillBalancing extends TileEntityIEBase {
	
	@ModifyArg(method = "getPower()D", at=@At("RETURN"))
	public double scalePower(double retVal) {
		return retVal * 0.2;
	}
}

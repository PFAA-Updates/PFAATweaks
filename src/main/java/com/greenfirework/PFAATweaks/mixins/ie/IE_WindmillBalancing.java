package com.greenfirework.PFAATweaks.mixins.ie;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At;

import blusunrize.immersiveengineering.common.blocks.TileEntityIEBase;
import blusunrize.immersiveengineering.common.blocks.wooden.TileEntityWindmill;

@Mixin(value = TileEntityWindmill.class, remap = false)
public abstract class IE_WindmillBalancing extends TileEntityIEBase {
	
	@ModifyArg(method = "func_145845_h()V", at=@At(value = "INVOKE", target = "Lblusunrize/immersiveengineering/common/blocks/energy/TileEntityDynamo;inputRotation(DI)V"))
	public double scaleWindmillPower(double inputPower) {
		return inputPower * 0.1;
	}
}

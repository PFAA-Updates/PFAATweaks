package com.greenfirework.PFAATweaks.mixins.mg;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import com.cout970.magneticraft.tileentity.multiblock.TileMB_Base;
import com.cout970.magneticraft.tileentity.multiblock.controllers.TileCrusher;


@Mixin(value = TileCrusher.class)
public abstract class MG_TweakCrusherPower extends TileMB_Base {


	@ModifyConstant(method = "updateEntity()V", require = 1, constant = @Constant(doubleValue = 10.0, ordinal = 0))
	public double speedValue(double speed) {
		return 0.5;
	}
	
	@ModifyConstant(method = "updateEntity()V", require = 1, constant = @Constant(doubleValue = 10.0, ordinal = 1))
	public double speedToRF(double speed) {
		return 200;
	}
	
	@ModifyConstant(method = "updateEntity()V", require = 1, constant = @Constant(doubleValue = 10.0, ordinal = 2))
	public double SpeedtoRF2(double speed) {
		return 800;
	}
	
	
}

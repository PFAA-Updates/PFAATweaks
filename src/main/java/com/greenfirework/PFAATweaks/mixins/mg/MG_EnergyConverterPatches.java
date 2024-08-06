package com.greenfirework.PFAATweaks.mixins.mg;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import com.cout970.magneticraft.api.util.EnergyConverter;


@Mixin(value = EnergyConverter.class, remap = false)
public abstract class MG_EnergyConverterPatches {


	@ModifyConstant(method = {"RFtoW(D)D", "WtoRF(D)D"}, require = 1, constant = @Constant())
	public double ConversionFactorW_RF(double speed) {
		return 2.0;
	}

	@ModifyConstant(method = {"WtoSTEAM(D)D", "STEAMtoW(D)D"}, require = 1, constant = @Constant())
	public double ConversionFactorW_Steam(double speed) {
		return 4.0;
	}

	@ModifyConstant(method = {"FUELtoW(D)D", "WtoFUEL(D)D"}, require = 1, constant = @Constant())
	public double ConversionFactorW_Fuel(double speed) {
		return 100.0;
	}

	@ModifyConstant(method = {"WtoEU(D)D", "EUtoW(D)D"}, require = 1, constant = @Constant())
	public double ConversionFactorW_EU(double speed) {
		return 8.0;
	}	
	
}

package com.greenfirework.PFAATweaks.mixins.fz;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;
import factorization.charge.TileEntitySteamTurbine;
import factorization.shared.TileEntityCommon;


@Mixin(value = TileEntitySteamTurbine.class, remap = true)
public abstract class FZ_SteamChangeTurbine extends TileEntityCommon {

	@ModifyConstant(method = "updateEntity()V", require = 1, constant = @Constant(stringValue = "steam"))
	public String constantValue(String oldValue) {
		return "fzsteam";
	}
	
	
}

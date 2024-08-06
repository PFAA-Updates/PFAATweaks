package com.greenfirework.PFAATweaks.mixins.fz;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;
import factorization.charge.TileEntitySteamTurbine;
import factorization.common.Registry;
import factorization.shared.TileEntityCommon;


@Mixin(value = Registry.class, remap = true)
public abstract class FZ_SteamChangeRegistry extends TileEntityCommon {

	@ModifyConstant(method = "makeItems()V", require = 1, constant = @Constant(stringValue = "steam"))
	public String constantValue(String oldValue) {
		return "fzsteam";
	}
	
	
}

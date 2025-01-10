package com.greenfirework.PFAATweaks.mixins.fz;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;
import factorization.beauty.TileEntitySteamShaft;
import factorization.shared.TileEntityCommon;


@Mixin(value = TileEntitySteamShaft.class, remap = true)
public abstract class FZ_SteamChangeShaft extends TileEntityCommon {

	@ModifyConstant(method = "updateEntity()V", require = 1, constant = @Constant(stringValue = "steam"))
	public String constantValue(String oldValue) {
		return "fzsteam";
	}
}

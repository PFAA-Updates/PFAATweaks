package com.greenfirework.PFAATweaks.mixins.fz;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;
import factorization.common.Registry;


@Mixin(value = Registry.class, remap = false)
public abstract class FZ_SteamChangeRegistry {

	@ModifyConstant(method = "makeItems()V", require = 1, constant = @Constant(stringValue = "steam"))
	public String constantValue(String oldValue) {
		return "fzsteam";
	}
	
	
}

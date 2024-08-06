package com.greenfirework.PFAATweaks.mixins.fz;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;
import factorization.charge.TileEntitySolarBoiler;
import factorization.shared.TileEntityCommon;


@Mixin(value = TileEntitySolarBoiler.class, remap = true)
public abstract class FZ_SteamChangeSolarBoiler extends TileEntityCommon {

	@ModifyConstant(method = {"setupSteam()V", "putData(Lfactorization/api/datahelpers/DataHelper;)V"}, require = 1, constant = @Constant(stringValue = "steam"))
	public String constantValue(String oldValue) {
		return "fzsteam";
	}
	
	
}

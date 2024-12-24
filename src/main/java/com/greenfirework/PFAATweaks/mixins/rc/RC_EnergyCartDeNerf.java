package com.greenfirework.PFAATweaks.mixins.rc;

import org.spongepowered.asm.mixin.Mixin;

import mods.railcraft.common.carts.CartContainerBase;

@Mixin(targets = { "mods.railcraft.common.carts.EntityCartEnergy" }, remap = false)
public abstract class RC_EnergyCartDeNerf extends CartContainerBase {

	public RC_EnergyCartDeNerf() {
		super(null);
	}

    public final float getMaxCartSpeedOnRail() {
    	return 1.2f;
    }
}

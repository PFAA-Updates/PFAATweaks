package com.greenfirework.PFAATweaks.mixins.rc;

import org.spongepowered.asm.mixin.Mixin;

import mods.railcraft.common.carts.Train;


@Mixin(value = Train.class, remap = false)
public abstract class RC_TrainDeNerf {
	
	public float getMaxSpeed() {
		return 1.2f;
	}
	
}

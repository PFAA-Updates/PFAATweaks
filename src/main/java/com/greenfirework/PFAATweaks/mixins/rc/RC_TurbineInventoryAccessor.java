package com.greenfirework.PFAATweaks.mixins.rc;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import mods.railcraft.common.blocks.machine.alpha.TileSteamTurbine;
import mods.railcraft.common.util.inventory.StandaloneInventory;

@Mixin(value=TileSteamTurbine.class, remap=false)
public interface RC_TurbineInventoryAccessor {
	
	@Accessor StandaloneInventory getInv();
}

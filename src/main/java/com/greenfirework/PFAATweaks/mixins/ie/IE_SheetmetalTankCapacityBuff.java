package com.greenfirework.PFAATweaks.mixins.ie;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.At;

import blusunrize.immersiveengineering.common.blocks.TileEntityIEBase;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntitySheetmetalTank;
import blusunrize.immersiveengineering.common.blocks.wooden.TileEntityWindmill;

@Mixin(value = TileEntitySheetmetalTank.class, remap = false)
public abstract class IE_SheetmetalTankCapacityBuff extends TileEntityIEBase {
	
	@ModifyConstant(method = "<init>()V", require = 1)
	public int setTankSize(int inputSize) {
		return 1024000;
	}
}

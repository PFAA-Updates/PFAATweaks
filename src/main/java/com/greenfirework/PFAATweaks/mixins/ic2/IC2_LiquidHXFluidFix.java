package com.greenfirework.PFAATweaks.mixins.ic2;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At;

import ic2.core.block.TileEntityHeatSourceInventory;
import ic2.core.block.machine.tileentity.TileEntityLiquidHeatExchanger;
import net.minecraftforge.fluids.Fluid;

@Mixin(value = TileEntityLiquidHeatExchanger.class, remap = false)
public abstract class IC2_LiquidHXFluidFix extends TileEntityHeatSourceInventory {
	
	@Redirect(method = "fillHeatBuffer(I)I", at = @At(value = "INVOKE", target = "Ljava/lang/Object;equals(Ljava/lang/Object;)Z"))
	private boolean equals(Fluid inOutputTank, Fluid fluidOutput) {
		return inOutputTank.getID() == fluidOutput.getID();
	}
	
}

package com.greenfirework.PFAATweaks.mixins.ic2;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import ic2.core.block.machine.tileentity.TileEntityElectricMachine;
import ic2.core.block.machine.tileentity.TileEntityMiner;


@Mixin(value = TileEntityMiner.class, remap = false)
public abstract class IC2_MinerSpeedFix extends TileEntityElectricMachine {

	public IC2_MinerSpeedFix() {
    	super(1000, 1, 0, false);
	}

	@ModifyConstant(method = "mineBlock(III)Lic2/core/block/machine/tileentity/TileEntityMiner$MineResult;", require = 1, constant = @Constant(intValue = 50))
	private int minerSpeedFix(int speed) {
		return 20;
	}
	
	
}

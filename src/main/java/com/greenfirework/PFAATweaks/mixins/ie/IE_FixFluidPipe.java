package com.greenfirework.PFAATweaks.mixins.ie;

import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At;

import blusunrize.immersiveengineering.common.blocks.BlockIEBase;
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalDevices2;
import blusunrize.immersiveengineering.common.blocks.metal.ItemBlockMetalDevices2;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityFluidPipe;

@Mixin(value=BlockMetalDevices2.class, remap=false)
public abstract class IE_FixFluidPipe extends BlockIEBase {
	
	protected IE_FixFluidPipe() {
		super("", null, 0, ItemBlockMetalDevices2.class, "");
	}

	@Redirect(method = "onNeighborChange(Lnet/minecraft/world/IBlockAccess;IIIIII)V", at = @At(value = "FIELD", target = "Lblusunrize/immersiveengineering/common/blocks/metal/TileEntityFluidPipe;sideConfig:[I", opcode = Opcodes.IASTORE))
	private void injected(TileEntityFluidPipe something, int idx, int x) {
	  // Do nothing
	}
	
}

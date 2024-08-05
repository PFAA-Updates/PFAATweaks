package com.greenfirework.PFAATweaks.mixins.ie;

import blusunrize.immersiveengineering.common.blocks.TileEntityImmersiveConnectable;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityConnectorLV;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import com.llamalad7.mixinextras.sugar.Local;

import org.spongepowered.asm.mixin.injection.At;


@Mixin(value = TileEntityConnectorLV.class, remap = false)
public abstract class IE_WireBurnFix extends TileEntityImmersiveConnectable {

    @ModifyArg(method="transferEnergy(IZI)I", at = @At(value="INVOKE", target="Lblusunrize/immersiveengineering/api/energy/IImmersiveConnectable;outputEnergy(IZI)I", ordinal = 1), index = 0, allow = 1, require = 1)
    private int limitConnectorTransfer(int arg, @Local(name="powerLeft") int powerLeft) {
    	return Math.min(arg,  powerLeft);
    }
}
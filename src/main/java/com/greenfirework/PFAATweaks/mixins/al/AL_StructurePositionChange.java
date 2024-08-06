package com.greenfirework.PFAATweaks.mixins.al;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import com.fiskmods.lightsabers.common.generator.structure.EnumStructure;


@Mixin(value = EnumStructure.class, remap = false)
public abstract class AL_StructurePositionChange  {

	// Modify the structure placement to be further from touchdown
	@ModifyConstant(method = "<clinit>", constant = {@Constant(intValue = 8), @Constant(intValue = 16)})
	public int constantModify(int oldVal) {
		return oldVal << 1;
	}
}

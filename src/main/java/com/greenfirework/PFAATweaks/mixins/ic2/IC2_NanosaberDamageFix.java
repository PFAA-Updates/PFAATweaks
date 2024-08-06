package com.greenfirework.PFAATweaks.mixins.ic2;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import ic2.core.init.InternalName;
import ic2.core.item.tool.ItemElectricTool;
import ic2.core.item.tool.ItemNanoSaber;


@Mixin(value = ItemNanoSaber.class, remap = false)
public abstract class IC2_NanosaberDamageFix extends ItemElectricTool {

	public IC2_NanosaberDamageFix() {
		super(InternalName.itemNanoSaber, 0);
	}

	@ModifyConstant(method = "getAttributeModifiers(Lnet/minecraft/item/ItemStack;)Lcom/google/common/collect/Multimap;", require = 1, constant = @Constant(intValue = 20))
	public int constantValue(int speed) {
		return 1000;
	}
	
	
}

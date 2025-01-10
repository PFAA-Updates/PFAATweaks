package com.greenfirework.PFAATweaks.mixins.ic2;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import ic2.core.init.InternalName;
import ic2.core.item.armor.ItemArmorElectric;
import ic2.core.item.armor.ItemArmorNanoSuit;


@Mixin(value = ItemArmorNanoSuit.class, remap = false)
public abstract class IC2_NanosuitEnergyFix extends ItemArmorElectric {

	public IC2_NanosuitEnergyFix() {
		super(InternalName.itemArmorNanoChestplate, InternalName.nano, 1, 1, 1, 1);
	}

	@ModifyConstant(method = "getEnergyPerDamage()I", require = 1, constant = @Constant(intValue = 5000))
	public int constantValue(int speed) {
		return 200;
	}
}

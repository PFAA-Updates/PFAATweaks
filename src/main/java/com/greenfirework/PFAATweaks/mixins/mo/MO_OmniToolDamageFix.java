package com.greenfirework.PFAATweaks.mixins.mo;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import matteroverdrive.items.weapon.EnergyWeapon;
import matteroverdrive.items.weapon.OmniTool;


@Mixin(value = OmniTool.class, remap = false)
public abstract class MO_OmniToolDamageFix extends EnergyWeapon {

	public MO_OmniToolDamageFix() {
		super(null, 0, 0, 0, 0);
	}

	@ModifyConstant(method = "getWeaponBaseDamage(Lnet/minecraft/item/ItemStack;)F", require = 1, constant = @Constant(floatValue = 7.0f))
	public float constantValue(float oldValue) {
		return 150F;
	}
}

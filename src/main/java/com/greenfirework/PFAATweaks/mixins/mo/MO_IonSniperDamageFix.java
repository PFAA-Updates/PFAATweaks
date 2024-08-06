package com.greenfirework.PFAATweaks.mixins.mo;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import matteroverdrive.items.weapon.EnergyWeapon;
import matteroverdrive.items.weapon.IonSniper;


@Mixin(value = IonSniper.class, remap = false)
public abstract class MO_IonSniperDamageFix extends EnergyWeapon {

	public MO_IonSniperDamageFix() {
		super(null, 0, 0, 0, 0);
	}

	@ModifyConstant(method = "getWeaponBaseDamage(Lnet/minecraft/item/ItemStack;)F", require = 1, constant = @Constant(floatValue = 21.0f))
	public float constantValue(float oldValue) {
		return 2000f;
	}
}

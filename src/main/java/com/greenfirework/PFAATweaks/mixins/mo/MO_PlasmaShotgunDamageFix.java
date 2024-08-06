package com.greenfirework.PFAATweaks.mixins.mo;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import matteroverdrive.items.weapon.EnergyWeapon;
import matteroverdrive.items.weapon.PlasmaShotgun;


@Mixin(value = PlasmaShotgun.class, remap = false)
public abstract class MO_PlasmaShotgunDamageFix extends EnergyWeapon {

	public MO_PlasmaShotgunDamageFix() {
		super(null, 0, 0, 0, 0);
	}

	@ModifyConstant(method = "getWeaponBaseDamage(Lnet/minecraft/item/ItemStack;)F", require = 1, constant = @Constant(floatValue = 16.0f))
	public float constantValue(float oldValue) {
		return 1200F;
	}
}

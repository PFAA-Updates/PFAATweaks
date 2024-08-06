package com.greenfirework.PFAATweaks.mixins.mo;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At;

import matteroverdrive.items.weapon.EnergyWeapon;
import matteroverdrive.items.weapon.Phaser;


@Mixin(value = Phaser.class, remap = false)
public abstract class MO_PhaserDamageFix extends EnergyWeapon {

	public MO_PhaserDamageFix() {
		super(null, 0, 0, 0, 0);
	}

	@ModifyArg(method="getWeaponBaseDamage(Lnet/minecraft/item/ItemStack;)F", at = @At("RETURN"), require = 1)
	public float damageMultiplier(float oldValue) {
		return oldValue * 50F;
	}
}

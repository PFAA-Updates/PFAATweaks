package com.greenfirework.PFAATweaks.mixins.mo;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

import matteroverdrive.entity.monster.EntityRougeAndroidMob;
import matteroverdrive.items.weapon.EnergyWeapon;
import matteroverdrive.items.weapon.PlasmaShotgun;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

// Those damned Rouge Angles of Satin...
@Mixin(value = EntityRougeAndroidMob.class, remap = false)
public abstract class MO_RogueAndroidMobBuffs extends EntityMob {

	public MO_RogueAndroidMobBuffs() {
		super(null);
	}

	@ModifyConstant(method = "init()V", require = 1, constant = @Constant(doubleValue = 128.0))
	public double legendaryHealth(double oldValue) {
		return 1024.0;
	}

	@ModifyConstant(method = "init()V", require = 1, constant = @Constant(intValue = 10))
	public int hpMultiplier(int oldValue) {
		return 128;
	}

	@ModifyConstant(method = "init()V", require = 1, constant = @Constant(intValue = 32))
	public int hpBase(int oldValue) {
		return 512;
	}
}

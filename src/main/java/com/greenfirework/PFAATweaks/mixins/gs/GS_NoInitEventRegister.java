package com.greenfirework.PFAATweaks.mixins.gs;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At;

import com.estebes.gravisuitereloaded.item.tool.ItemToolTheChopper;
import com.estebes.gravisuitereloaded.item.ItemElectricTool;

import cpw.mods.fml.common.eventhandler.EventBus;



@Mixin(ItemToolTheChopper.class)
public class GS_NoInitEventRegister extends ItemElectricTool {
	
	public GS_NoInitEventRegister() {
		super("", 0, 0.0, 0.0, false);
	}
	
	@Redirect(remap = false, method = "<init>()V", at = @At(value = "INVOKE", target = "Lcpw/mods/fml/common/eventhandler/EventBus;register(Ljava/lang/Object;)V"))
	public void register(EventBus dummy, Object o) {
		// Do nothing
	}
}

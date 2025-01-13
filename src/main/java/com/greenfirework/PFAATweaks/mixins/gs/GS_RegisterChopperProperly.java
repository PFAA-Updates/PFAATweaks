package com.greenfirework.PFAATweaks.mixins.gs;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import com.estebes.gravisuitereloaded.item.tool.ItemToolTheChopper;
import com.estebes.gravisuitereloaded.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;


@Mixin(value=ItemInit.class, remap = false)
public class GS_RegisterChopperProperly {
	
	@Shadow
	public static ItemToolTheChopper itemToolTheChopper;
	
	@Inject(method="", at=@At("RETURN"), remap=false)
	public void AlsoInitChopper() {

        MinecraftForge.EVENT_BUS.register(itemToolTheChopper);
	}
}

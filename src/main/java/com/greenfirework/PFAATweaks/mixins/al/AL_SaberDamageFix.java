package com.greenfirework.PFAATweaks.mixins.al;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;
import com.fiskmods.lightsabers.common.item.ItemLightsaberBase;
import net.minecraft.item.ItemSword;


@Mixin(value = ItemLightsaberBase.class, remap = false)
public abstract class AL_SaberDamageFix extends ItemSword {

	public AL_SaberDamageFix() {
		super(ToolMaterial.IRON);
	}

	@ModifyConstant(method = "getAttributeModifiers(Lnet/minecraft/item/ItemStack;)Lcom/google/common/collect/Multimap;", require = 1, constant = @Constant(doubleValue = 8.0))
	public double constantValue(double old) {
		return 1200.0;
	}
	
	
}

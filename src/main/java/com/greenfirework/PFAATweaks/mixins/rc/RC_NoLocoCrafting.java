package com.greenfirework.PFAATweaks.mixins.rc;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At;

import mods.railcraft.common.modules.ModuleLocomotives;
import mods.railcraft.common.plugins.forge.CraftingPlugin;
import net.minecraft.item.ItemStack;

@Mixin(value = ModuleLocomotives.class, remap = false)
public class RC_NoLocoCrafting {
	@Redirect(method = "initFirst()V", at = @At(value = "INVOKE", target = "Lmods/railcraft/common/plugins/forge/CraftingPlugin;addShapedRecipe(Lnet/minecraft/item/ItemStack;[Ljava/lang/Object;)V"))
	public void NoRecipe(CraftingPlugin instance, ItemStack result, Object... recipeArray) {
		// Do nothing - disable the shaped locomotive recipes so we can add them via CraftTweaker
	}
}

package com.greenfirework.PFAATweaks.mixins.rc;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import mods.railcraft.common.gui.slots.SlotColorFilter;
import mods.railcraft.common.gui.slots.SlotRailcraft;
import mods.railcraft.common.util.crafting.DyeHelper;
import mods.railcraft.common.util.inventory.InvTools;
import mods.railcraft.common.util.misc.EnumColor;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

@Mixin(SlotColorFilter.class)
public abstract class RC_SlotColorFilterFix extends SlotRailcraft {
	public RC_SlotColorFilterFix() {
		super(null, 0, 0, 0);
	}

	@Overwrite
	public boolean isItemValid(ItemStack itemStack) {
        if (itemStack == null)
        	return false;
        
        if (InvTools.isStackEqualToBlock(itemStack, Blocks.wool))
        	return true;
        
        return getDye(itemStack) > -1;
	}
	
    private int getDye(ItemStack stack) {
        for (EnumColor color : EnumColor.VALUES) {
            if (InvTools.isItemEqual(stack, DyeHelper.getDyes().get(color)))
            	return color.ordinal();
        }
        return -1;
    }
}

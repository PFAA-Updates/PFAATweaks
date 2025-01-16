package com.greenfirework.PFAATweaks.mixins.grs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import gravisuite.ItemAdvDDrill;


@Mixin(value=ItemAdvDDrill.class, remap = false)
public class GRS_DrillFix {

    @Overwrite
    public boolean canHarvestBlock(Block block, ItemStack stack) {
        return (
            !(block.getMaterial() == Material.wood) &&
            !(block.getMaterial() == Material.cloth) &&
            !(block.getMaterial() == Material.cactus) &&
            !(block.getMaterial() == Material.cake) &&
            !(block.getMaterial() == Material.leaves) &&
            !(block.getMaterial() == Material.sponge) &&
            !(block.getMaterial() == Material.vine) &&
            !(block.getMaterial() == Material.gourd)&&
            !(block.getMaterial() == Material.web)


        );
    }

}


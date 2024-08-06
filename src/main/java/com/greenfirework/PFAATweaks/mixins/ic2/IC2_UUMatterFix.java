package com.greenfirework.PFAATweaks.mixins.ic2;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import ic2.core.uu.UuIndex;


@Mixin(value = UuIndex.class, remap = false)
public abstract class IC2_UUMatterFix {
	/**
	 * Overwrite to disable function
	 * @param random
	 * @param chunkX
	 * @param chunkZ
	 * @param world
	 * @param chunkGenerator
	 * @param chunkProvider
	 * @reason We do uu-matter recipes separately
	 * @author Sukasa
	 */
	@Overwrite
	public void init() {
	}
	
	
}

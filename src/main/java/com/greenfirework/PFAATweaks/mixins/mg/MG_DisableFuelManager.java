package com.greenfirework.PFAATweaks.mixins.mg;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import com.cout970.magneticraft.ManagerFluids;


@Mixin(value = ManagerFluids.class, remap = false)
public abstract class MG_DisableFuelManager  {

	/**
	 * Disable Function
	 * @param random
	 * @param chunkX
	 * @param chunkZ
	 * @param world
	 * @param chunkGenerator
	 * @param chunkProvider
	 * @reason Disable this function
	 * @author Sukasa
	 */
	@Overwrite
	public void registerFuels() {
		
	}
	/**
	 * Disable Function
	 * @param random
	 * @param chunkX
	 * @param chunkZ
	 * @param world
	 * @param chunkGenerator
	 * @param chunkProvider
	 * @reason Disable this function
	 * @author Sukasa
	 */
	@Overwrite
	public void registerBCFuels() {
		
	}
	/**
	 * Disable Function
	 * @param random
	 * @param chunkX
	 * @param chunkZ
	 * @param world
	 * @param chunkGenerator
	 * @param chunkProvider
	 * @reason Disable this function
	 * @author Sukasa
	 */
	@Overwrite
	public void registerIEFuels() {
		
	}
	/**
	 * Disable Function
	 * @param random
	 * @param chunkX
	 * @param chunkZ
	 * @param world
	 * @param chunkGenerator
	 * @param chunkProvider
	 * @reason Disable this function
	 * @author Sukasa
	 */
	@Overwrite
	public void registerRCFuels() {
		
	}
	
	
}

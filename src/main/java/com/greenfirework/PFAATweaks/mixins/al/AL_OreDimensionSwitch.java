package com.greenfirework.PFAATweaks.mixins.al;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import com.fiskmods.lightsabers.common.generator.WorldGeneratorOres;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;


@Mixin(value = WorldGeneratorOres.class, remap = false)
public abstract class AL_OreDimensionSwitch  {

	@Shadow
	public void generateOverworld(final World world, final Random random, final int chunkX, final int chunkZ) {}

	/**
	 * Overwrite to change dimension
	 * @param random
	 * @param chunkX
	 * @param chunkZ
	 * @param world
	 * @param chunkGenerator
	 * @param chunkProvider
	 * @reason Well, because it's the wrong dimensions
	 * @author Sukasa
	 */
	@Overwrite
	public void generate(final Random random, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
		
        switch (world.provider.dimensionId) {
        case 18: 
            this.generateOverworld(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
	}
	
	
}

package com.greenfirework.PFAATweaks.mixins.ic2;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import ic2.core.block.TileEntityInventory;
import ic2.core.block.machine.tileentity.TileEntitySteamGenerator;
import ic2.core.init.BlocksItems;
import ic2.core.init.InternalName;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

@Mixin(value = TileEntitySteamGenerator.class, remap = false)
public abstract class IC2_SteamGeneratorFix extends TileEntityInventory {

	//private static final float huPerShellUnit = 5.0E4f; 
	
	@Shadow
	private int calcification;
	
	@Shadow
	private float systemheat; // System temperature
	
	@Shadow
	private int heatinput;
	
	@Shadow
	private int pressurevalve;
	
	@Shadow
	private int inputmb;
	
	@Shadow
	private int outputmb;
	
	@Shadow
	abstract void heatup(int heatinput);
	
	@Shadow
	abstract void cooldown(float cool);
		
	@Shadow
	abstract boolean heatupmax();
	
	@Shadow public FluidTank WaterTank;
	
	@Redirect(method = "work()Z", at = @At(value = "INVOKE", target = "Lic2/core/block/machine/tileentity/TileEntitySteamGenerator;getOutputfluid()Lnet/minecraftforge/fluids/FluidStack;"))
	public FluidStack getOutputfluid() { 
		heatupmax();
		
		// If we aren't boiling, then return water
		if (systemheat < 100f)
			return WaterTank.drain(inputmb,  true);
		
		int hu_need = Math.round(pressurevalve / 225.0f * 100.0f) + 100; // Why does setting the pressure only really modify how much HU we try to put into the liquid?	
		int hu_max_cons = hu_need * inputmb; // Get maximum HU to be consumed
		
        FluidStack output;
        if (systemheat >= 374.0f && pressurevalve >= 220) {
        	output = new FluidStack(BlocksItems.getFluid(InternalName.fluidSuperheatedSteam), inputmb * 100);
        }
        else { // We've already checked that we're above 100 deg earlier so we don't need to repeat the check
        	output = new FluidStack(BlocksItems.getFluid(InternalName.fluidSteam), inputmb * 100);
        }
        heatup(-hu_max_cons); // Remove heat that was used to convert the water to steam
        
		// If we aren't boiling distilled water, increase calcification
		if (!WaterTank.getFluid().getFluid().equals(BlocksItems.getFluid(InternalName.fluidDistilledWater)))
			calcification++;	
		
		// "Limiter" to dump a little extra heat into whatever we're heating, to help players balance input and output HU
		cooldown(systemheat * 0.0003f);
		
        return output;
	}
}

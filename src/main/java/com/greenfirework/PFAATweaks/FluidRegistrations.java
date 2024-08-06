package com.greenfirework.PFAATweaks;

import com.greenfirework.PFAATweaks.TweaksConfig.FluidValue;
import com.greenfirework.PFAATweaks.TweaksConfig.HXFluid;

import blusunrize.immersiveengineering.api.energy.DieselHandler;
import cpw.mods.fml.common.Optional;
import ic2.api.recipe.Recipes;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import mods.railcraft.api.fuel.FuelManager;

/**
 * Class that updates fluid registrations
 */
public class FluidRegistrations {

	public static void modifyTemperatures() {
		for (FluidValue value : TweaksConfig.temperatures) {
			Fluid f = FluidRegistry.getFluid(value.fluidName);
			if (f == null) {
				PFAATweaks.LOG.warn("Unable to find fluid {}", value.fluidName);
				continue;
			}
			f.setTemperature(value.fluidValue);
		}
		
	}
	
	@Optional.Method(modid="ImmersiveEngineering")
	public static void registerDieselFuels() {
		for (FluidValue value : TweaksConfig.dieselValues) {
			Fluid f = FluidRegistry.getFluid(value.fluidName);
			if (f == null) {
				PFAATweaks.LOG.warn("Unable to find fluid {}", value.fluidName);
				continue;
			}
			DieselHandler.registerFuel(f, value.fluidValue);
		}
	}
	
	@Optional.Method(modid="Railcraft")
	public static void registerBoilerFuels() {
		for (FluidValue value : TweaksConfig.dieselValues) {
			Fluid f = FluidRegistry.getFluid(value.fluidName);
			if (f == null) {
				PFAATweaks.LOG.warn("Unable to find fluid {}", value.fluidName);
				continue;
			}
			FuelManager.addBoilerFuel(f, value.fluidValue);
		}
	}
	
	@Optional.Method(modid="IC2")
	public static void registerICHeatExchange() {
		for (HXFluid value : TweaksConfig.heatExchange) {
			 Recipes.liquidCooldownManager.addFluid(value.fluidNameIn, value.fluidNameOut, value.heatUnits);
		}
	}
}

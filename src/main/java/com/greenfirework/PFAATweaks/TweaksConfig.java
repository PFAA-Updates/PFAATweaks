package com.greenfirework.PFAATweaks;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class TweaksConfig {

	public static class FluidValue {
		public String fluidName;
		public int fluidValue;
	}
	
	public static class HXFluid {
		public String fluidNameIn;
		public String fluidNameOut;
		public int heatUnits;
	}

	public static FluidValue[] temperatures;
	public static FluidValue[] boilerValues;
	public static FluidValue[] dieselValues;
	public static HXFluid[]    heatExchange;
	

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        String[] valuesRaw = configuration.getStringList("fluidTemperatures", "Chemistry", new String[] {}, "Fluid temperatures, in the format fluidname:temp, eg hotsyngas:1700");
        
        temperatures = new FluidValue[valuesRaw.length];
        
        for(int idx = 0; idx < valuesRaw.length; idx++) {
        	String[] parts = valuesRaw[idx].split(":");
        	temperatures[idx] = new FluidValue();
        	temperatures[idx].fluidName = parts[0];
        	temperatures[idx].fluidValue = Integer.parseInt(parts[1]);
        }
        
        valuesRaw = configuration.getStringList("boilerFuels", "Chemistry", new String[] {}, "Thermal values per bucket of various fuels, in RC Boiler.  Format fluidName:thermalValue");
        
        boilerValues = new FluidValue[valuesRaw.length];
        
        for(int idx = 0; idx < valuesRaw.length; idx++) {
        	String[] parts = valuesRaw[idx].split(":");
        	boilerValues[idx] = new FluidValue();
        	boilerValues[idx].fluidName = parts[0];
        	boilerValues[idx].fluidValue = Integer.parseInt(parts[1]);
        }
        
        valuesRaw = configuration.getStringList("dieselFuels", "Chemistry", new String[] {}, "Thermal values per unit of various fuels, in IE Generator.  Format fluidName:fuelValue");
        
        dieselValues = new FluidValue[valuesRaw.length];
        
        for(int idx = 0; idx < valuesRaw.length; idx++) {
        	String[] parts = valuesRaw[idx].split(":");
        	dieselValues[idx] = new FluidValue();
        	dieselValues[idx].fluidName = parts[0];
        	dieselValues[idx].fluidValue = Integer.parseInt(parts[1]);
        }
        
        valuesRaw = configuration.getStringList("dieselFuels", "Chemistry", new String[] {}, "Thermal values per unit of various fuels, in IE Generator.  Format fluidName:fuelValue");
        
        heatExchange = new HXFluid[valuesRaw.length];
        
        for(int idx = 0; idx < valuesRaw.length; idx++) {
        	String[] parts = valuesRaw[idx].split(":");
        	heatExchange[idx] = new HXFluid();
        	heatExchange[idx].fluidNameIn = parts[0];
        	heatExchange[idx].fluidNameOut = parts[1];
        	heatExchange[idx].heatUnits = Integer.parseInt(parts[2]);
        }
        
        
        
        
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
    
    
}

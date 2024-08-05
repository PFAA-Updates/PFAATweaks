package com.greenfirework.PFAATweaks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.handshake.FMLHandshakeMessage.ModList;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = PFAATweaks.MODID, version = Tags.VERSION, name = "PFAA Tweaks", acceptedMinecraftVersions = "[1.7.10]")
public class PFAATweaks {

    public static final String MODID = Tags.MODID;
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "com.greenfirework.PFAATweaks.ClientProxy", serverSide = "com.greenfirework.PFAATweaks.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);

        // Register all of the PFAA fluid tweaks
        if (Loader.isModLoaded("Railcraft"))
        	FluidRegistrations.registerBoilerFuels();
        
        if (Loader.isModLoaded("ImmersiveEngineering"))
        	FluidRegistrations.registerDieselFuels();
        
        if (Loader.isModLoaded("IC2"))
        	FluidRegistrations.registerICHeatExchange();
    }
}

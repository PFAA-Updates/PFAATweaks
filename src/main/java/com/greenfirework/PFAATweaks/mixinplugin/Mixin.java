package com.greenfirework.PFAATweaks.mixinplugin;

import cpw.mods.fml.relauncher.FMLLaunchHandler;

import java.util.Arrays;
import java.util.List;

import static com.greenfirework.PFAATweaks.mixinplugin.Target.*;

public enum Mixin {

	// Immersive Engineering tweaks
    IE_WIRE_BURN_FIX("ie.IE_WireBurnFix", IMMERSIVE_ENG),
    IE_SILO_TANK_SIZE("ie.IE_SheetmetalTankCapacityBuff", IMMERSIVE_ENG),
    IE_WINDMILL_NERF("ie.IE_WindmillBalancing", IMMERSIVE_ENG),
    IE_WATERMILL_NERF("ie.IE_WatermillBalancing", IMMERSIVE_ENG),
    
    // IndustrialCraft 2 tweaks
    IC2_MINER_SPEED_FIX("ic2.IC2_MinerSpeedFix", INDUSTRIALCRAFT),
    IC2_NANOSABER_FIX("ic2.IC2_NanosaberDamageFix", INDUSTRIALCRAFT),
    IC2_NANOSUIT_FIX("ic2.IC2_NanosuitEnergyFix", INDUSTRIALCRAFT),
    IC2_UUTWEAK("ic2.IC2_UUMatterFix", INDUSTRIALCRAFT),
    IC2_HXFIX("ic2.IC2_LiquidHXFluidFix", INDUSTRIALCRAFT),
    IC2_STEAMGENFIX("ic2.IC2_SteanGeneratorFix", INDUSTRIALCRAFT),
    
    // Advanced Lightsabers
    AL_ORE_GEN_FIX("al.AL_OreDimensionSwitch", LIGHTSABERS),
    AL_STRUCTURE_GEN_FIX("al.AL_StructureDimensionChanges", LIGHTSABERS),
    AL_SABER_DAMAGE_FIX("al.AL_SaberDamageFix", LIGHTSABERS),
    AL_STRUCTURE_SPREAD_FIX("al.AL_StructurePositionChange", LIGHTSABERS),
    
    // Matter Overdrive
    MO_PHASER_DAMAGE_FIX("mo.MO_PhaserDamageFix", MATTER_OVERDRIVE),
    MO_ION_SNIPER_DAMAGE_FIX("mo.MO_IonSniperDamageFix", MATTER_OVERDRIVE),
    MO_PLASMA_SHOTGUN_DAMAGE_FIX("mo.MO_PlasmaShotgunDamageFix", MATTER_OVERDRIVE),
    MO_OMNI_TOOL_DAMAGE_FIX("mo.MO_OmniToolDamageFix", MATTER_OVERDRIVE),
    MO_ANDROID_HP_FIX("mo.MO_RogueAndroidMobBuffs", MATTER_OVERDRIVE),
    
    // MagnetiCraft
    MG_FUEL_DISABLE("mg.MG_DisableFuelManager", MAGNETICRAFT),    
    MG_CRUSHER_TWEAK("mg.MG_TweakCrusherPower", MAGNETICRAFT),    
    MG_GRINDER_TWEAK("mg.MG_TweakGrinderPower", MAGNETICRAFT),    
    MG_ENERGY_VALUES("mg.MG_EnergyConverterPatches", MAGNETICRAFT),    
    
    // Techguns
    TG_DAMAGE_SCALING("tg.TG_DamageRescale", TECHGUNS),
    
    FZ_STEAM_REGISTRY("fz.FZ_SteamChangeRegistry", FACTORIZATION),
    FZ_STEAM_SHAFT("fz.FZ_SteamChangeShaft", FACTORIZATION),
    FZ_STEAM_BOILERT("fz.FZ_SteamChangeSolarBoiler", FACTORIZATION),
    FZ_STEAM_TURBINE("fz.FZ_SteamChangeTurbine", FACTORIZATION),
    
    // Railcraft
    RC_ACCESSOR("rc.RC_TurbineInventoryAccessor", RAILCRAFT),
    RC_TURBINE_INVENTORY("rc.RC_TurbineInventoryAccess", RAILCRAFT),
    RC_TRAIN_DENERF("rc.RC_TrainDeNerf", RAILCRAFT),
    RC_CART_DENERF("rc.RC_EnergyCartDeNerf", RAILCRAFT);

	


    public final String mixinClass;
    public final List<Target> targetedMods;
    private final Side side;

    Mixin(String mixinClass, Side side, Target... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = side;
    }

    Mixin(String mixinClass, Target... targetedMods) {
        this.mixinClass = mixinClass;
        this.targetedMods = Arrays.asList(targetedMods);
        this.side = Side.BOTH;
    }

    public boolean shouldLoad(List<Target> loadedMods) {
        return (side == Side.BOTH
                || side == Side.SERVER && FMLLaunchHandler.side().isServer()
                || side == Side.CLIENT && FMLLaunchHandler.side().isClient())
                && loadedMods.containsAll(targetedMods);
    }
}

enum Side {
    BOTH,
    CLIENT,
    SERVER;
}
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
    
    // Advanced Lightsabers
    AL_ORE_GEN_FIX("al.AL_OreDimensionSwitch", LIGHTSABERS),
    AL_STRUCTURE_GEN_FIX("al.AL_StructureDimensionSwitch", LIGHTSABERS),
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
    TG_DAMAGE_SCALING("tg.TG_DamageRescale", TECHGUNS);

	


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
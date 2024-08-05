package com.greenfirework.PFAATweaks.mixinplugin;

import cpw.mods.fml.relauncher.FMLLaunchHandler;

import java.util.Arrays;
import java.util.List;

import static com.greenfirework.PFAATweaks.mixinplugin.Target.*;

public enum Mixin {

    //
    // IMPORTANT: Do not make any references to any mod from this file. This file is loaded quite early on and if
    // you refer to other mods you load them as well. The consequence is: You can't inject any previously loaded classes!
    // Exception: Tags.java, as long as it is used for Strings only!
    //

    // Replace with your own mixins:
    //ItemEditableBookMixin("minecraft.ItemEditableBookMixin", Side.BOTH, VANILLA),
    // You may also require multiple mods to be loaded if your mixin requires both

    IE_WIRE_BURN_FIX("ie.IE_WireBurnFix", IMMERSIVE_ENG),
    IE_SILO_TANK_SIZE("ie.IE_SheetmetalTankCapacityBuff", IMMERSIVE_ENG),
    IE_WINDMILL_BALANCE("ie.IE_WindmillBalancing", IMMERSIVE_ENG),
    IE_WATERMILL_BALANCE("ie.IE_WatermillBalancing", IMMERSIVE_ENG);



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
package com.cjm721.simpletractor;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = SimpleTractor.MODID, version = SimpleTractor.VERSION,
    acceptedMinecraftVersions = "1.10.2",
    useMetadata = true)
public class SimpleTractor {
    @Mod.Instance(SimpleTractor.MODID)
    public static SimpleTractor instance;

    public static final String VERSION = "0.0.1";
    public static final String MODID = "simpletractor";

    public static ItemTractor tractor;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tractor = new ItemTractor();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        EntityRegistry.registerModEntity(EntityTractor.class, "MountableBlock", 0, SimpleTractor.instance, 80, 1, false);

        tractor.registerRecipe();
        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            tractor.registerModel();
        }
    }
}

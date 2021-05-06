package com.ataraxy.breadpack;

import com.ataraxy.breadpack.proxy.CommonProxy;
import com.ataraxy.breadpack.tabs.BreadpackTab;
import com.ataraxy.breadpack.util.Reference;
import com.ataraxy.breadpack.util.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class Breadpack 
{
@Instance
public static Breadpack instance;

@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
public static CommonProxy proxy;

public static final CreativeTabs BREADPACKTAB = new BreadpackTab("Breadpack");

@EventHandler
public void preInit(FMLPreInitializationEvent event)
{
	RegistryHandler.preInitRegistries();
}

@EventHandler
public void Init(FMLInitializationEvent event)
{
	RegistryHandler.initRegistries();
}

@EventHandler
public void postInit(FMLPostInitializationEvent event)
{
	RegistryHandler.postInitRegistries();
}

@EventHandler
public void serverInit(FMLServerStartingEvent event)
{
	RegistryHandler.serverRegistries();
}

}

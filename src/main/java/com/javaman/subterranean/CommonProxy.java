package com.javaman.subterranean;

import com.javaman.subteranean.items.ModItems;
import com.javaman.subterranean.WorldGen.ModWorldGenerator;
import com.javaman.subterranean.WorldGen.SubWorldGen;
import com.javaman.subterranean.biomes.BiomeRegistry;
import com.javaman.subterranean.blocks.ModBlocks;
import com.javaman.subterranean.dimension.DimensionRegister;
import com.javaman.subterranean.entity.ModEntitys;
import com.javaman.subterranean.loottable.LootRegister;
import com.javaman.subtersnean.register.Register;

import net.minecraftforge.client.model.obj.OBJLoader;

//import com.javaman.subteranean.items.ModItems;
//import com.javaman.subteranean.projectiles.MakeProjectile;
//import com.javaman.subterranean.biomes.BiomeRegistry;
//import com.javaman.subterranean.blocks.ModBlocks;
//import com.javaman.subterranean.crafting.ModCrafting;
//import com.javaman.subterranean.dimension.DimensionRegister;
//import com.javaman.subterranean.entity.ModEntitys;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		GameRegistry.registerWorldGenerator(new ModWorldGenerator(), 0);
		ModBlocks.addItem();

		ModItems.addItem();
		//GameRegistry.registerWorldGenerator(new SubWorldGen(), 1);
		DimensionRegister.mainRegistry();
		BiomeRegistry.initializeBiome();
		//ModItems.createItems();
		//ModBlocks.createBlocks();
		ModEntitys.mainRegistry();
		LootRegister.mainRegister();
		//MakeProjectile.registerEntity();
		MinecraftForge.EVENT_BUS.register(new Register());
		
		
	}
	@EventHandler
	public void init(FMLInitializationEvent e) {
		//ModCrafting.initCrafting();
		//BiomeRegistry.mainRegsitry();
		//BiomeRegistry.mainRegsitry();
		//DimensionRegister.mainRegistry();
		
		MinecraftForge.EVENT_BUS.register(new SubEventHandler());
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}
}

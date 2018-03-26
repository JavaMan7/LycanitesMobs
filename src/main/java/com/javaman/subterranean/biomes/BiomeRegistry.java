package com.javaman.subterranean.biomes;


import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeRegistry {
	public static final HashMap<Class<? extends Biome>,Biome> SUBTERRANEAN_BIOMES = new HashMap<Class<? extends Biome>,Biome>();
	

	public static Biome BiomeGenFireSub = new BiomeGenFireSub(new Biome.BiomeProperties("BiomeGenFireSub").setBaseHeight(0.0F).setHeightVariation(0.2F).setTemperature(0.8F));
	public static void initializeBiome(){
		
		registerBiome(BiomeGenFireSub.class,BiomeGenFireSub);
		
	}
	
	public static void registerBiome(Class<? extends Biome> biomeClass,Biome biome){
		SUBTERRANEAN_BIOMES.put(biomeClass, biome);
		BiomeManager.addSpawnBiome(biome);
		
		
	}

}

package com.javaman.subtersnean.register;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.javaman.subteranean.items.ModItems;
import com.javaman.subteranean.projectiles.EntityFireShot;
import com.javaman.subterranean.SubterraneanCreaturesMod;
import com.javaman.subterranean.biomes.BiomeRegistry;
import com.javaman.subterranean.blocks.ModBlocks;
import com.javaman.subterranean.entity.EntityFlailSnail;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Register {
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		
		
		  Set set = ModBlocks.SUBTERRANEAN_BLOCKS.entrySet();
	      Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
	         Map.Entry  item = (Map.Entry)iterator.next();
	         Block block = (Block) item.getValue();
	         
	         event.getRegistry().register(block);
	         ModItems.registerTtem(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	      //   int randomId = 5000000;
	 		//EntityRegistry.registerModEntity(new ResourceLocation("minecraft", "glowstone_dust"), EntityFireShot.class, "Throwing Rock", randomId, SubterraneanCreaturesMod.MODID, 64, 10, true);

		
	}
		
  }
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		
		
		  Set set = ModItems.SUBTERRANEAN_ITEMS.entrySet();
	      Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
	         Map.Entry  item = (Map.Entry)iterator.next();
	         
	       
	         event.getRegistry().register( (Item) item.getValue() );
	      //   int randomId = 5000000;
	 		//EntityRegistry.registerModEntity(new ResourceLocation("minecraft", "glowstone_dust"), EntityFireShot.class, "Throwing Rock", randomId, SubterraneanCreaturesMod.MODID, 64, 10, true);

		
	}
		
	      
		
	   
	}
	@SubscribeEvent
	public void registerEntityEntry(RegistryEvent.Register<EntityEntry> event) {
		
		
	 		EntityRegistry.registerModEntity(new ResourceLocation("minecraft", "glowstone_dust"), EntityFireShot.class, "Throwing Rock", 423412, SubterraneanCreaturesMod.MODID, 64, 10, true);

		
	
	}
	@SubscribeEvent
    public void registerBiome(RegistryEvent.Register<Biome> event) {
		
		

		  Set set = BiomeRegistry.SUBTERRANEAN_BIOMES.entrySet();
	      Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
	         Map.Entry  item = (Map.Entry)iterator.next();
	         
	       
	         event.getRegistry().register((Biome) item.getValue());
	         BiomeManager.addBiome(BiomeType.WARM,new BiomeEntry((Biome) item.getValue(),5));
		
	}
		//EntityRegistry.addSpawn(EntityFlailSnail.class, 100, 1, 1, EnumCreatureType.MONSTER, BiomeRegistry.BiomeGenFireSub);
		
    }
	
	
}

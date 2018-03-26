package com.javaman.subterranean.entity;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.javaman.subterranean.SubterraneanCreaturesMod;
import com.javaman.subterranean.biomes.BiomeRegistry;
import com.javaman.subterranean.client.renderer.entity.EntityRenderRegister;
import com.javaman.subterranean.client.renderer.entity.RenderSubterraneanCreatures;
import com.javaman.subterranean.models.ModelFailSnail;
import com.javaman.subterranean.models.ModelFireToad;
import com.javaman.subterranean.models.ModelWrath;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class ModEntitys {
	public static final HashMap<String,Object[]> SUBTERRANEAN_MOBS = new HashMap<String,Object[]>();
	static int c = 412879;
	
	
	public static void mainRegistry(){
		
		
		
		registerEntity(EntityFlailSnail.class, "flail_snail", 0x4b0675, 0xf4a511,new ModelFailSnail());
		registerEntity(EntityWrath.class, "wrath", 0x999999, 0xFF0000,new ModelWrath());
		registerEntity(EntityFireToad.class, "fire_toad", 0xba2c26, 0x3e0f3f,new ModelFireToad());
		
		createEntity(SUBTERRANEAN_MOBS);
		EntityRegistry.addSpawn(EntityWrath.class, 50, 1, 3, EnumCreatureType.MONSTER, Biome.getBiomeForId(4));
		EntityRegistry.addSpawn(EntityFlailSnail.class, 50, 1, 1, EnumCreatureType.MONSTER, BiomeRegistry.BiomeGenFireSub);
		EntityRegistry.addSpawn(EntityFireToad.class, 10, 1, 1, EnumCreatureType.MONSTER, BiomeRegistry.BiomeGenFireSub);
	}
	
	public static void registerEntity(Class<? extends Entity> e,String entityName,int solidColor, int spotColor,ModelBase model){
		 Object[] object = new Object[6];
		 object[0] = e;
		 object[1] = model;
		 object[2] = new ResourceLocation(SubterraneanCreaturesMod.MODID,entityName);
		 object[3] = solidColor;
	     object[4] = spotColor;
	     object[5] = entityName;
		SUBTERRANEAN_MOBS.put(entityName, object);
   
		
    
		
		
	}
	
	
	
	public static void createEntity(HashMap<String,Object[]> s){
		c= c+1;
		
		 Set set = ModEntitys.SUBTERRANEAN_MOBS.entrySet();
	      Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
	         Map.Entry  item = (Map.Entry)iterator.next();
	         Object[] object = (Object[]) item.getValue();
	       
	        System.out.println(SubterraneanCreaturesMod.MODID+(String)object[5]);
	         ResourceLocation resourceLocation= new ResourceLocation(SubterraneanCreaturesMod.MODID,(String)object[5]);
	 		EntityRegistry.registerModEntity(resourceLocation, (Class<? extends Entity>)object[0],(String)item.getKey(),c, SubterraneanCreaturesMod.instance , 64, 1, true,(int)object[3], (int)object[4]);
	 		
	 		c++;
	 		

		
	}
		
		
		
		
		
		
		
		
	}
	
private static void createEgg( String entityName, int solidColor, int spotColor){
	EntityList.ENTITY_EGGS.put(new ResourceLocation(SubterraneanCreaturesMod.MODID,entityName), new EntityEggInfo(new ResourceLocation(SubterraneanCreaturesMod.MODID,entityName), solidColor, spotColor));
		
	}

}
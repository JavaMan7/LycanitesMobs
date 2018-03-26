package com.javaman.subterranean.dimension;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DimensionRegister 
{
	
	public static void mainRegistry()
	{
		registerDimension();
		
		
		
	}
	
	public static final int  dimensionId = 8;
	public static DimensionType dimensionType = DimensionType.register(SubterraneanCreaturesMod.MODID, "_test", dimensionId, WorldProviderSub.class, false);
	public static void registerDimension()
	{
		
		//DimensionManager.registerProviderType(dimensionId, WorldProviderSub.class,false);
		//DimensionManager.registerDimension(dimensionId, dimensionId);
		//DimensionManager.unregisterDimension(0);
		DimensionManager.registerDimension(dimensionId,dimensionType);
		//GameRegistry.registerWorldGenerator((IWorldGenerator) new ModWorldGen(), 1000);
		//DimensionManager.registerDimension(-1,DimensionType.THE_END);
		
		
	}
	

}

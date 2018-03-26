package com.javaman.subterranean.blocks;

import java.util.HashMap;

import com.javaman.subteranean.items.EssenceOfLifeDrain;
import com.javaman.subteranean.items.FireStaff;
import com.javaman.subteranean.items.TransDimensionalOrb;


import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public class SUBTERRANEAN_BLOCKS {
		
	}
public static final HashMap<String,Block> SUBTERRANEAN_BLOCKS = new HashMap<String,Block>();
	
public static void registerBlock(Block block){
	SUBTERRANEAN_BLOCKS.put(block.getUnlocalizedName(), block);
	
	
	
	
	
	
}

public static Block lapisCobblestone= new LapisCobblestone();
public static Block GLOWSHOOM= new GlowShroom();
public static Block GLOWSHOOM_BLOCK = new GlowShroomBlock(Material.SPONGE,MapColor.RED,GLOWSHOOM);
public static void addItem()
{
	
	
	registerBlock(lapisCobblestone);
	registerBlock(GLOWSHOOM);
	registerBlock(GLOWSHOOM_BLOCK);
	
}
}

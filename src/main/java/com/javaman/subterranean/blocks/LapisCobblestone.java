package com.javaman.subterranean.blocks;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class LapisCobblestone extends Block {

	public LapisCobblestone() {
		super(Material.ROCK);
		this.setUnlocalizedName("simie_cobblestone");
		this.setRegistryName(SubterraneanCreaturesMod.MODID+":"+"simie_cobblestone");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
	}
	
	
	

}

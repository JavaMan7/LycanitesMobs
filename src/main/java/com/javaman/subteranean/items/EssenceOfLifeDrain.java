package com.javaman.subteranean.items;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EssenceOfLifeDrain extends Item{
	
	public EssenceOfLifeDrain()
	{

		// TODO Auto-generated constructor stub
	
		this.setUnlocalizedName("essence_of_life_drain");
		this.setRegistryName(SubterraneanCreaturesMod.MODID+":"+"essence_of_life_drain");
		
		 
		 this.setMaxStackSize(64);
		 
		 this.setCreativeTab(CreativeTabs.MISC);
		
		
		
	}
	
	
	

}

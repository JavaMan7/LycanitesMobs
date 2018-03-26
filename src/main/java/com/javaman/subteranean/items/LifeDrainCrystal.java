package com.javaman.subteranean.items;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LifeDrainCrystal extends Item{
	
	
	public  LifeDrainCrystal()
	{

		// TODO Auto-generated constructor stub
	
		this.setUnlocalizedName("life_drain_crystal");
		this.setRegistryName(SubterraneanCreaturesMod.MODID+":"+"life_drain_crystal");
		 
		 this.setMaxStackSize(64);
		 
		 this.setCreativeTab(CreativeTabs.MISC);
		
		
		
	}

}

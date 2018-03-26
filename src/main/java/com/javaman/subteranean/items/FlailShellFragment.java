package com.javaman.subteranean.items;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FlailShellFragment extends Item{
	public  FlailShellFragment()
	{

		// TODO Auto-generated constructor stub
	
		this.setUnlocalizedName("flail_shell_fragment");
		this.setRegistryName(SubterraneanCreaturesMod.MODID,"flail_shell_fragment");
		
		 
		 this.setMaxStackSize(64);
		 
		 this.setCreativeTab(CreativeTabs.MISC);
		
		
		
	}
}

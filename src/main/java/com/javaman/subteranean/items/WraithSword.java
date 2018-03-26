package com.javaman.subteranean.items;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class WraithSword extends ItemSword{
	static ToolMaterial toolMaterial   = ToolMaterial.DIAMOND;
	public WraithSword() {
		super(toolMaterial);
		
		this.setUnlocalizedName("wraith_sword");
		this.setRegistryName(SubterraneanCreaturesMod.MODID+":"+"wraith_sword");
	
		 
		 //this.setMaxStackSize(64);
		 
		 this.setCreativeTab(CreativeTabs.COMBAT);
	}

	
	

}

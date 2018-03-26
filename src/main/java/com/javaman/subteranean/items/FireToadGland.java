package com.javaman.subteranean.items;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class FireToadGland extends ItemFood {
	private static int hunger = 10;
	private static float sat = 10f;
	private static boolean isWolffood = true;
public FireToadGland() {
	
		super(hunger, sat, isWolffood);
		
		this.setUnlocalizedName("fire_toad_gland");
		this.setRegistryName(SubterraneanCreaturesMod.MODID+":"+"fire_toad_gland");
		 this.setMaxDamage(384);
		 //
		 this.setMaxStackSize(64);
		 
		 this.setCreativeTab(CreativeTabs.MISC);
		 
	}



	

}

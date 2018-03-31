package com.javaman.subterranean.blocks;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Slime extends BlockFluidClassic{
	public static MaterialLiquid mat= new MaterialLiquid(MapColor.GREEN);
	
	public static Fluid fluid = new Fluid("slime", new ResourceLocation(SubterraneanCreaturesMod.MODID,"blocks/slime"), new ResourceLocation(SubterraneanCreaturesMod.MODID,"blocks/slime_flow"));
	public Slime() {
		
	
		super(FluidRegistry.WATER, mat);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setUnlocalizedName("slime");
		this.setRegistryName(SubterraneanCreaturesMod.MODID+":"+"slime");
		// TODO Auto-generated constructor stub
	}

}

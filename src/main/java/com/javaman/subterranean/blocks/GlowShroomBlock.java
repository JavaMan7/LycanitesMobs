package com.javaman.subterranean.blocks;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GlowShroomBlock extends BlockHugeMushroom{

	public GlowShroomBlock(Material materialIn, MapColor color, Block smallBlockIn) {
		super(materialIn, color, smallBlockIn);
		this.setRegistryName(SubterraneanCreaturesMod.MODID, "blue_mushroom_block");
		this.setUnlocalizedName("blue_mushroom_block");
		
		this.setLightLevel(.8f);
		this.setHardness(.2f);
		
	}

	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
	 public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }
	 public boolean isFullCube(IBlockState state)
	    {
	        return true;
	    }
	 @SideOnly(Side.CLIENT)
	    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	    {
	        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
	        Block block = iblockstate.getBlock();

	        if (this == ModBlocks.GLOWSHOOM_BLOCK)
	        {
	            if (blockState != iblockstate)
	            {
	                return true;
	            }

	            if (block == this)
	            {
	                return false;
	            }
	        }

	        return   block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	    }
}

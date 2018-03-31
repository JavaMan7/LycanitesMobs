package com.javaman.subterranean.blocks;

import java.util.List;
import java.util.Random;

import org.w3c.dom.css.ElementCSSInlineStyle;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LapisCobblestone extends Block implements ITickable,ITileEntityProvider //ITileEntityProvider
{
	public long timelast = 0;
	public long time = 0;
	public boolean l = true;
	
	public LapisCobblestone() {
		super(Material.ROCK);
		this.setUnlocalizedName("simie_cobblestone");
		this.setRegistryName(SubterraneanCreaturesMod.MODID+":"+"simie_cobblestone");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setTickRandomly(true);
		
		  // this.setTickRandomly(true);
	}
	
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		NonNullList<ItemStack> ret = NonNullList.create();
        getDrops(ret, world, pos, state, fortune);
        return ret;
	}


	@Override
	 public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
		
		
		
	    }
	@Override
	  public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	    {
	        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
	        {
	            entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
	           
	        }

	        super.onEntityWalk(worldIn, pos, entityIn);
	    }
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.motionX *= 0.4D;
        entityIn.motionZ *= 0.4D;
    }
	@Override
	 public int tickRate(World worldIn)
	    {
	        return 10;
	    }
	@Override
	 public boolean requiresUpdates()
	    {
	        return true;
	    }
	
	@Override
	public void update() {
		
		
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		return new TileEntityLapisCobblestone();
	}
}

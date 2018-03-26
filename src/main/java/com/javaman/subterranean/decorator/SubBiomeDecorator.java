package com.javaman.subterranean.decorator;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenerator;
import scala.reflect.internal.Trees.Return;

public class SubBiomeDecorator extends BiomeDecorator{
	 Predicate<IBlockState> blocksForOregen = new SubPredicate() ;
	 public void decorate(World worldIn, Random random, Biome biome, BlockPos pos)
	    {
		  if (this.decorating)
	        {
	            throw new RuntimeException("Already decorating");
	        }
	        else
	        {
	       
	          
	            this.genDecorations(biome, worldIn, random);
	            this.decorating = false;
	        }
	    }

	    protected void genDecorations(Biome biomeIn, World worldIn, Random random)
	    {
	    	
	       
	    	int h;
	        
	        for (int l = -8; l < 16; ++l)
	        {
	            for (int k = -8; k < 16; ++k)
	            {
	              
	            	
	                	h = l^2+k^2;
	                	
	                    if(h<255)worldIn.setBlockState(this.chunkPos.add(l,h,k),Blocks.GRASS.getDefaultState());
	                    int[] last= new int[2]; 
	                    
	                	last[0]= l;
	                	last[1]= (int) h;
	                	//int slope = (int) ((j-last[0])/(last[1]-y2));
	                	 for (int g = 0; g < l-last[0]; ++g) {
	                		 
	                		
	                		if(h<255)worldIn.setBlockState(this.chunkPos.add(l,(int) (last[1]-h),k),Blocks.GRASS.getDefaultState());
	                	 	}
	                  
	                }
	            }
	    }

	    /**
	     * Generates ores in the current chunk
	     */
	    protected void generateOres(World worldIn, Random random)
	    {
	        
	    }

	    /**
	     * Standard ore generation helper. Vanilla uses this to generate most ores.
	     * The main difference between this and {@link #genStandardOre2} is that this takes min and max heights, while
	     * genStandardOre2 takes center and spread.
	     */
	    protected void genStandardOre1(World worldIn, Random random, int blockCount, WorldGenerator generator, int minHeight, int maxHeight)
	    {
	        if (maxHeight < minHeight)
	        {
	            int i = minHeight;
	            minHeight = maxHeight;
	            maxHeight = i;
	        }
	        else if (maxHeight == minHeight)
	        {
	            if (minHeight < 255)
	            {
	                ++maxHeight;
	            }
	            else
	            {
	                --minHeight;
	            }
	        }

	        for (int j = 0; j < blockCount; ++j)
	        {
	            BlockPos blockpos = this.chunkPos.add(random.nextInt(16), random.nextInt(maxHeight - minHeight) + minHeight, random.nextInt(16));
	            generator.generate(worldIn, random, blockpos);
	        }
	    }

	    /**
	     * Standard ore generation helper. Vanilla uses this to generate Lapis Lazuli.
	     * The main difference between this and {@link #genStandardOre1} is that this takes takes center and spread, while
	     * genStandardOre1 takes min and max heights.
	     */
	    protected void genStandardOre2(World worldIn, Random random, int blockCount, WorldGenerator generator, int centerHeight, int spread)
	    {
	        for (int i = 0; i < blockCount; ++i)
	        {
	            BlockPos blockpos = this.chunkPos.add(random.nextInt(16), random.nextInt(spread) + random.nextInt(spread) + centerHeight - spread, random.nextInt(16));
	            generator.generate(worldIn, random, blockpos);
	        }
	    }
	    public static BlockPos finedOpen(World worldIn,BlockPos chunkPos,int x,int y)
		{


			

			BlockPos pos;
					for (int l = 254; l >= 0; --l)
					{
						
						if(worldIn.getBlockState(chunkPos.add(x,l,y)).getMaterial() == Material.AIR&&
								worldIn.getBlockState(chunkPos.add(x,l-1,y)).getMaterial() != Material.AIR&&
										worldIn.getBlockState(chunkPos.add(x,l-1,y)).getMaterial() != Material.WATER&& 
												worldIn.getBlockState(chunkPos.add(x,l-1,y)) != Blocks.BEDROCK.getDefaultState()
								) {
							//System.out.println(chunkPos.add(x,l,y));

							 	return new BlockPos(x,l-1,y);
							 

							





			             }
			
			
					}


					return new BlockPos(x,0,y);

		}
	   

}

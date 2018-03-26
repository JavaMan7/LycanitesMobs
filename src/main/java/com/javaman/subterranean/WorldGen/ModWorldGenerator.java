package com.javaman.subterranean.WorldGen;

import java.util.Random;

import com.javaman.subterranean.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGenerator extends WorldGenerator implements IWorldGenerator {
	
public WorldGenBigGlowShroom bigMushroomGen = new WorldGenBigGlowShroom(ModBlocks.GLOWSHOOM_BLOCK);
WorldGenBush redMushroomFeature = new WorldGenBush((BlockBush) ModBlocks.GLOWSHOOM);
WorldGenWaterlily worldGenWaterlily = new WorldGenWaterlily();
WorldGenLakes worldGenLakes = new WorldGenLakes(Blocks.WATER);
WorldGenVines worldGenVines = new WorldGenVines();
static Random rand2 = new Random();
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		
		switch (world.provider.getDimension())
		{
		/*	case -1: 
				generateNether(world, rand, blockX + 8, blockZ + 8);
				break;
			case 0: 
				generateOverworld(world, rand, blockX + 8, blockZ + 8);
				break;
			case 1: 
				generateEnd(world, rand, blockX + 8, blockZ + 8);
				break;*/
			case 8: 
				generateSub(world, rand, blockX + 8, blockZ + 8);
				break;
		}

	}
	
	private void generateOverworld(World world, Random rand, int blockX, int blockZ)
	{	
		
	}
	
	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}
	private void generateSub(World world, Random rand, int blockX, int blockZ) {
		
		
		if ((int) (Math.random() * 100) <= 1)
		{
			int y = getGroundFromAbove(world, blockX, blockZ);
			BlockPos pos = new BlockPos(blockX, y, blockZ);
			WorldGenerator Tower = new SubWorldGenTower();
			Tower.generate(world, rand, pos);
		}
		
	/*	if ((int) (Math.random() * 100) <= 5)
		{
			int y = getGroundFromAbove(world, blockX, blockZ);
			BlockPos pos = new BlockPos(blockX, y, blockZ);
			WorldGenerator obelisk = new SubWorldGen();
			obelisk.generate(world, rand, pos);
		};*/
	
		if ((int) (Math.random() * 100) <=50 )
        {
            int l6 = rand.nextInt(16) + 8;
            int k10 = rand.nextInt(16) + 8;
            for(int i=0; i<=3;i++) {
            vineGen(world, blockX+k10,blockZ+l6);
            }
        }
         
			
        
		if ((int) (Math.random() * 100) <=20 )
        {
            int l6 = rand.nextInt(16) + 8;
            int k10 = rand.nextInt(16) + 8;
            int y = getGroundFromAbove(world,blockX+k10,blockZ+l6);
            this.worldGenLakes.generate(world, rand,new BlockPos(blockX+k10,y-1, blockZ+l6));
        }
		if ((int) (Math.random() * 100) <=50 )
        {
            int l6 = rand.nextInt(16) + 8;
            int k10 = rand.nextInt(16) + 8;
            int y = getGroundFromAbove(world,blockX+k10,blockZ+l6);
            this.redMushroomFeature.generate(world, rand,new BlockPos(blockX+k10,y+1, blockZ+l6));
        }
		
		
		// if(net.minecraftforge.event.terraingen.TerrainGen.decorate(world, rand, blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM)) {
		if ((int) (Math.random() * 100) <=20 )
		        {
		            int l6 = rand.nextInt(16) + 8;
		            int k10 = rand.nextInt(16) + 8;
		            int y = getGroundFromAbove(world,blockX+k10,blockZ+l6);
		            this.bigMushroomGen.generate(world, rand,new BlockPos(blockX+k10,y+1, blockZ+l6));
		        }
		
		addOreSpawn(Blocks.GLOWSTONE.getDefaultState(), world, rand, blockX, blockZ, 5, 5, 10, 80, 0, 200);
		addOreSpawn(Blocks.DIAMOND_ORE.getDefaultState(), world, rand, blockX, blockZ, 5, 5, 10, 80, 0, 200);
		
		
		
		
	if ((int) (Math.random() * 100) == 0)
		{
			int y = getGroundFromAbove(world, blockX, blockZ);
			BlockPos pos = new BlockPos(blockX, y, blockZ);
			WorldGenerator obelisk = new SubWorldGen();
			obelisk.generate(world, rand, pos);
		}
		
	}
	
	private void addOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY)
	{
		for (int i = 0; i < chanceToSpawn; i++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block, maxVeinSize).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
	public static int getGroundFromAbove(World world, int x, int z)
	{
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 31)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround =  blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER || blockAt == Blocks.GLASS||blockAt == Blocks.MYCELIUM;
		}

		return y;
	}
	public static int getLakeFromAbove(World world, int x, int z)
	{
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 31)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround =  blockAt == Blocks.WATER||blockAt == Blocks.FLOWING_WATER;
		}

		return y;
	}
	
	public  void vineGen(World world, int x, int z)
	{


		int y = 255;

		Block blockAt;
		BlockPos pos =new BlockPos(x,y,z);
		boolean foundGround = false;
		boolean foundSide = false;
		int r =rand2.nextInt(4);
		
		int i =0;
		int drop = 1;
		while(!foundGround && y-- >= 31)
		{

			blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround =  blockAt == Blocks.WATER||blockAt == Blocks.FLOWING_WATER||blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER || blockAt == Blocks.GLASS||blockAt == Blocks.MYCELIUM;


		}




		while(!foundSide && ++i <= 48)
		{

			
			switch(r) {
			case 0:x++;
			case 1:x--;
			case 2:z++;
			case 3:z--;
			}
		//	System.out.println(r);
			//System.out.println(new BlockPos(x,y,z));
			blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundSide =   blockAt == Blocks.AIR&& world.getBlockState(new BlockPos(x,y-drop,z)).getBlock() == Blocks.AIR;

		}



		i = 0;
		BlockPos blockpos$mutableblockpos1 = new BlockPos(x,y,z);





		//	System.out.println(world.getBlockState(blockpos$mutableblockpos1).getMaterial() == Material.AIR);


		if ((world.getBlockState(new BlockPos(x,y,z)).getBlock() == Blocks.AIR))
		{
			BlockPos blockpos3 = blockpos$mutableblockpos1.west();
			BlockPos blockpos4 = blockpos$mutableblockpos1.east();
			BlockPos blockpos1 = blockpos$mutableblockpos1.north();
			BlockPos blockpos2 = blockpos$mutableblockpos1.south();



			if ( (world.isAirBlock(blockpos3)))
			{
				//System.out.println("EAST");
				addVine(world, blockpos3, BlockVine.EAST);

			}

			if ( world.isAirBlock(blockpos4))
			{
				addVine(world, blockpos4, BlockVine.WEST);
				//System.out.println("WEST");
			}

			if ( world.isAirBlock(blockpos1))
			{
				addVine(world, blockpos1, BlockVine.SOUTH);
				// System.out.println("SOUTH");
			}

			if ( world.isAirBlock(blockpos2))
			{
				addVine(world, blockpos2, BlockVine.NORTH);
				//  System.out.println("NORTH");
			}

		}

		
	}
		private  void addVine(World worldIn, BlockPos pos, PropertyBool prop)
	    {
	        IBlockState iblockstate = Blocks.VINE.getDefaultState().withProperty(prop, Boolean.valueOf(true));
	        this.setBlockAndNotifyAdequately(worldIn, pos, iblockstate);
	        int i = 15+rand2.nextInt(15);;

	        for (BlockPos blockpos = pos.down(); worldIn.isAirBlock(blockpos) && i > 0; --i)
	        {
	            setBlockAndNotifyAdequately(worldIn, blockpos, iblockstate);
	            blockpos = blockpos.down();
	        }
	    }
	public static boolean canSpawnHere(Template template, World world, BlockPos posAboveGround)
	{
		int zwidth = template.getSize().getZ();
		int xwidth = template.getSize().getX();
		
		// check all the corners to see which ones are replaceable
		boolean corner1 = isCornerValid(world, posAboveGround);
		boolean corner2 = isCornerValid(world, posAboveGround.add(xwidth, 0, zwidth));
		
		// if Y > 20 and all corners pass the test, it's okay to spawn the structure
		return posAboveGround.getY() > 5 && corner1 && corner2;
	}
	
	public static boolean isCornerValid(World world, BlockPos pos)
	{
		int variation = 3;
		int highestBlock = getGroundFromAbove(world, pos.getX(), pos.getZ());
		
		if (highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation)
			return true;
				
		return false;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		// TODO Auto-generated method stub
		return false;
	}
}
package com.javaman.subterranean.biomes;

import java.util.List;
import java.util.Random;

import com.google.common.base.Optional;
import com.javaman.subterranean.SubterraneanCreaturesMod;
import com.javaman.subterranean.entity.EntityFireToad;
import com.javaman.subterranean.entity.EntityFlailSnail;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenFireSub extends Biome{
	//protected static Optional<? extends BiomeManager> instance            = Optional.absent();
	public static IBlockState topBlock = Blocks.GRASS.getDefaultState();
	/** The block to fill spots in when not on the top */
	public static IBlockState fillerBlock = Blocks.DIRT.getDefaultState();
	public BiomeGenFireSub(BiomeProperties Properties){
		super(Properties);
		setRegistryName(SubterraneanCreaturesMod.MODID, "BiomeGenFireSub");
		//this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityFireToad.class, 1, 1, 2));
		//this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityFlailSnail.class, 1, 1, 2));
		this.topBlock = Blocks.MYCELIUM.getDefaultState();
		this.decorator.treesPerChunk = -100;
		this.decorator.flowersPerChunk = -100;
		this.decorator.grassPerChunk = -100;
		this.decorator.mushroomsPerChunk = 20;
		this.decorator.bigMushroomsPerChunk = 20;

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		//this.spawnableMonsterList.clear();
		//this.spawnableMonsterList.add(new SpawnListEntry(EntityFireToad.class, 1, 1, 1));
		//this.spawnableMonsterList.add(new SpawnListEntry(EntityFlailSnail.class, 1, 1, 1));
		

		//BiomeManager.addWeightedGrassGenForBiome(this, worldGeneratorBigTree, 100);

		//  this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityMooshroom.class, 8, 4, 8));
		//this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityFlumph.class, 8, 4, 8));

		//this.addFlower(arg0, arg1, arg2);



	}
	public static void generateBiomeGenFireSubTerrain(ChunkPrimer chunkPrimerIn)
	{


		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (int j = 15; j >= 0; --j)
		{

			for (int k = 15; k >= 0; --k)
			{
				for (int l = 254; l >= 0; --l)
				{

					if(chunkPrimerIn.getBlockState(j, l, k).getMaterial() == Material.AIR&&
							chunkPrimerIn.getBlockState(j, l-1, k).getMaterial() != Material.AIR&&
							chunkPrimerIn.getBlockState(j, l-1, k).getMaterial() != Material.WATER&& 
							chunkPrimerIn.getBlockState(j, l-1, k) != Blocks.BEDROCK.getDefaultState()
							) {


						chunkPrimerIn.setBlockState(j, l-1, k, topBlock);



					}




				}





			}




		}





	}


	



}
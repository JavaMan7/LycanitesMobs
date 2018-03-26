package com.javaman.subterranean.dimension;

import com.javaman.subterranean.biomes.BiomeRegistry;

import net.minecraft.entity.Entity;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.ChunkGeneratorHell;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderSub extends WorldProvider //WorldProviderSurface
{
	protected int dimensionId=8;

	 @Override
	    public IChunkGenerator createChunkGenerator() {
	       return new ChunkProviderSub(world, false,  this.world.getSeed());
		 //return new TestChunkGenerator(world);
	    }
	 @Override
    public DimensionType getDimensionType()
    {
        return DimensionRegister.dimensionType;
    }
	 public void init()
	    {
		 	this.hasSkyLight = false;
	        this.biomeProvider = new BiomeProviderSingle(BiomeRegistry.BiomeGenFireSub);
	        setSkyRenderer(null);
	        setCloudRenderer(null);
	        setWeatherRenderer(null);
	       // this.doesWaterVaporize = true;
	       // this.nether = true;
	    }
	 @Override
	 public boolean canRespawnHere()
	    {
	        return false;
	    }
	 @SideOnly(Side.CLIENT)
	    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_)
	    {
	        return new Vec3d(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
	    }
	 @SideOnly(Side.CLIENT)
	    public Vec3d getSkyColorBody(Entity entityIn, float partialTicks)
	    {
		  return new Vec3d(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
	    }
	 public float calculateCelestialAngle(long worldTime, float partialTicks)
	    {
		 worldTime = 18000;
	        int i = (int)(worldTime % 24000L);
	        float f = ((float)i + partialTicks) / 24000.0F - 0.25F;

	        if (f < 0.0F)
	        {
	            ++f;
	        }

	        if (f > 1.0F)
	        {
	            --f;
	        }

	        float f1 = 1.0F - (float)((Math.cos((double)f * Math.PI) + 1.0D) / 2.0D);
	        f = f + (f1 - f) / 3.0F;
	        return f;
	    }

}

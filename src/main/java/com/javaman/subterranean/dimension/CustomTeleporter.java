package com.javaman.subterranean.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import javax.annotation.Nonnull;

public class CustomTeleporter extends Teleporter {

    public CustomTeleporter(WorldServer world, double x, double y, double z) {
        super(world);
        this.worldServer = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private final WorldServer worldServer;
    private double x;
    private double y;
    private double z;

    @Override
    public void placeInPortal(@Nonnull Entity entity, float rotationYaw) {
        this.worldServer.getBlockState(new BlockPos((int) this.x, (int) this.y, (int) this.z));

        entity.setPosition(this.x, this.y, this.z);
        entity.motionX = 0.0f;
        entity.motionY = 0.0f;
        entity.motionZ = 0.0f;
    }


    public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z) {
    	
    	x = player.posX;
    	y = player.posY;
    	z = player.posZ;
    			
    	
        int oldDimension = player.getEntityWorld().provider.getDimension();
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
        MinecraftServer server = player.getEntityWorld().getMinecraftServer();
        WorldServer worldServer = server.getWorld(dimension);
        player.addExperienceLevel(0);

        if (worldServer == null || worldServer.getMinecraftServer() == null){ //Dimension doesn't exist
            throw new IllegalArgumentException("Dimension: "+dimension+" doesn't exist!");
        }
        
        worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, new CustomTeleporter(worldServer, x, y, z));
        player.setPositionAndUpdate(x, y, z);
        
        worldServer.setBlockState(new BlockPos (player.posX,player.posY+1,player.posZ),Blocks.AIR.getDefaultState());
        worldServer.setBlockState(new BlockPos (player.posX,player.posY,player.posZ),Blocks.AIR.getDefaultState());
        worldServer.setBlockState(new BlockPos (player.posX,player.posY-1,player.posZ),Blocks.STONE.getDefaultState());
        
        
        if (oldDimension == 1) {
            // For some reason teleporting out of the end does weird things.
        	
            player.setPositionAndUpdate(x, y, z);
            worldServer.setBlockState(new BlockPos (player.posX,player.posY+1,player.posZ), Blocks.GRASS.getDefaultState());
            worldServer.spawnEntity(player);
            worldServer.updateEntityWithOptionalForce(player, false);
        }
    }

}

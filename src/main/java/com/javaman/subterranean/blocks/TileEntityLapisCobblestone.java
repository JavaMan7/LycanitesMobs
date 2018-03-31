package com.javaman.subterranean.blocks;



import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;

public class TileEntityLapisCobblestone extends TileEntity implements ITickable
{
    private int outputSignal;
    
    public World world;
    
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("OutputSignal", this.outputSignal);
        return compound;
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.outputSignal = compound.getInteger("OutputSignal");
    }

    public int getOutputSignal()
    {
        return this.outputSignal;
    }

    public void setOutputSignal(int outputSignalIn)
    {
        this.outputSignal = outputSignalIn;
        
    }
    public long timelast = 0;
	public long time = 0;
	public boolean l = true;
	public boolean slime = true;
	
	@Override
	public void update() {
		
		if(slime) {
			
			this.getWorld().setBlockState(pos.add(0, 1, 0), Blocks.WATER.getDefaultState());
			//this.getWorld().setBlockState(pos.add(0, 1, 1), ModBlocks.lapisCobblestone.getDefaultState());
			//this.getWorld().setBlockState(pos.add(0, 1, 1), Blocks.SNOW.getDefaultState());
			
			
		}
		
		
		//this.getWorld().setBlockState(pos, Blocks.AIR.getDefaultState());
		 //worldIn.scheduleUpdate(pos, this, 10);
			// worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			 if(l) {
				 timelast =	Minecraft.getMinecraft().getSystemTime();
				 
				 l=false;
			 }else {
				 
				 //System.out.println("hi");
				 time =Minecraft.getMinecraft().getSystemTime();
				 
				 if(time - timelast >= 0) {
					 
					
					 this.getWorld().setBlockState(pos, Blocks.AIR.getDefaultState());
					 l=true;
					 
				 }
				 
				
				// worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			 }
				
		
	}

	
    
    
    
}
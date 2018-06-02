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
    public long stayTime = 3;
    public long timelast = 0;
	public long time = 0;
	public boolean l = true;
	public boolean slime = true;
	
	@Override
	public void update() {
		
			
			this.getWorld().setBlockState(pos.add(0, 0, 0), ModBlocks.lapisCobblestone.getDefaultState());
		
			
					
			if(l) {
				 timelast =	Minecraft.getMinecraft().getSystemTime()+1000*stayTime;
				 
				 l=false;
			 }else {
				 
				 //System.out.println("hi");
				 time =Minecraft.getMinecraft().getSystemTime();
			 }
				 if(time - timelast >= 0) {
					 
					
					 this.getWorld().setBlockState(pos, Blocks.AIR.getDefaultState());
					 l=true;
					 
				 }
					 
		
				
		
	}

	
    
    
    
}
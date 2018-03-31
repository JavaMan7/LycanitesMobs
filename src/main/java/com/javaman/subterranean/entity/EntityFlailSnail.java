package com.javaman.subterranean.entity;

import com.javaman.subterranean.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityFlailSnail extends EntityZombie //implements IRangedAttackMob 
{

	private int attackTimer;

	public EntityFlailSnail(World worldIn) {
		super(worldIn);
		setSize(1f, 2f);
		
	}
	@Override
	protected boolean shouldBurnInDay()
    {
        return false;
    } 
	protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SQUID_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return SoundEvents.ENTITY_SQUID_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }
	

	    protected SoundEvent getStepSound()
	    {
	        return SoundEvents.ENTITY_SQUID_AMBIENT;
	    }

	    protected void playStepSound(BlockPos pos, Block blockIn)
	    {
	        this.playSound(this.getStepSound(), 0.15F, 1.0F);
	    }
	    @Override
	    public void setChild(boolean childZombie)
	    {
	       
	    }
	    public boolean attackEntityAsMob(Entity entityIn)
	    {
	        boolean flag = super.attackEntityAsMob(entityIn);

	        
           
           //  if(entityIn.getCollisionBoundingBox().contains(entityfallingblock.getPositionVector()))entityIn.attackEntityFrom(DamageSource.IN_WALL, 3f);
             
			
			

	        return flag;
	    }
	    private static  void shoot(double x, double y, double z, float velocity,Entity e)
	    {
	        float f = MathHelper.sqrt(x * x + y * y + z * z);
	        x = x / (double)f;
	        y = y / (double)f;
	        z = z / (double)f;
	       
	        x = x * (double)velocity;
	        y = y * (double)velocity;
	        z = z * (double)velocity;
	        e.motionX = x;
	        e.motionY = y;
	        e.motionZ = z;
	        float f1 = MathHelper.sqrt(x * x + z * z);
	       e.rotationYaw = (float)(MathHelper.atan2(x, z) * (180D / Math.PI));
	        e.rotationPitch = (float)(MathHelper.atan2(y, (double)f1) * (180D / Math.PI));
	        e.prevRotationYaw = e.rotationYaw;
	        e.prevRotationPitch = e.rotationPitch;
	       // e.ticksInGround = 0;
	    }
	    public void onLivingUpdate() {
	    
    ++this.attackTimer;

	     try {
	    	 
	    	 Entity entityplayer = this;
	    	 Entity target = this.getAttackTarget();
	    	  if (this.attackTimer == 20&& target != null)
              {
	    		  
	    		  EnumFacing f	= entityplayer.getHorizontalFacing();
	    			f.getFrontOffsetX();
	    			
	    			for(int i =0; i<10;i++)	{
	    				BlockPos breakPos =new BlockPos(entityplayer.getPosition().getX()+ 0.5d+f.getFrontOffsetX()+(i*.5),entityplayer.getPosition().getY()+ 0.5d-1+f.getFrontOffsetY(), entityplayer.getPosition().getZ()+ 0.5d+f.getFrontOffsetZ());
	    				IBlockState b = world.getBlockState(breakPos);//Blocks.STONE.getDefaultState();
	    	    		Block bl = b.getBlock();
	    	    		IBlockState iB = ModBlocks.lapisCobblestone.getDefaultState();//bl.getDefaultState();
	    	    		breakPos=breakPos.add(0, 5, 0);
	    				
	    				world.setBlockState(breakPos, iB);
	    				
	    			EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, breakPos.getX(),breakPos.getY(), breakPos.getZ(),  iB );
	    				 //EntityTNTPrimed entityfallingblock = new EntityTNTPrimed(world, entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d,null);
	    				 //EntityCow entityfallingblock = new EntityCow(world);
	    				  
	    				 
	    				// EntityFireShot entityfallingblock = new EntityFireShot(world, entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d);
	    				
	    				
	    				System.out.println(entityplayer.getRotatedYaw(Rotation.NONE));
	    				int power = 2;
	    				float yaw = entityplayer.getRotatedYaw(Rotation.CLOCKWISE_90);
	    				float pitch = entityplayer.getPitchYaw().x;
	    				
	    				double v1 = Math.sin((yaw+(i*15))*(Math.PI/180))*power;
	    				double v2 = Math.cos((yaw+(i*15))*(Math.PI/180))*power;
	    				double v3 =Math.sin(pitch*(Math.PI/180)*-1)*power;
	    				if(this.getDistance(target)<= 1000) {
	    				entityfallingblock.motionX=v2;
	    				entityfallingblock.motionY=v3;
	    				entityfallingblock.motionZ=v1;
	    				//target.addVelocity(v2, v3, v1);
	    				}
	    				world.spawnEntity(entityfallingblock);
	    			}
	    		/*efor(int i=0 ;i<3;i++)  {
	    		  float yaw = this.getRotatedYaw(Rotation.CLOCKWISE_90);
	    		 float yaw2 = this.getRotatedYaw(Rotation.NONE);
	      		float pitch = this.getPitchYaw().x; 
	      		double ofX = 0;
	      		double ofZ = 0;
	      		if(yaw2>-90|| yaw2<90)ofX = 2;
	      		if(yaw2<-90|| yaw2>90)ofX = -2;
	      		if(yaw2>-180|| yaw2<180)ofZ  = 2;
	      		if(yaw2<-180|| yaw2>180)ofZ = -2;
	    	BlockPos breakPos =new BlockPos(this.getPosition().getX()+ofZ,this.getPosition().getY()-1d, this.getPosition().getZ()+ ofX);
    		IBlockState b = world.getBlockState(breakPos);//Blocks.STONE.getDefaultState();
    		Block bl = b.getBlock();
    		IBlockState iB = bl.getDefaultState();
    		this.getDistanceSq(target);
    		world.setBlockState(breakPos, Blocks.AIR.getDefaultState());
    		//System.out.println(breakPos.getY());
    		breakPos=breakPos.add(0, 1, 0);
    		//System.out.println(breakPos.getY());
    		world.setBlockState(breakPos, iB);
    		
    		EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, breakPos.getX(),breakPos.getY(), breakPos.getZ(), iB );
     		 //EntityFireShot entityfallingblock = new EntityFireShot(world, this.getPosition().getX()+ 0.5d,this.getPosition().getY()+ 0.5d, this.getPosition().getZ()+ 0.5d);
     		
     		
     		
     		 
        	// EntityTNTPrimed entityarrow = new EntityTNTPrimed(this.world, this.getPosition().getX()+ 0.5d,this.getPosition().getY()+ 0.5d, this.getPosition().getZ()+ 0.5d,null);
        	 //EntityTippedArrow entityarrow = new EntityTippedArrow(this.world, this.parentEntity);
    		int power = 1;
    		
    		double v1 = Math.sin(yaw*(Math.PI/180))*power;
    		double v2 = Math.cos(yaw*(Math.PI/180))*power;
    		double v3 =.5;//Math.sin(pitch*(Math.PI/180)*-1)*power;
    		entityfallingblock.motionX=v2;
    		entityfallingblock.motionY=v3;
    		entityfallingblock.motionZ=v1;
    		//System.out.println(target);
    		if(this.getDistance(target)<= 5) {
    			//System.out.println(target);
    		target.motionX = target.motionX + v2;
    		target.motionY = target.motionY + v3;
    		target.motionZ = target.motionZ + v1;
    		}
             this.world.spawnEntity(entityfallingblock);
             //world.setBlockState(breakPos,  Blocks.AIR.getDefaultState());*/
	    		//}
              } else if (this.attackTimer > 20)
              {
                  this.attackTimer = 0;
              }
	    }catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");
	    }
	        if (this.world.isDaytime() && !this.world.isRemote && !this.isChild() && this.shouldBurnInDay())
	        {
	            float f = this.getBrightness();

	            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.world.canSeeSky(new BlockPos(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ)))
	            {
	                boolean flag = true;
	                ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

	                if (!itemstack.isEmpty())
	                {
	                    if (itemstack.isItemStackDamageable())
	                    {
	                        itemstack.setItemDamage(itemstack.getItemDamage() + this.rand.nextInt(2));

	                        if (itemstack.getItemDamage() >= itemstack.getMaxDamage())
	                        {
	                            this.renderBrokenItemStack(itemstack);
	                            this.setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
	                        }
	                    }

	                    flag = false;
	                }

	                if (flag)
	                {
	                    this.setFire(8);
	                }
	            }
	        }

	        super.onLivingUpdate();
	    }


}
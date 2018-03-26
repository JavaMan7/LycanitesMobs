package com.javaman.subterranean.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIZombieAttack;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityFireToad extends EntityMob   {
	int FireballStrength = 1;
	
	public EntityFireToad(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 0.8F);
	}
	
	 protected void initEntityAI()
	    {
	        this.tasks.addTask(0, new EntityAISwimming(this));
	       
	        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
	        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
	        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	        this.tasks.addTask(8, new EntityAILookIdle(this));
	        this.applyEntityAI();
	    }

	    protected void applyEntityAI()
	    {
	        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
	        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityPigZombie.class}));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
	        try {
	        this.targetTasks.addTask(3, new AIFireballAttack(this));
	        }catch (NullPointerException e) {
	            System.out.print("Caught the NullPointerException");
	        }
	    }
	   
	
	
	 static class AIFireballAttack extends EntityAIBase
     {
         private final EntityFireToad parentEntity;
         public int attackTimer;

         public AIFireballAttack(EntityFireToad ghast)
         {
             this.parentEntity = ghast;
         }

         /**
          * Returns whether the EntityAIBase should begin execution.
          */
         public boolean shouldExecute()
         {
             return this.parentEntity.getAttackTarget() != null;
         }

         /**
          * Execute a one shot task or start executing a continuous task
          */
         public void startExecuting()
         {
             this.attackTimer = 0;
         }

         /**
          * Reset the task's internal state. Called when this task is interrupted by another one
          */
        

         /**
          * Keep ticking a continuous task that has already been started
          */
         public void updateTask()
         {
             EntityLivingBase target = this.parentEntity.getAttackTarget();
            // double d0 = 64.0D;
             try {
             if (target.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(target))
             {
            	 
            	 World world = this.parentEntity.world;
                 ++this.attackTimer;

                 if (this.attackTimer == 10)
                 {
                    // world.playEvent((EntityPlayer)null, 1015, new BlockPos(this.parentEntity), 0);
                 }

                 if (this.attackTimer == 20)
                {
            	 Entity entityplayer = this.parentEntity;
            	 
            	
         		
         		//this.parentEntity.world.setBlockState(new BlockPos(entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d), b);
         		
         		
         		 //EntityTNTPrimed entityfallingblock = new EntityTNTPrimed(world, entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d,null);
         		 //EntityCow entityfallingblock = new EntityCow(world);
         		
        		
        		
         		BlockPos breakPos =new BlockPos(entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d);
        		IBlockState b = Blocks.STONE.getDefaultState();
        		world.setBlockState(breakPos, b);
        		
        		EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, breakPos.getX(),breakPos.getY(), breakPos.getZ(), b );
         		 //EntityFireShot entityfallingblock = new EntityFireShot(world, entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d);
         		
         		this.parentEntity.world.spawnEntity(entityfallingblock);
            	 
            	
            	 EntityTNTPrimed entityarrow = new EntityTNTPrimed(this.parentEntity.world, entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d,null);
            	 //EntityTippedArrow entityarrow = new EntityTippedArrow(this.parentEntity.world, this.parentEntity);
                 double d0 = target.posX - this.parentEntity.posX;
                 double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entityarrow.posY;
                 double d2 = target.posZ - this.parentEntity.posZ;
                 double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
                 //entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 0);
                 shoot(d0, d1, d2, 3f,entityfallingblock);
                 //this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / ( 0.4F + 0.8F));
                 this.parentEntity.world.spawnEntity(entityfallingblock);
               
                 if(target.getCollisionBoundingBox().contains(entityfallingblock.getPositionVector()))target.attackEntityFrom(DamageSource.IN_WALL, 3f);
                 
                }
             }
             else if (this.attackTimer > 0)
             {
                 --this.attackTimer;
             }
         }catch (NullPointerException e) {
	            System.out.print("Caught the NullPointerException");
	        }

             //this.parentEntity.setAttacking(this.attackTimer > 10);
         }
     }


	

	public int getFireballStrength() {
		// TODO Auto-generated method stub
		return 0;
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
	
	 
	
	
	
	

}
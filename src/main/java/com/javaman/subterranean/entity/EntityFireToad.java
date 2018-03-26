package com.javaman.subterranean.entity;

import net.minecraft.block.state.IBlockState;
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
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
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
             EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
             double d0 = 64.0D;
             try {
             if (entitylivingbase.getDistanceSq(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(entitylivingbase))
             {
                 World world = this.parentEntity.world;
                 ++this.attackTimer;

                 if (this.attackTimer == 10)
                 {
                    // world.playEvent((EntityPlayer)null, 1015, new BlockPos(this.parentEntity), 0);
                 }

                 if (this.attackTimer == 20)
                 {
                     double d1 = 4.0D;
                     Vec3d vec3d = this.parentEntity.getLook(1.0F);
                     double d2 = entitylivingbase.posX - (this.parentEntity.posX + vec3d.x * 4.0D);
                     double d3 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (0.5D + this.parentEntity.posY + (double)(this.parentEntity.height / 2.0F));
                     double d4 = entitylivingbase.posZ - (this.parentEntity.posZ + vec3d.z * 4.0D);
                     //world.playEvent((EntityPlayer)null, 1016, new BlockPos(this.parentEntity), 0);
                     
                     //BlockPos breakPos = new BlockPos(this.parentEntity.getPosition().getX(),this.parentEntity.getPosition().getY()-1, this.parentEntity.getPosition().getZ());
                     BlockPos breakPos = new BlockPos(0,0, 0);
         			IBlockState blockState = this.parentEntity.getEntityWorld().getBlockState(breakPos);
         			
         			
         			world.setBlockState(new BlockPos(1,0,0), blockState);
         			EntityFallingBlock  entitylargefireball = new EntityFallingBlock(world, d2, d3, d4,blockState);
         			
         			
         			
                     entitylargefireball.posX = this.parentEntity.posX + vec3d.x * 4.0D;
                     entitylargefireball.posY = this.parentEntity.posY + (double)(this.parentEntity.height / 2.0F) + 0.5D;
                     entitylargefireball.posZ = this.parentEntity.posZ + vec3d.z * 4.0D;
                     world.spawnEntity(entitylargefireball);
                     this.attackTimer = -40;
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

	
	 
	
	
	
	

}
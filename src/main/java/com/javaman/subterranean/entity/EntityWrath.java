package com.javaman.subterranean.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;

import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.PlaySoundEvent;

public class EntityWrath extends EntityZombie  {

	public EntityWrath(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected boolean shouldBurnInDay()
    {
        return false;
    }
	 protected SoundEvent getAmbientSound()
	    {
	        return SoundEvents.ENTITY_BLAZE_AMBIENT;
	    }

	    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
	    {
	        return SoundEvents.ENTITY_WITHER_HURT;
	    }

	    protected SoundEvent getDeathSound()
	    {
	        return SoundEvents.ENTITY_BLAZE_DEATH;
	    }

	    protected SoundEvent getStepSound()
	    {
	        return null;
	    }

	    protected void playStepSound(BlockPos pos, Block blockIn)
	    {
	        this.playSound(this.getStepSound(), 0.15F, 1.0F);
	    }

	    public boolean attackEntityAsMob(Entity entityIn)
	    {
	    	setHealth( (float) (getHealth() +  getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
	    	
	    	//System.out.println(getHealth());
	    	super.attackEntityAsMob(entityIn);
	    	
	    	
	    	
	    	 return true;
	    }
	    @Override
	    public void setChild(boolean childZombie)
	    {
	       
	    }
}

	
package com.javaman.subterranean.entity;

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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityFlailSnail extends EntityZombie //implements IRangedAttackMob 
{

	public EntityFlailSnail(World worldIn) {
		super(worldIn);
		setSize(2.0f, 2.0f);
		
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

	       
	        BlockPos breakPos = new BlockPos(this.getPosition().getX(),this.getPosition().getY()-1, this.getPosition().getZ());
			BlockPos breakPos2 = new BlockPos(0,0, 0);
			BlockPos breakPos3 = new BlockPos(0,59, 0);
			IBlockState a =world.getBlockState(breakPos3);
			IBlockState b =world.getBlockState(breakPos2);
			
			IBlockState blockState = this.getEntityWorld().getBlockState(breakPos);
			if ((int) (Math.random() * 10) <= 100 && blockState.getBlock() != Blocks.AIR)
			{
			world.setBlockState(new BlockPos(1,0,0), blockState);
			EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, this.getPosition().getX(),this.getPosition().getY()+5, this.getPosition().getZ(),blockState);
			entityfallingblock.motionX=.5;
			entityfallingblock.motionY=.5;
			entityfallingblock.motionZ=.5;
			world.spawnEntity(entityfallingblock);
			
			}

	        return flag;
	    }
	

}
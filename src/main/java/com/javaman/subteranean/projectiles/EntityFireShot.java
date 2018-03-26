package com.javaman.subteranean.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFireShot extends EntityThrowable {

	 public EntityFireShot(World worldIn)
	    {
	        super(worldIn);
	    }

	    public EntityFireShot(World worldIn, EntityLivingBase throwerIn)
	    {
	        super(worldIn, throwerIn);
	    }

	    public EntityFireShot(World worldIn, double x, double y, double z)
	    {
	        super(worldIn, x, y, z);
	    }
	

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(RayTraceResult mop) {
		if (mop.entityHit != null) {
			// We changed this to type 'float' and set to '2'; note you could
			// just put the damage in
			// the method directly if you don't intend to change the damage
			// variable
			float rockDamage = 2;

			// now in this line we don't need to cast as 'float', since our
			// variable is already that type
			mop.entityHit.attackEntityFrom(
					DamageSource.causeThrownDamage(this, this.getThrower()),
					rockDamage);
			mop.entityHit.setFire(100);
		}

		// spawn 4 "crit" particles at the point of impact
		for (int l = 0; l < 4; ++l) {
			//this.worldObj.spawnParticle("crit", this.posX, this.posY,
					//this.posZ, 0.0D, 0.0D, 0.0D);
		}

		// be sure to set the entity to 'dead' or it will keep updating forever
		// and you'll end up with lots of
		// leftover entities in your world
		if (!world.isRemote) {
			setDead();
		}
	}

	
}
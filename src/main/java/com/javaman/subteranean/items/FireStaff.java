package com.javaman.subteranean.items;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.javaman.subteranean.projectiles.EntityFireShot;
//import com.javaman.subteranean.projectiles.EntityFireShot;
import com.javaman.subterranean.SubterraneanCreaturesMod;
import com.javaman.subterranean.client.renderer.entity.EntityRenderRegister;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireStaff  extends  Item{
	

	private Entity pointedEntity;
	private  Minecraft mc = Minecraft.getMinecraft();
	private float partialTicks= Minecraft.getMinecraft().getRenderPartialTicks();

	public FireStaff( ) {
		super();
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName("fire_staff");
		this.setRegistryName(SubterraneanCreaturesMod.MODID+":"+"fire_staff");
		//this.setr
		 this.setMaxDamage(384);
		 
		 this.setMaxStackSize(64);
		 this.setCreativeTab(CreativeTabs.COMBAT);
		 
	}

	/**
	* Called whenever this item is equipped and the right mouse button is pressed.
	* Args: itemStack, world, entityPlayer
	*/
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand handIn) {
	
	
	

	//world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	// IMPORTANT! Only spawn new entities on the server. If the world is not remote,
	// that means you are on the server:
		 Entity entity = this.mc .getRenderViewEntity();

	        if (entity != null)
	        {
	            if (this.mc.world != null)
	            {
	                this.mc.mcProfiler.startSection("pick");
	                this.mc.pointedEntity = null;
	                double d0 = 100;//(double)this.mc.playerController.getBlockReachDistance();
	                this.mc.objectMouseOver = entity.rayTrace(d0, partialTicks);
	                Vec3d vec3d = entity.getPositionEyes(partialTicks);
	                boolean flag = false;
	                int i = 3;
	                double d1 = d0;

	                if (this.mc.playerController.extendedReach())
	                {
	                    d1 = 6.0D;
	                    d0 = d1;
	                }
	                else
	                {
	                    if (d0 > 3.0D)
	                    {
	                        flag = true;
	                    }
	                }

	                if (this.mc.objectMouseOver != null)
	                {
	                    d1 = this.mc.objectMouseOver.hitVec.distanceTo(vec3d);
	                }
	                d0=100;
	                Vec3d vec3d1 = entity.getLook(1.0F);
	                Vec3d vec3d2 = vec3d.addVector(vec3d1.x * d0, vec3d1.y * d0, vec3d1.z * d0);
	                this.pointedEntity = null;
	                Vec3d vec3d3 = null;
	                float f = 1.0F;
	                List<Entity> list = world.getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().expand(vec3d1.x * d0, vec3d1.y * d0, vec3d1.z * d0).grow(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, new Predicate<Entity>()
	                {
	                    public boolean apply(@Nullable Entity p_apply_1_)
	                    {
	                        return !(p_apply_1_ instanceof  EntityPlayerMP);//p_apply_1_ != null && p_apply_1_.canBeCollidedWith();
	                    }
	                }));
	                double d2 = d1;

	                for (int j = 0; j < list.size(); ++j)
	                {
	                    Entity entity1 = list.get(j);
	                    AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow((double)entity1.getCollisionBorderSize());
	                    RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(vec3d, vec3d2);

	                    if (axisalignedbb.contains(vec3d))
	                    {
	                        if (d2 >= 0.0D)
	                        {
	                            this.pointedEntity = entity1;
	                            vec3d3 = raytraceresult == null ? vec3d : raytraceresult.hitVec;
	                            d2 = 0.0D;
	                        }
	                    }
	                    else if (raytraceresult != null)
	                    {
	                        double d3 = vec3d.distanceTo(raytraceresult.hitVec);

	                        if (d3 < d2 || d2 == 0.0D)
	                        {
	                            if (entity1.getLowestRidingEntity() == entity.getLowestRidingEntity() && !entity1.canRiderInteract())
	                            {
	                                if (d2 == 0.0D)
	                                {
	                                    this.pointedEntity = entity1;
	                                    vec3d3 = raytraceresult.hitVec;
	                                }
	                            }
	                            else
	                            {
	                                this.pointedEntity = entity1;
	                                vec3d3 = raytraceresult.hitVec;
	                                d2 = d3;
	                            }
	                        }
	                    }
	                }

	                if (this.pointedEntity != null && flag && vec3d.distanceTo(vec3d3) > 3.0D)
	                {
	                    this.pointedEntity = null;
	                    this.mc.objectMouseOver = new RayTraceResult(RayTraceResult.Type.MISS, vec3d3, (EnumFacing)null, new BlockPos(vec3d3));
	                }

	                if (this.pointedEntity != null && (d2 < d1 || this.mc.objectMouseOver == null))
	                {
	                    this.mc.objectMouseOver = new RayTraceResult(this.pointedEntity, vec3d3);

	                    if (this.pointedEntity instanceof EntityLivingBase || this.pointedEntity instanceof EntityItemFrame)
	                    {
	                       Minecraft.getMinecraft().pointedEntity = this.pointedEntity;
	                    }
	                }

	                Minecraft.getMinecraft().mcProfiler.endSection();
	            }
	        }
	    
	if (!world.isRemote) {
		BlockPos breakPos =new BlockPos(entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d);
		IBlockState b = Blocks.STONE.getDefaultState();
		world.setBlockState(breakPos, b);
		
		EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, breakPos.getX(),breakPos.getY(), breakPos.getZ(), b );
		 //EntityTNTPrimed entityfallingblock = new EntityTNTPrimed(world, entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d,null);
		 //EntityCow entityfallingblock = new EntityCow(world);
		  
		 
		 //EntityFireShot entityfallingblock = new EntityFireShot(world, entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d);
		System.out.println(entityplayer.getRotatedYaw(Rotation.NONE));
		int power = 2;
		float yaw = entityplayer.getRotatedYaw(Rotation.CLOCKWISE_90);
		float pitch = entityplayer.getPitchYaw().x;
		double v1 = Math.sin(yaw*(Math.PI/180))*power;
		double v2 = Math.cos(yaw*(Math.PI/180))*power;
		double v3 =Math.sin(pitch*(Math.PI/180)*-1)*power;
		entityfallingblock.motionX=v2;
		entityfallingblock.motionY=v3;
		entityfallingblock.motionZ=v1;
		world.spawnEntity(entityfallingblock);
			
		//world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), 0.0, 0.0,0.01 , 100); //make fier stot
		//EntityFireShot entityFireShot = new EntityFireShot(world, entityplayer);
		//entityFireShot.setHeadingFromThrower(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, 1.5F, 1.0F);
       // world.spawnEntity(entityFireShot);
		 
		//player.attackEntityFrom(DamageSource.OUT_OF_WORLD, 1);
		//EntityRenderer t = new  EntityRenderer(null, resourceManagerIn);
		//t.getMouseOver(0);
		
		//Entity target =   Minecraft.getMinecraft().pointedEntity;
		
		//EntityLivingBase l= (EntityLivingBase) target;
		//System.out.println(l);
		//System.out.println(l.getHealth());
       
		/*double d0 = entityplayer.getDistanceSq(target.posX, target.getEntityBoundingBox().minY, target.posZ);
		EntityFallingBlock entityarrow = new EntityFallingBlock(entityplayer.world, entityplayer.getPosition().getX()+ 0.5d,entityplayer.getPosition().getY()+ 0.5d, entityplayer.getPosition().getZ()+ 0.5d, Blocks.STONE.getDefaultState() );
		//EntityArrow entityarrow = new EntityTippedArrow(world, entityplayer);
       // double d0 = target.posX - entityplayer.posX;
       // double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 2.0F) - entityarrow.posY;
       // double d2 = target.posZ - entityplayer.posZ;
       // double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
        //entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 0);
        //entityarrow.shoot(d0, d1, d2, 3f, 0);
        *///this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / ( 0.4F + 0.8F));
       // world.spawnEntity(entityarrow);
		
		
	}
	 
	       

    

	return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, entityplayer.getHeldItem(handIn));
	}

}

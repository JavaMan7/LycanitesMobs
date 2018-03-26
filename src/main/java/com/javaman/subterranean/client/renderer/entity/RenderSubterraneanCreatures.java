package com.javaman.subterranean.client.renderer.entity;



import com.javaman.subterranean.SubterraneanCreaturesMod;
import com.javaman.subterranean.entity.EntityFlailSnail;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderSubterraneanCreatures extends RenderLiving{

	private final ResourceLocation mobTextures;
	//private static final String __OBFID = "CL_00000984";
	
	public RenderSubterraneanCreatures(RenderManager renderManager,ModelBase par1ModelBase, float par2,ResourceLocation resourceLocation) {
		super(renderManager, par1ModelBase, par2);
		this.mobTextures = resourceLocation;
		
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return mobTextures;
	}
	
	

}
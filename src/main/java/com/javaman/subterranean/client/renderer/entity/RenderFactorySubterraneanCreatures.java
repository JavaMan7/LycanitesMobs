package com.javaman.subterranean.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import com.javaman.subterranean.client.renderer.entity.RenderSubterraneanCreatures;
public class RenderFactorySubterraneanCreatures implements IRenderFactory  {
	ModelBase modle;
	ResourceLocation resourceLocation;
	public RenderFactorySubterraneanCreatures(ModelBase modle,ResourceLocation resourceLocation ) {
		this.modle = modle;
		this.resourceLocation = resourceLocation;
		
		
		
		
	}
	@Override
	public Render createRenderFor(RenderManager manager) {
		
		return new RenderSubterraneanCreatures(manager,modle,0,resourceLocation);
		//(RenderManager renderManager,ModelBase par1ModelBase, float par2,ResourceLocation resourceLocation)
	}
	

}

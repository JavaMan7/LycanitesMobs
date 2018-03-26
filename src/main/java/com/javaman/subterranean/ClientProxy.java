package com.javaman.subterranean;

import com.javaman.subteranean.client.render.items.ItemRenderRegister;
import com.javaman.subterranean.client.renderer.entity.EntityRenderRegister;

//import com.javaman.subteranean.client.render.blocks.BlockRenderRegister;
//import com.javaman.subteranean.client.render.items.ItemRenderRegister;
//import com.javaman.subterranean.client.renderer.entity.EntityRenderRegister;
//import com.javaman.subterranean.client.renderer.entity.RenderFireToad;
//import com.javaman.subterranean.entity.EntityFireToad;
//import com.javaman.subterranean.models.ModelFireToad;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		//OBJLoader.INSTANCE.addDomain(SubterraneanCreaturesMod.MODID);
		EntityRenderRegister.registerEntityRenderer();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		ItemRenderRegister.registerItemRenderer();
		//BlockRenderRegister.registerBlockRenderer();
	    
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

}

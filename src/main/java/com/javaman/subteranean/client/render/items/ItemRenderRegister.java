package com.javaman.subteranean.client.render.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.javaman.subteranean.items.ModItems;
import com.javaman.subterranean.SubterraneanCreaturesMod;

public final class ItemRenderRegister {

	public static void registerItemRenderer() {
		
		reg(ModItems.SUBTERRANEAN_ITEMS);
		
				
	}

	//==========================================================================

	public static String modid = SubterraneanCreaturesMod.MODID;

	public static void reg(HashMap<String,Item> m) {
		
		
	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		 Set set = m.entrySet();
	      Iterator iterator = set.iterator();

			while(iterator.hasNext()) {
		         Map.Entry  item = (Map.Entry)iterator.next();
		         
		       //  if(item instanceof Item) {
		         
		         Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register((Item) item.getValue(), 0, new ModelResourceLocation(((Item) item.getValue()).getRegistryName(), "inventory"));
		         
		        // }
			
		}
		
	}
}

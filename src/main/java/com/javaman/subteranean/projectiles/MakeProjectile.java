package com.javaman.subteranean.projectiles;




import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;



public class MakeProjectile {
	
	public static void mainRegistry(){
		registerEntity();
	}
	
	public static void registerEntity(){
		createEntity();


		
	}
	
	public static void createEntity(){
		
		int randomId = 5000000;
		EntityRegistry.registerModEntity(null, EntityFireShot.class, "Throwing Rock", randomId, SubterraneanCreaturesMod.MODID, 64, 10, true);

		
	}
	
	

}
package com.javaman.subterranean;

//import com.javaman.subterranean.dimension.ModWorldGen;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = SubterraneanCreaturesMod.MODID, version = SubterraneanCreaturesMod.VERSION)
public class SubterraneanCreaturesMod
{
    public static final String MODID = "subterranean_creatures_mod";
    public static final String VERSION = "1.5";
    @Instance
    public static SubterraneanCreaturesMod instance = new SubterraneanCreaturesMod();//this instance is used by forge to communicate with are class
    @SidedProxy(clientSide="com.javaman.subterranean.ClientProxy",
			serverSide="com.javaman.subterranean.ServerProxy")
    
public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	this.proxy.preInit(e);//call Common Proxy
    	
    }
    @EventHandler
    public void init(FMLInitializationEvent e)
    {	this.proxy.init(e);
    	
		// some example code
    	//GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
        System.out.println("SubterraneanCreaturesMod >> They lurk in the Deep");
    }
    

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	this.proxy.postInit(e);
    }
}

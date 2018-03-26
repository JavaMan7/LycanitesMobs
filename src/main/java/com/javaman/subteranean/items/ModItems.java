package com.javaman.subteranean.items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import java.util.HashMap;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {

	
	public static final HashMap<String,Item> SUBTERRANEAN_ITEMS = new HashMap<String,Item>();
	
	public static void registerTtem(Item item){
		SUBTERRANEAN_ITEMS.put(item.getUnlocalizedName(), item);
		
		
		
		
		
		
	}
	
	
	public static void addItem()
	{	
		
		
		
		
		
		
		registerTtem(FIRE_STAFF);
		registerTtem(ESSENCE_OF_LIFE_DRAIN);
		registerTtem(TRANS_DIMENSIONAL_ORB);
		registerTtem(FLAIL_SHELL_FRAGMENT);
		registerTtem(FIRE_TOAD_GLAND);
		registerTtem(LIFE_DRAI_CRYSTAL);
		registerTtem(WRAITH_SWORD);
		
		
		registerTtem(FLAIL_SNAIL_SHELL_HELEMET);
		registerTtem(FLAIL_SNAIL_SHELL_CHESTPLATE);
		registerTtem(FLAIL_SNAIL_SHELL_LEGGINGS);
		registerTtem(FLAIL_SNAIL_SHELL_BOOTS);
		
		
	}
		
		public static FireStaff FIRE_STAFF = new FireStaff();
		public static EssenceOfLifeDrain ESSENCE_OF_LIFE_DRAIN = new EssenceOfLifeDrain();
		public static TransDimensionalOrb TRANS_DIMENSIONAL_ORB = new TransDimensionalOrb();
		public static FlailShellFragment FLAIL_SHELL_FRAGMENT = new FlailShellFragment();
		public static FireToadGland FIRE_TOAD_GLAND = new FireToadGland();
		public static LifeDrainCrystal LIFE_DRAI_CRYSTAL = new LifeDrainCrystal();
		public static WraithSword WRAITH_SWORD = new WraithSword();
		
		
		public static ItemArmor FLAIL_SNAIL_SHELL_HELEMET= new FlailSnailArmor("flail_snail_shell_helmet", 1,EntityEquipmentSlot.HEAD);
		public static ItemArmor FLAIL_SNAIL_SHELL_CHESTPLATE = new FlailSnailArmor("flail_snail_shell_chestplate",1, EntityEquipmentSlot.CHEST);
		public static ItemArmor FLAIL_SNAIL_SHELL_LEGGINGS = new FlailSnailArmor("flail_snail_shell_leggings",2, EntityEquipmentSlot.LEGS);
		public static ItemArmor FLAIL_SNAIL_SHELL_BOOTS = new FlailSnailArmor("flail_snail_shell_boots",1, EntityEquipmentSlot.FEET);
		
		
		
		
		
	

}

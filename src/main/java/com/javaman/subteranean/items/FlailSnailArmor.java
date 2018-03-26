package com.javaman.subteranean.items;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class FlailSnailArmor extends ItemArmor {
	private String textureName = "flail_snail_shell";
	public  static ArmorMaterial FlailSnailShell=  EnumHelper.addArmorMaterial("flail_snail_shell", SubterraneanCreaturesMod.MODID+":"+"flail_snail_shell", 33, new int[] {3, 8, 6, 3}, 1,  SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0);
	public FlailSnailArmor(String textureName, int renderIndex, EntityEquipmentSlot type) {
	    super(FlailSnailShell, renderIndex, type);
	   
	   // this.textureName = textureName;
	    this.setUnlocalizedName(textureName);
	    this.setRegistryName(SubterraneanCreaturesMod.MODID, textureName);
	
	   
	}
	//@Override
	//public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	//{
	 //   return SubterraneanCreaturesMod.MODID + ":armor/" + this.textureName  + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	//}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
	//if (player.getArmorInventoryList(). != null && ((Object) player).getCurrentArmor(1).getItem() == ModItems.FlailSnailShellChestplate);
	  //  player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 40));
	    
	    
	   
	}
	
	  public ItemStack getRepairItemStack()
      {
          
          return new ItemStack(ModItems.FLAIL_SHELL_FRAGMENT);
      }
	
	
}
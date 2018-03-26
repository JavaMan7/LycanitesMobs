

package com.javaman.subterranean.WorldGen;

import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import com.javaman.subterranean.SubterraneanCreaturesMod;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTableList;

public class SubWorldGenTower extends WorldGenerator {
	 Random r2 =new Random();
	// ResourceLocation template;
	//public SubWorldGen(ResourceLocation Template) {
		
		
		//this.template = ;
		
		
		
	//}
  
    int r;
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		WorldServer worldserver = (WorldServer) world;
		MinecraftServer minecraftserver = world.getMinecraftServer();
		TemplateManager templatemanager = worldserver.getStructureTemplateManager();
		Template towerp1 = templatemanager.getTemplate(minecraftserver, new ResourceLocation(SubterraneanCreaturesMod.MODID+":tower_p1"));
		Template towerp2 = templatemanager.getTemplate(minecraftserver, new ResourceLocation(SubterraneanCreaturesMod.MODID+":tower_p2"));
		Template tower_bed = templatemanager.getTemplate(minecraftserver, new ResourceLocation(SubterraneanCreaturesMod.MODID+":tower_bed"));
		Template tower_book = templatemanager.getTemplate(minecraftserver, new ResourceLocation(SubterraneanCreaturesMod.MODID+":tower_book"));
		Template tower_lab = templatemanager.getTemplate(minecraftserver, new ResourceLocation(SubterraneanCreaturesMod.MODID+":tower_lab"));
		Template tower_mu = templatemanager.getTemplate(minecraftserver, new ResourceLocation(SubterraneanCreaturesMod.MODID+":tower_mu"));
		
		if(towerp1 == null)
		{
			System.out.println("NO STRUCTURE");
			return false;
		}
		
		if(ModWorldGenerator.canSpawnHere(towerp1, worldserver, position)) {
			IBlockState iblockstate = world.getBlockState(position);
			
			world.notifyBlockUpdate(position, iblockstate, iblockstate, 3);
			
			PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
					.setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null)
					.setReplacedBlock((Block) null).setIgnoreStructureBlock(false);
			
			towerp1.getDataBlocks(position, placementsettings);
			towerp1.addBlocksToWorld(world, position.add(0, 1, 0), placementsettings);
			towerp2.addBlocksToWorld(world, position.add(0, 33, 0), placementsettings);
			
			tower_bed.addBlocksToWorld(world, position.add(17, 29, 17), placementsettings);
			tower_book.addBlocksToWorld(world, position.add(-7, 29, 17), placementsettings);
			tower_lab.addBlocksToWorld(world, position.add(-7, 29, -7), placementsettings);
			tower_mu.addBlocksToWorld(world, position.add(17, 29, -7), placementsettings);
			
			 Map<BlockPos, String> map = towerp1.getDataBlocks( position.add(0, 1, 0), placementsettings);
			 Map<BlockPos, String> map2 = towerp2.getDataBlocks(position.add(0, 33, 0), placementsettings);
			 Map<BlockPos, String> map3 = tower_book.getDataBlocks(position.add(17, 29, 17), placementsettings);
			 Map<BlockPos, String> map4 = tower_lab.getDataBlocks(position.add(-7, 29, -7), placementsettings);
			 Map<BlockPos, String> map5 = tower_mu.getDataBlocks(position.add(17, 29, -7), placementsettings);
			 Map<BlockPos, String> map6 = tower_bed.getDataBlocks( position.add(17, 29, 17), placementsettings);
			 
			 addLoot(map,world,rand);
			 addLoot(map2,world,rand);
			 addLoot(map3,world,rand);
			 addLoot(map4,world,rand);
			 addLoot(map5,world,rand);
			 addLoot(map6,world,rand);
	        
	         
	     
			return true;
		}
		
		return false;
	}
	
	
	public void addLoot(Map<BlockPos, String> map,World world ,Random rand) {
		 for (Entry<BlockPos, String> entry : map.entrySet())
         {
             if ("chest".equals(entry.getValue()))
             {
                 BlockPos blockpos2 = entry.getKey();
                 world.setBlockState(blockpos2, Blocks.AIR.getDefaultState(), 3);
                 TileEntity tileentity = world.getTileEntity(blockpos2.down());

                 if (tileentity instanceof TileEntityChest)
                 {
                     ((TileEntityChest)tileentity).setLootTable(LootTableList.ENTITIES_WITCH, rand.nextLong());
                 }
             }
             if ("br".equals(entry.getValue()))
             {
                 BlockPos blockpos2 = entry.getKey();
                 world.setBlockState(blockpos2, Blocks.AIR.getDefaultState(), 3);
                 TileEntity tileentity = world.getTileEntity(blockpos2.down());
                 
                 if (tileentity instanceof TileEntityBrewingStand)
                 {
                	
                	 int i  =1+r2.nextInt(3);
                	 
                	 for (int j=0;j<i;j++) {
                		 
                		
                		 r = r2.nextInt(9);
                		
                		 ItemStack pot=null;
                	 switch(r) {
                	 case 0:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.STRONG_HEALING);}
                	 break;
                	 
                	 case 1:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.LONG_FIRE_RESISTANCE);}
                	 break;
                	 
                	 case 2:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.LONG_LEAPING);}
                	 break;
                	 
                	 case 3:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.STRONG_HARMING);}
                	 break;
                	 
                	 
                	 case 4:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.STRONG_STRENGTH);}
                	 break;
                	 
                	 case 5:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.STRONG_SWIFTNESS);};
                	 
                	 case 6:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.LONG_WATER_BREATHING);}
                	 break;
                	 
                	 case 7:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.LONG_REGENERATION);}
                	 break;
                	 
                	 case 8:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.STRONG_POISON);}
                	 break;
                	 
                	 case 9:{pot = new ItemStack(Items.POTIONITEM);PotionUtils.addPotionToItemStack(pot, PotionTypes.LONG_NIGHT_VISION);}
                	 break;
                	 
                	 
                	 
             
                	 }
                	 
                	 ((TileEntityBrewingStand)tileentity).setInventorySlotContents(j,pot);
                	 }
                 }
                	 
                     
                 }
             }
		
		
		
		
	}
	
}
package lycanite.lycanitesmobs.arcticmobs.item;

import lycanite.lycanitesmobs.core.entity.EntityProjectileBase;
import lycanite.lycanitesmobs.core.item.ItemCharge;
import lycanite.lycanitesmobs.arcticmobs.ArcticMobs;
import lycanite.lycanitesmobs.arcticmobs.entity.EntityBlizzard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlizzardCharge extends ItemCharge {

	// ==================================================
	//                   Constructor
	// ==================================================
    public ItemBlizzardCharge() {
        super();
        this.group = ArcticMobs.group;
        this.itemName = "blizzardcharge";
        this.setup();
    }
    
    
    // ==================================================
 	//                    Item Use
 	// ==================================================
    @Override
    public EntityProjectileBase getProjectile(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        return new EntityBlizzard(world, entityPlayer);
    }
}

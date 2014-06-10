package lycanite.lycanitesmobs.api.render;

import lycanite.lycanitesmobs.AssetManager;
import lycanite.lycanitesmobs.api.entity.EntityCreatureBase;
import lycanite.lycanitesmobs.api.entity.EntityCreatureRideable;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCreature extends RenderLiving {
	
	/** A color table for mobs that can be dyed or pet collars. Follows the same pattern as the vanilla sheep. */
	public static final float[][] colorTable = new float[][] {{1.0F, 1.0F, 1.0F}, {0.85F, 0.5F, 0.2F}, {0.7F, 0.3F, 0.85F}, {0.4F, 0.6F, 0.85F}, {0.9F, 0.9F, 0.2F}, {0.5F, 0.8F, 0.1F}, {0.95F, 0.5F, 0.65F}, {0.3F, 0.3F, 0.3F}, {0.6F, 0.6F, 0.6F}, {0.3F, 0.5F, 0.6F}, {0.5F, 0.25F, 0.7F}, {0.2F, 0.3F, 0.7F}, {0.4F, 0.3F, 0.2F}, {0.4F, 0.5F, 0.2F}, {0.6F, 0.2F, 0.2F}, {0.1F, 0.1F, 0.1F}};
    
    // ==================================================
  	//                    Constructor
  	// ==================================================
    public RenderCreature(String setEntityName) {
    	super(AssetManager.getModel(setEntityName), 0.5F);
    	this.setRenderPassModel(AssetManager.getModel(setEntityName));
    }
    
    
    // ==================================================
 	//                  Render Equipment
 	// ==================================================
    @SuppressWarnings("unused") //TODO Collar textures.
	protected int shouldRenderPass(EntityLivingBase entity, int renderPass, float partialTick) {
    	if(!(entity instanceof EntityCreatureBase))
    		return -1;
    	EntityCreatureBase creature = (EntityCreatureBase)entity;
    	
    	// Chest/Body Armor First:
    	if(renderPass == 0 && creature.getEquipmentName("chest") != null) {
			this.bindEquipmentTexture(entity, creature.getEquipmentName("chest"));
    		return 1;
    	}
    	
    	// Saddle Second:
    	if(renderPass == 1 && creature instanceof EntityCreatureRideable)
    		if(((EntityCreatureRideable)creature).hasSaddle()) {
    			this.bindEquipmentTexture(entity, "saddle");
    			return 1;
    		}
    	
    	// Feet/Collar/Color Third:
    	if(renderPass == 2) {
    		if(creature.canBeColored(null) && false) {
    			this.bindEntityTexture(entity);
    			int colorID = 0;
    			if(entity instanceof EntityCreatureBase)
    				colorID = ((EntityCreatureBase)entity).getColor();
    			GL11.glColor3f(colorTable[colorID][0], colorTable[colorID][1], colorTable[colorID][2]);
    			// Future collar texture overlays can be added here and should be colored.
    			return 1;
    		}
    		else if(creature.getEquipmentName("feet") != null) {
				this.bindEquipmentTexture(entity, creature.getEquipmentName("feet"));
	    		return 1;
    		}
    	}
    	
    	// Helm Fourth:
    	if(renderPass == 3 && creature.getEquipmentName("head") != null) {
			this.bindEquipmentTexture(entity, creature.getEquipmentName("head"));
    		return 1;
    	}
    	
    	return -1;
    }
    
    
    // ==================================================
 	//                     Visuals
 	// ==================================================
    // ========== Main ==========
    @Override
    protected void bindEntityTexture(Entity entity) {
        this.bindTexture(this.getEntityTexture(entity));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
    	if(entity instanceof EntityCreatureBase)
    		return ((EntityCreatureBase)entity).getTexture();
        return null;
    }
    
    // ========== Equipment ==========
    protected void bindEquipmentTexture(Entity entity, String equipmentName) {
        this.bindTexture(this.getEquipmentTexture(entity, equipmentName));
    }
    
    protected ResourceLocation getEquipmentTexture(Entity entity, String equipmentName) {
    	if(entity instanceof EntityCreatureBase)
    		return ((EntityCreatureBase)entity).getEquipmentTexture(equipmentName);
        return null;
    }
    
    // ========== Bind ==========
    @Override
    protected void bindTexture(ResourceLocation texture) {
    	if(texture != null)
    		this.renderManager.renderEngine.bindTexture(texture);
    }
    
    
    // ==================================================
  	//                     Effects
  	// ==================================================
    @Override
    protected void preRenderCallback(EntityLivingBase entity, float particleTickTime) {
        // No effects.
    }
}

package com.lycanitesmobs.core.info;

import com.google.gson.JsonObject;
import com.lycanitesmobs.core.helpers.JSONHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

/** Elements affect what buffs and debuffs a creature has in addition to some strengths and weaknesses and fusion. **/
public class ElementInfo {

	/** The name of this element. **/
	public String name;

	/** The names of elements that make up this elements, used by compound elements. **/
	protected List<String> componentNames = new ArrayList<>();

	/** The elements that make up this elements, used by compound elements. This is populated from the component names list once all elements are loaded. **/
	public List<ElementInfo> components = new ArrayList<>();

	/** The type of this element, can be primal or compound. Default: Automatic (primal if no components, compound if there are components.) **/
	public String type;

	/** A list of beneficial potion effects that this element can grant. **/
	public List<String> buffs = new ArrayList<>();

	/** A list of detrimental potion effects that this element can inflict as well as grant immunity to. **/
	public List<String> debuffs = new ArrayList<>();

	/** Whether creatures of this element are able to burn by default. Some creatures will override this with their own settings. **/
	public boolean canBurn = true;

	/** Whether creatures of this element are able to freeze by default. Some creatures will override this with their own settings. **/
	public boolean canFreeze = true;


	/** Loads this element from a JSON object. **/
	public void loadFromJSON(JsonObject json) {
		if(json.has("name"))
			this.name = json.get("name").getAsString();

		if(json.has("components"))
			this.componentNames = JSONHelper.getJsonStrings(json.get("components").getAsJsonArray());

		if(json.has("type"))
			this.type = json.get("type").getAsString();
		else this.type = this.componentNames.isEmpty() ? "primal" : "compound";

		if(json.has("buffs"))
			this.buffs = JSONHelper.getJsonStrings(json.get("buffs").getAsJsonArray());

		if(json.has("debuffs"))
			this.debuffs = JSONHelper.getJsonStrings(json.get("debuffs").getAsJsonArray());

		if(json.has("canBurn"))
			this.canBurn = json.get("canBurn").getAsBoolean();

		if(json.has("canFreeze"))
			this.canFreeze = json.get("canFreeze").getAsBoolean();
	}


	/** Initialises this Element, called once all Elements have been loaded. **/
	public void init() {
		// Compound components:
		if(this.type.equalsIgnoreCase("compound")) {
			for(String componentName : this.componentNames) {
				if(ElementManager.getInstance().elements.containsKey(componentName)) {
					this.components.add(ElementManager.getInstance().elements.get(componentName));
				}
			}
		}
	}


	/**
	 * Applies buffs to the target entity based on this element.
	 * @param targetEntity The entity to buffs.
	 * @param duration The duration of the buffs.
	 * @param amplifier The amplifier of the buffs.
	 */
	public void buffEntity(EntityLivingBase targetEntity, int duration, int amplifier) {
		for(String buff : this.buffs) {
			Potion potion = GameRegistry.findRegistry(Potion.class).getValue(new ResourceLocation(buff));
			if(potion != null) {
				targetEntity.addPotionEffect(new PotionEffect(potion, duration, amplifier));
			}
		}
	}


	/**
	 * Applies debuffs to the target entity based on this element.
	 * @param targetEntity The entity to debuffs.
	 * @param duration The duration of the debuffs.
	 * @param amplifier The amplifier of the debuffs.
	 */
	public void debuffEntity(EntityLivingBase targetEntity, int duration, int amplifier) {
		for(String debuff : this.debuffs) {
			if("burning".equalsIgnoreCase(debuff)) {
				targetEntity.setFire(duration * 20);
				continue;
			}
			Potion potion = GameRegistry.findRegistry(Potion.class).getValue(new ResourceLocation(debuff));
			if(potion != null) {
				targetEntity.addPotionEffect(new PotionEffect(potion, duration, amplifier));
			}
		}
	}


	/**
	 * Returns if a creature of this element can be affected by the provided effect.
	 * @param effect The effect to check.
	 * @return True if the effect can be applied.
	 */
	public boolean isEffectApplicable(PotionEffect effect) {
		if(this.debuffs.isEmpty())
			return true;
		return !this.debuffs.contains(effect.getPotion().getRegistryName().toString());
	}


	/**
	 * Returns if creatures of this element can burn by default. (Fire damage).
	 * @return True if can burn.
	 */
	public boolean canBurn() {
		return this.canBurn;
	}


	/**
	 * Returns if creatures of this element can freeze by default. (Ooze damage).
	 * @return True if can burn.
	 */
	public boolean canFreeze() {
		return this.canFreeze;
	}
}

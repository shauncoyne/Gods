package com.CS4398.spc51.gods.reward;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Gods;

/**
 * The Class FlyingBoots.
 */
public class FlyingBoots extends EnchantedBoots {
	
	/**
	 * Instantiates new enchanted diamond boots.
	 * The enchantment is the ability to fly.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public FlyingBoots(Player player, String message, ItemStack item) {
		super(player, message, item);
		execute();
	}
	
	/**
	 * Execute flying ability.
	 *
	 * @return true, if successful
	 * 
	 */
	@Override
	public boolean execute() {

		try {
		    player.setAllowFlight(!player.getAllowFlight());
		    return true;
		} 
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}
}

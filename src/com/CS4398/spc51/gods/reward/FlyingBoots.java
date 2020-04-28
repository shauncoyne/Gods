package com.CS4398.spc51.gods.reward;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Gods;

/**
 * The Class FlyingBoots.
 */
public class FlyingBoots extends EnchantedBoots {
	
	/**
	 * Instantiates new boots that allows the player to fly.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public FlyingBoots(Player player, String message, ItemStack item) {
		super(player, message, item);
		fly();
	}
	
	/**
	 * Execute flying ability.
	 *
	 * @return true, if successful
	 */
	public boolean fly() {
		
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

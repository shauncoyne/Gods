package com.CS4398.spc51.gods.reward;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Gods;

/** 
 * The Class InvisibilityHelmet. 
 */
public class InvisibilityHelmet extends EnchantedHelmet {

	/**
	 * Instantiates a new helmet that makes the player invisible.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public InvisibilityHelmet(Player player, String message, ItemStack item) {
		super(player, message, item);
		bye();
	}
	
	/**
	 * Execute invisibility.
	 * 
	 * @return true, if successful
	 */
	@SuppressWarnings("deprecation")
	public boolean bye() {
		try {
			for(Player everyone : Bukkit.getOnlinePlayers()) {
				if(player != everyone)
					everyone.hidePlayer(player);
			}
			return true;
		}
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
	}
}

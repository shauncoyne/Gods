package com.CS4398.spc51.gods.reward;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Gods;

/** 
 * The Class ScubaHelmet. 
 */
public class ScubaHelmet extends EnchantedHelmet {
	
	/**
	 * Instantiates a new helmet that allows the player to breathe underwater.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public ScubaHelmet(Player player, String message, ItemStack item) {
		super(player, message, item);
		execute();
	}
	
	/**
	 * Execute underwater breathing.
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean execute() {
		try {
			player.setMaximumAir(1200); // 20 ticks/second
			return true;
		}
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
	}
}

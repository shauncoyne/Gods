package com.CS4398.spc51.gods.reward;

import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.Gods;

/** 
 * The Class Invisibility. 
 */
public class Invisibility extends Reward {

	/**
	 * Instantiates an invisibility reward.
	 * 
	 * @param player the player
	 * @param message the message
	 * 
	 */
	public Invisibility(Player player, String message) {
		super(player, message);
	}
	
	/**
	 * Execute invisibility.
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean execute() {
		try {
			player.hidePlayer(player); // ??? I'll have to fix this
			return true;
		}
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
	}
}

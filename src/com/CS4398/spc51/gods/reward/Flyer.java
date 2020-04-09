/*
 * 
 */
package com.CS4398.spc51.gods.reward;

import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.Gods;

// TODO: Auto-generated Javadoc
/** 
 * The Class Flyer.
 */
public class Flyer extends Reward {

	/**
	 * Instantiates a new flying reward.
	 *
	 * @param player the player
	 * @param message the message
	 * 
	 */
	public Flyer(Player player, String message) {
		super(player, message);
	}
	
	/**
	 * Execute the flying reward.
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

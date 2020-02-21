package com.CS4398.spc51.gods.reward;

import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.CommandManager;

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
	 * Enables or Disables the player's ability to fly
	 */
	public void tryToFly() {
		if(player.getAllowFlight() == true) {
			player.setAllowFlight(false);	// Flying Disabled
		} 
		else {
			player.setAllowFlight(true);	// Flying Enabled
		}
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
		    tryToFly();
		    return true;
		} 
		catch (Exception e) {
			CommandManager.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}
}

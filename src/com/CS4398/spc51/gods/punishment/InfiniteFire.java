package com.CS4398.spc51.gods.punishment;

import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.CommandManager;

/**
 * The Class InfiniteFire.
 */
public class InfiniteFire extends Punishment {
	
	/**
	 * Instantiates a new fire punishment.
	 *
	 * @param player the player
	 * @param message the message
	 */
	public InfiniteFire(Player player, String message) {
		super(player, message);
	}
	
	/**
	 * Execute the fire punishment.
	 *
	 * @return true, if successful
	 * 
	 */
	@Override
	public boolean execute() {

		try {
		    player.setFireTicks(0); // having a parameter of 0 should set the player on fire forever?
		    return true;
		} 
		catch (Exception e) {
			CommandManager.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

/*
 * 
 */
package com.CS4398.spc51.gods.punishment;

import org.bukkit.entity.Player;
 
import com.CS4398.spc51.gods.Gods;

// TODO: Auto-generated Javadoc
/**
 * The Class Death.
 */
public class Death extends Punishment {
	
	/**
	 * Instantiates a new death punishment.
	 * 
	 * @param player the player
	 * @param message the message
	 * 
	 */
	public Death(Player player, String message) {
		super(player, message);
	}
	
	/**
	 * Execute the death punishment to kill a player.
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean execute() {
		try {
			player.setHealth(0.0D);
			return true;
		}
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
	}
}

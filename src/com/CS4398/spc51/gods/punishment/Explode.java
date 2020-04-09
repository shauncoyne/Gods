/*
 * 
 */
package com.CS4398.spc51.gods.punishment;

import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.Gods;

// TODO: Auto-generated Javadoc
/**
 * The Class Explode.
 */
public class Explode extends Death {
	
	/**  The power of the explosion. */
	float explosionPower;
	
	/**
	 * Instantiates a new explosion.
	 * 
	 * @param player the player
	 * @param message the message
	 * 
	 */
	public Explode(Player player, String message) {
		super(player, message);
		explosionPower = 4F;	// TNT explosions are 4F by default
	}
	
	/**
	 * Execute the punishment to kill a player with an explosion.
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean execute() {
		try {
			player.getWorld().createExplosion(player.getLocation(), explosionPower);
			player.setHealth(0.0D);
			return true;
		}
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
	}
}

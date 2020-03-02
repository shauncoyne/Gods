/*
 * 
 */
package com.CS4398.spc51.gods.reward;

import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.Gods;

// TODO: Auto-generated Javadoc
/** 
 * The Class LightningAttack. 
 */
public class LightningAttack extends Reward {

	/**
	 * Instantiates a lightning attack reward.
	 * 
	 * @param player the player
	 * @param message the message
	 * 
	 */
	public LightningAttack(Player player, String message) {
		super(player, message);
	}
	
	/**
	 * Execute a strike of lightning on an enemy.
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean execute() {
		try {
			player.getWorld().strikeLightning(player.getLocation());
			player.setHealth(0.0D);
			return true;
		}
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
	}
}

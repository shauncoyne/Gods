package com.CS4398.spc51.gods.punishment;

import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.Gods;

/** 
 * The Class LightningAttack. 
 */
public class LightningAttack extends Punishment {

	/**
	 * Instantiates a lightning attack punishment.
	 * 
	 * @param player the player
	 * @param message the message
	 */
	public LightningAttack(Player player, String message) {
		super(player, message);
	}
	
	/**
	 * Executes a strike of lightning on the player.
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

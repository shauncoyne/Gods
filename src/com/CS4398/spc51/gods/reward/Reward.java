package com.CS4398.spc51.gods.reward;

import org.bukkit.entity.Player;


/**
 * The Class Reward.
 */
public abstract class Reward {
	
	/** The player that will receive the reward. */
	Player player; 
	
	/**  The message that will be sent to the player when the reward is executed. */
	String message; 
	
	/**
	 * Instantiates a new reward.
	 *
	 * @param player the player
	 * @param message the message
	 */
	public Reward(Player player, String message) {
		this.player = player;
		this.message = message;
	}
	
	/**
	 * Execute the reward.
	 *
	 * @return true, if successful
	 */
	public boolean execute() {
		return false;
	}
	
	/**
	 * Send the reward message to the player.
	 */
	public void sendMessage() {
		player.sendMessage(message);
	}


}

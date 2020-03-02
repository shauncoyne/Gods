/*
 * 
 */
package com.CS4398.spc51.gods.punishment;

import org.bukkit.entity.Player;

// TODO: Auto-generated Javadoc
/**
 * @author Shaun Coyne (spc51)
 * The Class Punishment.
 */
public abstract class Punishment {
	
	/** The player that will receive the punishment. */
	Player player;
	
	/**  The message that will be sent to the player when the punishment is executed. */
	String message;
	
	/**
	 * Instantiates a new punishment.
	 *
	 * @param player the player
	 * @param message the message
	 */
	public Punishment(Player player, String message) {
		this.player = player;
		this.message = message;
	}
	
	/**
	 * Execute the punishment.
	 *
	 * @return true, if successful
	 * 
	 */
	public boolean execute() {
		return false;
	}
	
	/** 
	 * Send the punishment message to the player.
	 */
	public void sendMessage() {
		player.sendMessage(message);
	}

}

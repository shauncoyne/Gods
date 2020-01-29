package com.CS4398.spc51.gods.punishment;

import org.bukkit.entity.Player;

/**
 * The Class Punishment.
 */
public abstract class Punishment {
	
	/**
	 * Instantiates a new punishment.
	 *
	 * @param p the p
	 */
	public Punishment(Player p) {
	}
	
	/**
	 * Execute teh punishment.
	 *
	 * @return true, if successful
	 */
	public boolean execute() {
		return false;
	}

}

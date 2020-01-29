package com.CS4398.spc51.gods;

import java.util.UUID;

import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.gods.God;


/**
 * The Class Believer.
 */
public class Believer {
	
	/** The belief power. */
	private float beliefPower;
	
	/** The player UUID. */
	private UUID playerUUID;
	
	/**
	 * Instantiates a new believer.
	 *
	 * @param player the player
	 */
	public Believer(Player player) {
		beliefPower = 0f;
		this.playerUUID = player.getUniqueId();
	}
	
	/**
	 * Instantiates a new believer.
	 *
	 * @param player the player
	 * @param beliefPower the belief power
	 */
	public Believer(Player player, int beliefPower) {
		this.beliefPower = beliefPower;
		this.playerUUID = player.getUniqueId();
	}
	
	/**
	 * Gets the belief power.
	 *
	 * @return the belief power
	 */
	public float getBeliefPower() {
		return beliefPower;
	}

	/**
	 * Sets the belief power.
	 *
	 * @param beliefPower the new belief power
	 */
	public void setBeliefPower(float beliefPower) {
		this.beliefPower = beliefPower;
	}
	
	/**
	 * Increase belief power by loading the multiplier
	 * from the config, then multiplying that by the level
	 * and adding it to the current belief power.
	 *
	 * @param god the god
	 * @param level the level
	 */
	public void increaseBeliefPower(God god, int level) {
		float multiplyer = Gods.configurator.getMultiplyer(god);
		beliefPower = beliefPower + level * multiplyer;		
	}
	
	/**
	 * Decrease belief power by loading the multiplier
	 * from the config, then multiplying that by the level
	 * and subtracting it from the current belief power.
	 * @param god the god
	 * @param level the level
	 */
	public void decreaseBeliefPower(God god, int level) {
		float multiplyer = Gods.configurator.getMultiplyer(god);
		beliefPower = beliefPower - level * multiplyer;		
	}

}

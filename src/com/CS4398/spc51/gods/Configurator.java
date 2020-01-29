package com.CS4398.spc51.gods;

import org.bukkit.configuration.file.FileConfiguration;

import com.CS4398.spc51.gods.gods.God;

/**
 * The Class Configurator.
 */
public class Configurator {
	
	/** The gods. */
	private Gods gods;
	
	/** The config. */
	private FileConfiguration config = gods.getConfig();
	
	/**
	 * Instantiates a new configurator.
	 *
	 * @param gods the gods
	 */
	public Configurator(Gods gods) {
		this.gods = gods;
	}
	
	/**
	 * Save config.
	 */
	public void saveConfig() {
		gods.saveDefaultConfig();
	}
	
	/**
	 * Reload.
	 */
	public void reload() {
		gods.getConfig();
		gods.getLogger().info("Config reloaded!");
	}

	/**
	 * Gets the multiplyer.
	 *
	 * @param god the god
	 * @return the multiplyer
	 */
	public float getMultiplyer(God god) {
		// TODO Auto-generated method stub
		return 0f;
	}

}

/*
 * 
 */
package com.CS4398.spc51.gods;

import org.bukkit.configuration.file.FileConfiguration;

import com.CS4398.spc51.gods.gods.God;

// TODO: Auto-generated Javadoc
/**
 * @author Shaun Coyne (spc51)
 * The Class Configurator.
 */
public class Configurator {
	
	
	/** The config. */
	private FileConfiguration config = null;
	
	/**
	 * Instantiates a new configurator.
	 */
	public Configurator() {
		config = Gods.gods.getConfig();
		config.addDefault("Zeus", 1);
	}
	
	/**
	 * Save config.
	 */
	public void saveConfig() {
		config.options().copyDefaults(true);
		Gods.gods.saveDefaultConfig();
	}
	
	/**
	 * Reload.
	 */
	public void reload() {
		Gods.gods.getConfig();
		Gods.gods.getLogger().info("Config reloaded!");
	}

	/**
	 * Gets the multiplyer.
	 *
	 * @param god the god
	 * @return the multiplyer
	 */
	public float getMultiplyer(God god) {
		if (god.getName().equalsIgnoreCase("Zeus")){
			return config.getInt("Zeus");
		}
		return 0f;
	}

}

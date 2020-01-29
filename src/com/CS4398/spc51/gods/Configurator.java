package com.CS4398.spc51.gods;

import org.bukkit.configuration.file.FileConfiguration;

import com.CS4398.spc51.gods.gods.God;

public class Configurator {
	private Gods gods;
	private FileConfiguration config = gods.getConfig();
	
	public Configurator(Gods gods) {
		this.gods = gods;
	}
	
	public void saveConfig() {
		gods.saveDefaultConfig();
	}
	public void reload() {
		gods.getConfig();
		gods.getLogger().info("Config reloaded!");
	}

	public float getMultiplyer(God god) {
		// TODO Auto-generated method stub
		return 0f;
	}

}

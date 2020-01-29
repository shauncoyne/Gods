package com.CS4398.spc51.gods;

import org.bukkit.plugin.java.JavaPlugin;

public class Gods extends JavaPlugin{
	static Configurator configurator;
	@Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        configurator = new Configurator(this);
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}

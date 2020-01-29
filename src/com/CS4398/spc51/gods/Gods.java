package com.CS4398.spc51.gods;

import org.bukkit.plugin.java.JavaPlugin;

import com.CS4398.spc51.gods.alter.AlterManager;

public class Gods extends JavaPlugin{
	static Configurator configurator;
	@Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        configurator = new Configurator(this);
        getServer().getPluginManager().registerEvents(new AlterManager(), this);
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}

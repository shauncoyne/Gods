package com.CS4398.spc51.gods;

import org.bukkit.plugin.java.JavaPlugin;

import com.CS4398.spc51.gods.alter.AlterManager;

/**
 * The Class Gods.
 */
public class Gods extends JavaPlugin{
	
	/** The configurator. */
	static Configurator configurator;
	
	/**
	 * On enable it notifies the log/console that it has been called
	 * Instantiates the configurator.
	 * Registers the AlterManager with the server.
	 */
	@Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        configurator = new Configurator(this);
        //register the AlterManager
        getServer().getPluginManager().registerEvents(new AlterManager(), this);
        //register the Chat Listener
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        //register Action Listener
        getServer().getPluginManager().registerEvents(new ActionListener(), this);
        // Register Commands
     	getCommand("gods").setExecutor(new CommandManager(this));
    }
    
    /**
     * On disable.
     */
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
        //Need to unregister the listeners
    }
}

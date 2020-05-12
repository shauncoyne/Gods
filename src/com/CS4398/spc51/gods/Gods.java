/*
 * 
 */
package com.CS4398.spc51.gods;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import com.CS4398.spc51.gods.alter.AlterManager;
import com.CS4398.spc51.gods.gods.Atheist;
import com.CS4398.spc51.gods.gods.God;
import com.CS4398.spc51.gods.gods.Hades;
import com.CS4398.spc51.gods.gods.Poseidon;
import com.CS4398.spc51.gods.gods.Zeus;

// TODO: Auto-generated Javadoc
/**
 * @author Shaun Coyne (spc51)
 * The Class Gods.
 */
public class Gods extends JavaPlugin{
	
	/** The configurator. */
	static Configurator configurator;
	
	/** The gods. */
	public static Gods gods;

    /** An array of all the gods that can be iterated through */
    public static God[] all_gods = new God[4];
	
    public Gods()
    {
        super();
    }
	
	protected Gods(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file)
    {
        super(loader, description, dataFolder, file);
    }

	
	/**
	 * On enable it notifies the log/console that it has been called
	 * Instantiates the configurator.
	 * Registers the AlterManager with the server.
	 */
	@Override
    public void onEnable() {
		gods = this;
		all_gods[0] = new Atheist();
        all_gods[1] = new Zeus();
        all_gods[2] = new Poseidon();
        all_gods[3] = new Hades();

        getLogger().info("onEnable is called!");
        configurator = new Configurator();
        //register the AlterManager
        getServer().getPluginManager().registerEvents(new AlterManager(), this);
        //register the Chat Listener
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        //register Action Listener
        getServer().getPluginManager().registerEvents(new ActionListener(), this);
        // Register Commands
     	this.getCommand("gods").setExecutor(new CommandManager());
    }
    
    /**
     * On disable.
     */
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
        //TODO Need to unregister the listeners
        
        Believer.saveAll();
        AlterManager.saveAll();
    }

    public static God getGodFromName(String godName){
        for (God god: all_gods) {
         if (god.getName().equalsIgnoreCase(godName)){
             return god;
            }
        }
        return null;
    }
}

package com.CS4398.spc51.gods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.CS4398.spc51.gods.alter.AlterManager;
import com.CS4398.spc51.gods.gods.God;
import com.CS4398.spc51.gods.powerup.Powerup;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;


/**
 * The Class Believer. 
 * 					TODO this should have a rank, a powerup list,  and a beliefPower.
 * 					TODO on rank increase check to the god to see if we need to update powerup list
 * 					TODO on beliefPower increase check to seee if we need to increase rank
 * 					TODO on beliefPower increase, check god to see if we need to reward the player
 * 					TODO similar logic applies to decreases
 * 					TODO need to add save and load logic to player objects to save and load  them from a yaml
 */
public class Believer implements Listener{
	
	public static int alterBuildingTimeout = 20; //number of seconds alter detection will be on for this player
	
	public static ArrayList<Believer> believerList = new ArrayList<Believer>();
	
	private ArrayList<Powerup> powerupList = new ArrayList<Powerup>();
	
	/** The belief power. This is how much the player has
	 * please their god */
	private float beliefPower;
	/** This is the rank of the player */
	private int rank;
	
	private static Gson gson = new Gson();
	
	/** this is true when the player requests to be in alter building mode. */
	
	/** The player UUID. */
	private UUID playerUUID;
	
	/**  The god the player worships. */
	private God god;
	
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
	public Believer(Player player, float beliefPower) {
		this.beliefPower = beliefPower;
		this.playerUUID = player.getUniqueId();
	}
	/**
	 * Instantiates a new believer.
	 *
	 * @param player the player
	 * @param beliefPower the belief power
	 * @param behavior the behavior score of the player
	 */
	public Believer(Player player, float beliefPower, int rank) {
		this.beliefPower = beliefPower;
		this.playerUUID = player.getUniqueId();
		this.setRank(rank);
	}
	
	public static void loadBeliever(Player player) {
		if (!loadFromJSON(player)) {
			Believer newBeliever = new Believer(player);
			believerList.add(newBeliever);
			//TODO LOG: A player has joined that is not a believer. They must be new! Adding them now.
		}
	}
	

	private static boolean loadFromJSON(Player player) {
		try {
			Believer believer = gson.fromJson(player.getUniqueId() + ".data", Believer.class);
		}
		catch(Exception e) {
			//TODO log error
			return false;
		}
		return true;
	}
	
	private static boolean saveToJson(Believer believer) {
		
	    try {
	        gson.toJson(believer, new FileWriter(Gods.gods.getDataFolder() + File.separator + "believers" + File.separator + believer.getPlayer().getUniqueId() +".data"));
	    } catch (JsonIOException | IOException e) {
	        //TODO log error
	    	return false;
	    }
		return true;
		
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

	/**
	 * Gets the believer.
	 *
	 * @param uniqueId the unique id
	 * @return the believer
	 */
	public static Believer getBeliever(UUID uniqueId) {
		//Returns a believer
		return null;
	}

	/**
	 * Gets the god.
	 *
	 * @return the god
	 */
	public God getGod() {
		//Returns the God this player worships
		return god;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return Bukkit.getPlayer(playerUUID);
		
	}
	
	public void startListeningForAlter() {
		
		BlockListener tempListener = new BlockListener(this);
		tempListener.run();
		
	}

	 private class BlockListener implements Runnable, Listener {
		 	Believer believer;

		    public BlockListener(Believer believer) {
		    	this.believer = believer;
		}
			public void run(){
		       Gods.gods.getServer().getPluginManager().registerEvents(this, Gods.gods);
		       long startTime = System.nanoTime();
		       while ( System.nanoTime() - startTime < Believer.alterBuildingTimeout) {
		    	   //do nothing
		       }
		       HandlerList.unregisterAll(this);
		    }
			/**
			 * On block placed. This is the general catch-all for detecting the creation of
			 * altars
			 *
			 * @param event the event
			 */
			@EventHandler
		    public void onBlockPlaced(BlockPlaceEvent event){
				if (event.getPlayer() == believer.getPlayer()){ //make sure the player we are listening to is the one who placed the block
					AlterManager.checkForAlterCreation(event.getBlock());
				}
		    }
		  }

	public static void saveAll() {
		for(Believer believer : believerList) {
			if(!saveToJson(believer)) {
				//TODO log a failure to save!!!
			}
		}
	}

	public void changeGod(String godName) {
		beliefPower = 0;
		setRank(0);
		powerupList.clear();

		for (God g : Gods.godsArray)
		{
			if (g.getName().equalsIgnoreCase(godName)) {
				god = g;
			}
		}
		
		
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}

/*
 * 
 */
package com.CS4398.spc51.gods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.CS4398.spc51.gods.alter.AlterGenerator;
import com.CS4398.spc51.gods.alter.AlterManager;
import com.CS4398.spc51.gods.gods.God;
import com.CS4398.spc51.gods.powerup.Powerup;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import scala.reflect.io.Directory;


// TODO: Auto-generated Javadoc
/**
 * @author Shaun Coyne (spc51)
 * The Class Believer. 
 * 					TODO this should have a rank, a powerup list,  and a beliefPower.
 * 					TODO on rank increase check to the god to see if we need to update powerup list
 * 					TODO on beliefPower increase check to seee if we need to increase rank
 * 					TODO on beliefPower increase, check god to see if we need to reward the player
 * 					TODO similar logic applies to decreases
 * 					TODO need to add save and load logic to player objects to save and load  them from a yaml
 */
public class Believer implements Listener{
	
	/** The alter building timeout. */
	public static int alterBuildingTimeout = 90; //number of seconds alter detection will be on for this player
	
	/** The believer list. */
	public static ArrayList<Believer> believerList = new ArrayList<Believer>();
	
	/** The powerup list. */
	private ArrayList<Powerup> powerupList = new ArrayList<Powerup>();
	
	/** The belief power. This is how much the player has
	 * please their god */
	private float beliefPower;
	
	/**  This is the rank of the player. */
	private int rank;
	
	private boolean buildingAlter = true;
	
	private boolean timerExpired = true;
	

	
	/** this is true when the player requests to be in alter building mode. */
	
	public boolean isBuildingAlter() {
		return buildingAlter;
	}

	public void setBuildingAlter(boolean buildingAlter) {
		this.buildingAlter = buildingAlter;
	}

	/** The player UUID. */
	private UUID playerUUID;
	
	public UUID getPlayerUUID() {
		return playerUUID;
	}

	public void setPlayerUUID(UUID playerUUID) {
		this.playerUUID = playerUUID;
	}

	/**  The god the player worships. */
	private String god;

	
	/**
	 * Instantiates a new believer.
	 *
	 * @param player the player
	 */
	public Believer(Player player) {
		beliefPower = 0f;
		this.playerUUID = player.getUniqueId();
		god = Gods.godsArray[0].getName();
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
		god = Gods.godsArray[0].getName();

	}
	
	/**
	 * Instantiates a new believer.
	 *
	 * @param player the player
	 * @param beliefPower the belief power
	 * @param rank the rank
	 */
	public Believer(Player player, float beliefPower, int rank) {
		this.beliefPower = beliefPower;
		this.playerUUID = player.getUniqueId();
		this.setRank(rank);
		god = Gods.godsArray[0].getName();

	}
	
	/**
	 * Instantiates a new believer.
	 *
	 * @param uniqueId the unique id
	 */
	public Believer(UUID uniqueId) {
		beliefPower = 0f;
		this.playerUUID = uniqueId;
		god = Gods.godsArray[0].getName();
	}

	/**
	 * Load believer.
	 *
	 * @param player the player
	 */
	public static void loadBeliever(Player player) {
		if (!loadFromJSON(player.getUniqueId())) {
			System.out.println("Could not load user, are they new?");
			Believer newBeliever = new Believer(player);
			believerList.add(newBeliever);
			//TODO LOG: A player has joined that is not a believer. They must be new! Adding them now.
		}
	}
	
	/**
	 * Load believer.
	 *
	 * @param uuid the uuid
	 */
	public static void loadBeliever(UUID uuid) {
		if (!loadFromJSON(uuid)) {
			System.out.println("Could not load user, are they new?");
			Believer newBeliever = new Believer(uuid);
			believerList.add(newBeliever);
			//TODO LOG: A player has joined that is not a believer. They must be new! Adding them now.
		}
	}
	

	/**
	 * Load from JSON.
	 *
	 * @param uuid the uuid
	 * @return true, if successful
	 */
	private static boolean loadFromJSON(UUID uuid) {
		try {

			Gson gson = new Gson();
			Believer believer = gson.fromJson(new FileReader(Gods.gods.getDataFolder() + File.separator + "believers" + File.separator + uuid.toString() +".data"), Believer.class);
			if ( believer == null) {
				System.out.println("ERROR: LOADED NULL FROM JSON");
			}
			believerList.add(believer);
			return true;
		}
		catch(Exception e) {
			//TODO log error
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Save to json.
	 *
	 * @param believer the believer
	 * @return true, if successful
	 */
	private static boolean saveToJson(Believer believer) {
		
	    try {
	    	if(!Gods.gods.getDataFolder().exists()) {
	    		Gods.gods.getDataFolder().mkdir();
	    	}
	    	File d = new File(Gods.gods.getDataFolder() + File.separator + "believers");
	    	if(!d.exists())
	    	{
	    		d.mkdir();
	    	}
	    	FileWriter fw = new FileWriter(Gods.gods.getDataFolder() + File.separator + "believers" + File.separator + believer.getPlayerUUID() +".data");
	    	Gson gson = new Gson();

	        gson.toJson(believer, fw);
	    	fw.close();
			return true;
	    } catch (JsonIOException | IOException e) {
	        //TODO log error
	    	System.out.println(e.getMessage());
	    	return false;
	    }		
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
		float previousBP = beliefPower;
		beliefPower = beliefPower + level * multiplyer;		
		god.reward(previousBP, beliefPower, this);
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
		//TODO use a map or something, there is probably a faster way to do this.
		for(Believer b : believerList) {
			if (b.playerUUID.compareTo(uniqueId) == 0) {
				return b;
			}
		}
		
		return null;
	}

	/**
	 * Gets the god.
	 *
	 * @return the god
	 */
	public God getGod() {
		//Returns the God this player worships

		for (God g: Gods.godsArray) {
			if (g.getName().equalsIgnoreCase(god)) {
				return g;
			}
		
		}
		return null;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return Bukkit.getPlayer(playerUUID);
		
	}
	
	/**
	 * Start listening for alter.
	 */
	public void startListeningForAlter() {
		
		this.getPlayer().sendMessage("Beleiver 324");

		Gods.gods.getServer().getPluginManager().registerEvents(this, Gods.gods);
		
		
	}
	
	/**
	 * Start listening for alter template.
	 */
	public void startListeningForAlterTemplate() {
		
		buildingAlter = false;
		Gods.gods.getServer().getPluginManager().registerEvents(this, Gods.gods);
		
		
	}
	public static void stopListeningForAlter(Believer believer) {
		believer.setBuildingAlter(true); //return to default state. 
		believer.setTimerExpired(true);
	    HandlerList.unregisterAll(believer);

	}
	/**
	 * On block placed. This is the general catch-all for detecting the creation of
	 * altars
	 *
	 * @param event the event
	 */
	@EventHandler
    public void onBlockPlaced(BlockPlaceEvent event){
		
		if (true) {
			return; // this is done because currently we use right click for signs. In the future this will be re-enabled
		}
		
		if (event.getPlayer() == this.getPlayer()){ //make sure the player we are listening to is the one who placed the block
			event.getPlayer().sendMessage("Believer 356");

			if (buildingAlter) {
				event.getPlayer().sendMessage("Believer 359");
				if (timerExpired) {
					timerExpired = false;
					TimerThread timerThread = new TimerThread(this);
					timerThread.run();

				}
				AlterThread alterThread = new AlterThread(this, event.getBlock());
				alterThread.run();
			}
			else {
			event.getPlayer().sendMessage("Block placed!");
			if (timerExpired) {
				timerExpired = false;
				TimerThread timerThread = new TimerThread(this);
				timerThread.run();

			}
			AlterTemplateThread alterTemplateThread = new AlterTemplateThread(this, event.getBlock());
			alterTemplateThread.run();
			}
		}
    }
	@EventHandler
	public void OnPlayerInteract(PlayerInteractEvent event)
	{	
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			if (event.getPlayer() == this.getPlayer()){ //make sure the player we are listening to is the one who placed the block
				event.getPlayer().sendMessage("Believer 356");

				if (buildingAlter) {
					event.getPlayer().sendMessage("Believer 359");
					if (timerExpired) {
						timerExpired = false;
						TimerThread timerThread = new TimerThread(this);
						timerThread.run();

					}
					AlterThread alterThread = new AlterThread(this, event.getClickedBlock());
					alterThread.run();
				}
				else {
				event.getPlayer().sendMessage("Block placed!");
				if (timerExpired) {
					timerExpired = false;
					TimerThread timerThread = new TimerThread(this);
					timerThread.run();

				}
				AlterTemplateThread alterTemplateThread = new AlterTemplateThread(this, event.getClickedBlock());
				alterTemplateThread.run();
				}
			}
		}
	}


 	private class AlterThread implements Runnable{
		 	
	 		/** The believer. */
	 		Believer believer;
	 		
	 		Block block;


		    /**
    		 * Instantiates a new block listener.
    		 *
    		 * @param believer the believer
    		 */
    		public AlterThread(Believer believer, Block block) {
		    	this.believer = believer;
		    	this.block = block;
		}
			
			/**
			 * Run.
			 */
			public void run(){
				believer.getPlayer().sendMessage("Believer 399");
				AlterManager.checkForAlterCreation(block, believer);
		    }
			
		  }
 	private class AlterTemplateThread implements Runnable{
	 	
 		/** The believer. */
 		Believer believer;
 		
 		Block block;


	    /**
		 * Instantiates a new block listener.
		 *
		 * @param believer the believer
		 */
		public AlterTemplateThread(Believer believer, Block block) {
	    	this.believer = believer;
	    	this.block = block;
	}
		
		/**
		 * Run.
		 */
		public void run(){
			AlterGenerator.generateAlter(block);
	    }
		
	  }
 	private class TimerThread implements Runnable{
	 	
 		/** The believer. */
 		Believer believer;
 		


	    /**
		 * Instantiates a new block listener.
		 *
		 * @param believer the believer
		 */
		public TimerThread(Believer believer) {
	    	this.believer = believer;

	}
		
		/**
		 * Run.
		 */
		public void run(){
			try {
				Thread.sleep(alterBuildingTimeout * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Believer.stopListeningForAlter(believer);
			believer.getPlayer().sendMessage("Timer Expired");

	    }
		
	  }

	/**
	 * Save all.
	 */
	public static void saveAll() {
		for(Believer believer : believerList) {
			if(!saveToJson(believer)) {
				//TODO log a failure to save!!!
			}
		}
	}

	/**
	 * Change god.
	 *
	 * @param godName the god name
	 */
	public void changeGod(String godName) {
		beliefPower = 0;
		setRank(0);
		powerupList.clear();

		for (God g : Gods.godsArray)
		{
			if (g.getName().equalsIgnoreCase(godName)) {
				god = g.getName();
			}
		}
		
		
	}

	/**
	 * Gets the rank.
	 *
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Sets the rank by looping through the correct increase or decrease rank method. These methonds handle the removal of perks
	 *
	 * @param rank the new rank
	 */
	public void setRank(int rank) {
		while (this.rank < rank) {
			decreaseRank();
		}
		while (this.rank > rank) {
			increaseRank();
		}

	}
	
	public void increaseRank() {
		rank++;
		powerupList.addAll(getGod().getPowerUps(rank));
		
	}
	public void decreaseRank() {
		powerupList.removeAll(getGod().getPowerUps(rank));
		rank--;
	}

	public boolean hasPower(String name) {
		for (Powerup power : powerupList) {
			if (power.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public Powerup getPower(String powerName) {
		for (Powerup power : powerupList) {
			if (power.getName().equalsIgnoreCase(powerName)) {
				return power;
			}
		}
		return null;
	}

	public boolean isTimerExpired() {
		return timerExpired;
	}

	public void setTimerExpired(boolean timerExpired) {
		this.timerExpired = timerExpired;
	}

}

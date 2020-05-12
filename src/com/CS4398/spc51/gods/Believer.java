/*
 * 
 */
package com.CS4398.spc51.gods;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javassist.bytecode.ClassFile;
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
import com.CS4398.spc51.gods.gods.Atheist;
import com.CS4398.spc51.gods.gods.God;
import com.CS4398.spc51.gods.gods.Hades;
import com.CS4398.spc51.gods.gods.Poseidon;
import com.CS4398.spc51.gods.gods.Zeus;
import com.CS4398.spc51.gods.powerup.Powerup;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;


// TODO: Auto-generated Javadoc
/**
 * The Class Believer.
 *
 * @author Shaun Coyne (spc51)
 * The Class Believer. 
 * This is where we store all the information about a player. This class handles logic for saving and loading from disk. Managing the powerups the player has. And is where the rest of the plugin interfaces with the player.
 */
public class Believer implements Listener{
	

	
	/** The believer list. This is a static list of all the believers who are currently on the server */
	public static ArrayList<Believer> believerList = new ArrayList<Believer>();
	
	/** The powerup list. This is the list of all the powerups the believer has. */
	private ArrayList<Powerup> powerupList = new ArrayList<Powerup>();
	
	/** The belief power. This is how much the player has
	 * pleased their god */
	private float beliefPower;
	
	/**  This is the rank of the player. */
	private int rank;

	private God god;

	/** The player UUID. */
	private UUID playerUUID;
	
	/**
	 * Gets the player UUID.
	 *
	 * @return the player UUID
	 */
	public UUID getPlayerUUID() {
		return playerUUID;
	}

	/**
	 * Sets the player UUID.
	 *
	 * @param playerUUID the new player UUID
	 */
	public void setPlayerUUID(UUID playerUUID) {
		this.playerUUID = playerUUID;
	}

	
	/**
	 * Instantiates a new believer.
	 *
	 * @param player the player
	 */
	public Believer(Player player) {
		this.beliefPower = 0f;
		this.playerUUID = player.getUniqueId();
		this.god = new Atheist();
		Atheist.addBeliever(this);

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
		this.god = new Atheist();
		Atheist.addBeliever(this);


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
		this.god = new Atheist();
		Atheist.addBeliever(this);


	}
	/**
	 * Instantiates a new believer.
	 *
	 * @param player the player
	 * @param beliefPower the belief power
	 * @param rank the rank
	 */
	public Believer(Player player, float beliefPower, int rank, God god) {
		this.beliefPower = beliefPower;
		this.playerUUID = player.getUniqueId();
		this.setRank(rank);
		this.god = new Atheist();
		god.addBeliever(this);
	}
	
	/**
	 * Instantiates a new believer.
	 *
	 * @param uniqueId the unique id
	 */
	public Believer(UUID uniqueId) {
		this.beliefPower = 0f;
		this.playerUUID = uniqueId;
		this.god = new Atheist();
		Atheist.addBeliever(this);

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
			believer.god.addBeliever(believer);
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
		int target_rank = god.getRank(beliefPower);
		while (target_rank > rank) {
			decreaseRank();
		}
		
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
		return this.god;

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
	 * Save all.
	 */
	public static void saveAll() {
		for(Believer believer : believerList) {
			if(!saveToJson(believer)) {
				//TODO log a failure to save!!!
			}
		}
	}


	public void changeGod(God god) {
		beliefPower = 0;
		setRank(0);
		powerupList.clear();
		this.god = god;
		
		
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
	
	/**
	 * Increase rank.
	 */
	public void increaseRank() {
		rank++;
		powerupList.addAll(getGod().getPowerUps(rank));
		
	}
	
	/**
	 * Decrease rank.
	 */
	public void decreaseRank() {
		powerupList.removeAll(getGod().getPowerUps(rank));
		rank--;
	}

	/**
	 * Checks for power.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	public boolean hasPower(String name) {
		for (Powerup power : powerupList) {
			if (power.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the power.
	 *
	 * @param powerName the power name
	 * @return the power
	 */
	public Powerup getPower(String powerName) {
		for (Powerup power : powerupList) {
			if (power.getName().equalsIgnoreCase(powerName)) {
				return power;
			}
		}
		return null;
	}


	/**
	 * Use powerup.
	 *
	 * @param name the name
	 */
	public void usePowerup(String name) {
		for (Powerup p : powerupList) {
			if (p.getName().equalsIgnoreCase(name)) {
				p.execute(this);
			}
		}
		
	}

}

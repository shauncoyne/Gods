package com.CS4398.spc51.gods;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.CS4398.spc51.gods.gods.God;


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
	
	/** The belief power. This is how much the player has
	 * please their god */
	private float beliefPower;
	/** This is the rank of the player */
	private int rank;
	
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
		this.rank = rank;
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
		
		BlockListener tempListener = new BlockListener();
		tempListener.run();
		
	}

	 private class BlockListener implements Runnable, Listener {

		    public void run(){
		       CommandManager.gods.getServer().getPluginManager().registerEvents(this, CommandManager.gods);
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

		    }
		  }

}

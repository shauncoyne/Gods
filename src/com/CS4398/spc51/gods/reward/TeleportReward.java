package com.CS4398.spc51.gods.reward;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.Gods;

/**
 * The Class TeleportReward.
 */
public class TeleportReward extends Reward {
	
	/**  The location that the player will teleport to. */
	Location location;
	
	/**  The world that the player is in. */
	World world;

	/** 
	 * Instantiates a new teleport reward.
	 * The player will teleport to the spawn location.
	 *
	 * @param player the player
	 * @param message the message
	 * 
	 */
	public TeleportReward(Player player, String message) {
		super(player, message);
		world = this.player.getWorld();
		location = world.getSpawnLocation();
	}
	
	/** 
	 * Instantiates a new teleport reward.
	 *
	 * @param player the player
	 * @param message the message
	 * @param location the teleport location
	 * 
	 */
	public TeleportReward(Player player, String message, Location location) {
		super(player, message);
		world = this.player.getWorld();
		this.location = location;
	}
	
	/**
	 * Execute the teleport reward.
	 *
	 * @return true, if successful
	 * 
	 */
	@Override
	public boolean execute() {

		try {
		    player.teleport(location);
		    return true;
		} 
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

package com.CS4398.spc51.gods.reward;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.CommandManager;

/**
 * The Class TeleportReward.
 */
public class TeleportReward extends Reward {
	
	/** The location that the player will teleport to */
	Location location;
	
	/** The world that the player is in */
	World world;

	/** 
	 * Instantiates a new teleport reward.
	 *
	 * @param player the player
	 * @param message the message
	 * 
	 */
	public TeleportReward(Player player, String message) {
		super(player, message);
		world = player.getWorld();
		location = new Location(world, 0, 0, 0);
	}
	
	/** 
	 * Instantiates a new teleport punishment.
	 *
	 * @param player the player
	 * @param message the message
	 * @param location the teleport location
	 * 
	 */
	public TeleportReward(Player player, String message, Location location) {
		super(player, message);
		world = player.getWorld();
		this.location = location;
	}
	
	/**
	 * Execute the teleport punishment.
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
			CommandManager.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}
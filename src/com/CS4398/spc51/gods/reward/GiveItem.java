package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.CommandManager;

/**
 * The Class GiveItem.
 */
public class GiveItem extends Reward{
	
	/** The item. */
	ItemStack item;

	/**
	 * Instantiates a new give item.
	 *
	 * @param player the player
	 * @param message the message
	 */
	public GiveItem(Player player, String message) {
		super(player, message);
		this.item = new ItemStack(Material.BREAD);
	}
	
	/**
	 * Instantiates a new give item.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public GiveItem(Player player, String message, ItemStack item) {
		super(player, message);
		this.item = item;
	}
	
	/**
	 * Execute.
	 *
	 * @return true, if successful
	 * 
	 *          spawning reward for animals and mobs (enemies?) [Spawn.java]
	 *          enchanted armor [GodArmor.java] 
	 *          	* either a slightly leveled up armor that can continue to level up
	 *          	* or a very powerful armor with a time limit
	 *          teleport reward (can also be a punishment)
	 *          
	 *          IN THE FUTURE:
	 *          	* spawn water around user (this is hard, wait for it later)
	 */
	@Override
	public boolean execute() {

		try {
	    
	    return true;
	    
		} 
		catch (Exception e) {
			CommandManager.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Gods;

/**
 * @author Shaun Coyne (spc51)
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
	 *          
	 *          IN THE FUTURE:
	 *          	* spawn water around user (this is hard, wait for it later)
	 */
	@Override
	public boolean execute() {

		try {
			player.getInventory().addItem(item);
			return true;
		} catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
	}
}

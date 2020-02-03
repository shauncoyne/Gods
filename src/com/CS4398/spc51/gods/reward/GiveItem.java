package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.CommandManager;
import com.CS4398.spc51.gods.Gods;

/**
 * The Class giveItem.
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
	 */
	@Override
	public boolean execute() {

		try {
	    player.getInventory().addItem(item);
	    return true;
	    
		} 
		catch (Exception e) {
			CommandManager.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

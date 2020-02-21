package com.CS4398.spc51.gods.reward;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.CommandManager;

/**
 * The Class EnchantedChestplate.
 */
public class EnchantedChestplate extends GiveItem {
	
	/** The enchantment given to the chestplate. */
	Enchantment enchantment;
	
	/**
	 * Instantiates new enchanted chestplate.
	 * The default enchantment is fire protection.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public EnchantedChestplate(Player player, String message, ItemStack item) {
		super(player, message, item);
		item.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
	}
	
	// LOOK AT THE LINK THAT LO SENT A WHILE BACK FOR ENCHANTMENT LISTENER
	
	/**
	 * Instantiates a new enchanted chestplate
	 * 
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 * @param enchantment the enchantment
	 */
	public EnchantedChestplate(Player player, String message, ItemStack item, Enchantment enchantment) {
		super(player, message, item);
		this.enchantment = enchantment;
	}
	
	/**
	 * Execute.
	 *
	 * @return true, if successful
	 * 
	 */
	@Override
	public boolean execute() {

		try {
		    player.getInventory().setChestplate(item);
		    return true;
		} 
		catch (Exception e) {
			CommandManager.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

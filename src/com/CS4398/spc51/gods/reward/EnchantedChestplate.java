/*
 * 
 */
package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Gods;

// TODO: Auto-generated Javadoc
/**
 * The Class EnchantedChestplate.
 */
public class EnchantedChestplate extends GiveItem {
	
	/** The enchantment given to the chestplate. */
	Enchantment enchantment;
	
	/**
	 * Instantiates new enchanted diamond chestplate.
	 * The default enchantment is fire protection.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public EnchantedChestplate(Player player, String message, ItemStack item) {
		super(player, message, item);
		item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		item.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
	}
	
	// LOOK AT THE LINK THAT LO SENT A WHILE BACK FOR ENCHANTMENT LISTENER
	
	/**
	 * Instantiates a new enchanted diamond chestplate.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 * @param enchantment the enchantment
	 */
	public EnchantedChestplate(Player player, String message, ItemStack item, Enchantment enchantment) {
		super(player, message, item);
		item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		
		this.enchantment = enchantment;
		item.addEnchantment(this.enchantment, 2);
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
		    //player.getInventory().setChestplate(item);
			player.getEquipment().setChestplate(item);
		    return true;
		} 
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

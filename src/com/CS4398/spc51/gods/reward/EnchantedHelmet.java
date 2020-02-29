package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Gods;

/**
 * The Class EnchantedHelmet.
 */
public class EnchantedHelmet extends GiveItem {
	
	/** The enchantment given to the helmet. */
	Enchantment enchantment;
	
	/**
	 * Instantiates new enchanted diamond helmet.
	 * The default enchantment is fire protection.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public EnchantedHelmet(Player player, String message, ItemStack item) {
		super(player, message, item);
		item = new ItemStack(Material.DIAMOND_HELMET, 1);
		item.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
	}
	
	// LOOK AT THE LINK THAT LO SENT A WHILE BACK FOR ENCHANTMENT LISTENER
	
	/**
	 * Instantiates a new enchanted diamond helmet
	 * 
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 * @param enchantment the enchantment
	 */
	public EnchantedHelmet(Player player, String message, ItemStack item, Enchantment enchantment) {
		super(player, message, item);
		item = new ItemStack(Material.DIAMOND_HELMET, 1);
		
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
		    //player.getInventory().setHelmet(item);
			player.getEquipment().setHelmet(item);
		    return true;
		} 
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

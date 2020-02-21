package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.CommandManager;

/**
 * The Class EnchantedBoots.
 */
public class EnchantedBoots extends GiveItem {
	
	/** The enchantment given to the boots. */
	Enchantment enchantment;
	
	/**
	 * Instantiates new enchanted diamond boots.
	 * The default enchantment is fire protection.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public EnchantedBoots(Player player, String message, ItemStack item) {
		super(player, message, item);
		item = new ItemStack(Material.DIAMOND_BOOTS, 1);
		item.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
	}
	
	// LOOK AT THE LINK THAT LO SENT A WHILE BACK FOR ENCHANTMENT LISTENER
	
	/**
	 * Instantiates new enchanted diamond boots
	 * 
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 * @param enchantment the enchantment
	 */
	public EnchantedBoots(Player player, String message, ItemStack item, Enchantment enchantment) {
		super(player, message, item);
		item = new ItemStack(Material.DIAMOND_BOOTS, 1);
		
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
		    //player.getInventory().setBoots(item);
			player.getEquipment().setBoots(item);
		    return true;
		} 
		catch (Exception e) {
			CommandManager.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

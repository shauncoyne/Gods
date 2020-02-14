package com.CS4398.spc51.gods.reward;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.CommandManager;

/**
 * The Class EnchantedArmor.
 */
public class EnchantedArmor extends GiveItem {
	
	/** The helmet item. */
	Enchantment enchantment;
	aslfjds;bkbdsfjsbf
	
	/**
	 * Instantiates a new enchanted armor, in this case just a helmet.
	 *
	 * @param player the player
	 * @param message the message
	 */
	public EnchantedArmor(Player player, String message, ItemStack item) {
		super(player, message, item);
		item.addEnchantment(Enchantment.PROTECTION_FIRE, 2);
	}
	
	// LOOK AT THE LINK THAT LO SENT A WHILE BACK FOR ENCHANTMENT LISTENER
	
	/**
	 * Instantiates a new enchanted armor, in this case just a helmet.
	 *
	 * @param player the player
	 * @param message the message
	 */
	public EnchantedArmor(Player player, String message, ItemStack item, Enchantment enchantment) {
		super(player, message, item);
		this.enchantment = enchantment;
	}
	
	@Override
	public boolean execute() {

		try {
		    //player.getInventory().addItem(item);
		    return true;
		} 
		catch (Exception e) {
			CommandManager.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

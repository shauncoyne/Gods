package com.CS4398.spc51.gods.reward;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * The Class FrostBoots.
 */
public class FrostBoots extends EnchantedBoots {
	
	/**
	 * Instantiates new enchanted diamond boots.
	 * The enchantment is the ability to walk on (frozen) water.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public FrostBoots(Player player, String message, ItemStack item) {
		super(player, message, item);
		
		// replace current enchantment
		enchantment = Enchantment.FROST_WALKER;
		this.item.addEnchantment(enchantment, 2);
	}
}

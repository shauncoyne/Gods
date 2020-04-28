package com.CS4398.spc51.gods.reward;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * The Class FlamingSword.
 */
public class FlamingSword extends EnchantedSword {
	
	/**
	 * Instantiates a new enchanted diamond sword.
	 * The enchantment is to set targets on fire when attacking.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public FlamingSword(Player player, String message, ItemStack item) {
		super(player, message, item);
		
		// replace current enchantment
		enchantment = Enchantment.FIRE_ASPECT;
		this.item.addEnchantment(enchantment, 2);
	}
}

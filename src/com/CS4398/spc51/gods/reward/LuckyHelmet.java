package com.CS4398.spc51.gods.reward;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * The Class LuckyHelmet.
 */
public class LuckyHelmet extends EnchantedHelmet {
	
	/**
	 * Instantiates a new enchanted diamond helmet.
	 * The enchantment is decreasing the odds of catching worthless junk.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public LuckyHelmet(Player player, String message, ItemStack item) {
		super(player, message, item);
		
		// replace current enchantment
		enchantment = Enchantment.LUCK;
		this.item.addEnchantment(enchantment, 2);
	}
}

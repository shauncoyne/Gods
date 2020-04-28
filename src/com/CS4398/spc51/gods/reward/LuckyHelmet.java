package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * The Class LuckyHelmet.
 */
public class LuckyHelmet extends EnchantedHelmet {
	
	/**
	 * Instantiates new enchanted diamond boots.
	 * The enchantment is decreasing the odds of catching worthless junk.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public LuckyHelmet(Player player, String message, ItemStack item) {
		super(player, message, item);
		item = new ItemStack(Material.DIAMOND_HELMET, 1);
		Enchantment enchantment = Enchantment.LUCK;
		item.addEnchantment(enchantment, 2);
	}
}

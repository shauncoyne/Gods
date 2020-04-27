package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * The Class SwordOfSouls.
 */
public class SwordOfSouls extends EnchantedSword {
	
	/**
	 * Instantiates a new enchanted diamond sword.
	 * The enchantment increases damage against undead targets.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public SwordOfSouls(Player player, String message, ItemStack item) {
		super(player, message, item);
		item = new ItemStack(Material.DIAMOND_SWORD, 1);
		Enchantment enchantment = Enchantment.DAMAGE_UNDEAD;
		item.addEnchantment(enchantment, 2);
	}
}

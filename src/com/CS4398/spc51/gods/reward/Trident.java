package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * The Class Trident.
 */
public class Trident extends GiveItem {
	
	/**
	 * Instantiates a new trident from Poseidon.
	 * The default enchantment does more damage to underwater mobs or wet mobs.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public Trident(Player player, String message, ItemStack item) {
		super(player, message, item);
		item = new ItemStack(Material.TRIDENT, 1);
		Enchantment enchantment = Enchantment.IMPALING;
		item.addEnchantment(enchantment, 2);
	}
}

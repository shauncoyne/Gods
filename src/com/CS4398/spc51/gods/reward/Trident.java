package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * The Class Trident.
 */
public class Trident extends GiveItem {
	
	Enchantment enchantment;

	/**
	 * Instantiates a new trident from Poseidon.
	 * The trident does more damage to underwater mobs or wet mobs.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public Trident(Player player, String message, ItemStack item) {
		super(player, message, item);
		this.item = new ItemStack(Material.TRIDENT, 1);
		
		enchantment = Enchantment.IMPALING;
		this.item.addEnchantment(enchantment, 2);
	}
}

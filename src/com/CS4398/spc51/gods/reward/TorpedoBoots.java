package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * The Class TorpedoBoots.
 */
public class TorpedoBoots extends EnchantedBoots {
	
	/**
	 * Instantiates new enchanted diamond boots.
	 * The enchantment is the ability to walk faster under water.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public TorpedoBoots(Player player, String message, ItemStack item) {
		super(player, message, item);
		item = new ItemStack(Material.DIAMOND_BOOTS, 1);
		Enchantment enchantment = Enchantment.DEPTH_STRIDER;
		item.addEnchantment(enchantment, 2);
	}
}

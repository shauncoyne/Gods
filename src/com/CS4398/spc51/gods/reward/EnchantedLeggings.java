package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Gods;

/**
 * The Class EnchantedLeggings.
 */
public class EnchantedLeggings extends GiveItem {
	
	/** The enchantment given to the leggings. */
	Enchantment enchantment;
	
	/**
	 * Instantiates new enchanted diamond leggings.
	 * The default enchantment is fire protection.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public EnchantedLeggings(Player player, String message, ItemStack item) {
		super(player, message, item);
		this.item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
		
		// default enchantment
		enchantment = Enchantment.PROTECTION_FIRE;
		this.item.addEnchantment(enchantment, 2);
	}

	/**
	 * Instantiates new enchanted diamond leggings.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 * @param enchantment the custom enchantment
	 */
	public EnchantedLeggings(Player player, String message, ItemStack item, Enchantment enchantment) {
		super(player, message, item);
		this.item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
		
		// custom enchantment
		this.enchantment = enchantment;
		this.item.addEnchantment(this.enchantment, 2);
	}
	
	/**
	 * Execute.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean execute() {

		try {
			player.getEquipment().setLeggings(item);
		    return true;
		} 
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

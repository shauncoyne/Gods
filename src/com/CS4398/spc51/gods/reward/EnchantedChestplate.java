package com.CS4398.spc51.gods.reward;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Gods;

/**
 * The Class EnchantedChestplate.
 */
public class EnchantedChestplate extends GiveItem {
	
	/** The enchantment given to the chest plate. */
	Enchantment enchantment;
	
	/**
	 * Instantiates new enchanted diamond chest plate.
	 * The default enchantment is explosion protection.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 */
	public EnchantedChestplate(Player player, String message, ItemStack item) {
		super(player, message, item);
		this.item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		
		// default enchantment
		enchantment = Enchantment.PROTECTION_EXPLOSIONS;
		this.item.addEnchantment(enchantment, 2);
	}
	
	/**
	 * Instantiates a new enchanted diamond chest plate.
	 *
	 * @param player the player
	 * @param message the message
	 * @param item the item
	 * @param enchantment the custom enchantment
	 */
	public EnchantedChestplate(Player player, String message, ItemStack item, Enchantment enchantment) {
		super(player, message, item);
		this.item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		
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
			player.getEquipment().setChestplate(item);
		    return true;
		} 
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
		
		
	}

}

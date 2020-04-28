package com.CS4398.spc51.gods.reward;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.CS4398.spc51.gods.Gods;

/** 
 * The Class LightningAttack. 
 */
public class LightningAttack extends Reward {
	
	EntityDamageByEntityEvent e;

	/**
	 * Instantiates a lightning attack reward.
	 * 
	 * @param player the player
	 * @param message the message
	 * 
	 */
	public LightningAttack(Player player, String message) {
		super(player, message);
	}
	
	/**
	 * Execute a strike of lightning on an enemy.
	 * 
	 * @return true, if successful
	 */
	@Override
	public boolean execute() {
		try {
			Entity attacker = e.getDamager();
			Entity defender = e.getEntity();
			
			if (attacker instanceof Player) {
				World world = defender.getWorld();
				world.strikeLightning(defender.getLocation());
			}
			return true;
		}
		catch (Exception e) {
			Gods.gods.getLogger().info(e.getMessage()); 
			return false;
		}
	}
}

package com.CS4398.spc51.gods.powerup;

import java.io.Serializable;
import java.sql.Timestamp;

//import org.bukkit.event.entity.EntityDamageEvent;

import com.CS4398.spc51.gods.Believer;

public class BreatheUnderwater extends Powerup {

	//private EntityDamageEvent event;

	public BreatheUnderwater(String name, int max_duration, int cooldown) {
		super(name, max_duration, cooldown);
	}
	
	@Override
	public void execute(Believer b) {
		
		Timestamp curr_timestamp = new Timestamp(System.currentTimeMillis());
		long milliseconds = curr_timestamp.getTime() - getLastUsed().getTime();
		int seconds = (int) milliseconds / 1000;
		
		if (seconds >= getCooldown()) {
			b.getPlayer().sendMessage("You feel your lungs expand...");
			b.getPlayer().sendMessage("You speak the name..... " + b.getGod().getName());
			b.getPlayer().sendMessage("And you are rewarded with the ability to breathe underwater!");
			b.getPlayer().setMaximumAir(6000); // 5 minutes
			
			/*
			if(event.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
				event.setCancelled(true);
			}
			*/
		}
		else {
			b.getPlayer().sendMessage("Alas, you are too weak to use this power.");
			b.getPlayer().sendMessage("Perhaps in " + (getCooldown() - seconds) + " seconds you will be strong enough.");
		}
	}
}

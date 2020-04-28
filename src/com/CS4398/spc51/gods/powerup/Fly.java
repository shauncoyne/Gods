package com.CS4398.spc51.gods.powerup;

import java.io.Serializable;
import java.sql.Timestamp;

import com.CS4398.spc51.gods.Believer;

public class Fly extends Powerup implements Serializable {
	
	private static final long serialVersionUID = -2356573470196700816L;

	public Fly(String name, int max_duration, int cooldown) {
		super(name, max_duration, cooldown);
	}
	
	@Override
	public void execute(Believer b) {
		
		Timestamp curr_timestamp = new Timestamp(System.currentTimeMillis());
		long milliseconds = curr_timestamp.getTime() - getLastUsed().getTime();
		int seconds = (int) milliseconds / 1000;
		
		if (seconds >= getCooldown()) {
			b.getPlayer().sendMessage("You feel yourself become light as a feather...");
			b.getPlayer().sendMessage("You speak the name..... " + b.getGod().getName());
			b.getPlayer().sendMessage("And you are rewarded with the ability to fly!");
			b.getPlayer().setAllowFlight(!b.getPlayer().getAllowFlight());
		}
		else {
			b.getPlayer().sendMessage("Alas, you are too weak to use this power.");
			b.getPlayer().sendMessage("Perhaps in " + (getCooldown() - seconds) + " seconds you will be strong enough.");
		}
	}
}

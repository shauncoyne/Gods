package com.CS4398.spc51.gods.powerup;

import java.io.Serializable;
import java.sql.Timestamp;

import com.CS4398.spc51.gods.Believer;

public class Pray extends Powerup implements Serializable{

	private static final long serialVersionUID = -7065570110587446184L;

	public Pray(String name, int max_duration, int cooldown) {
		super(name, max_duration, cooldown);
	}

	@Override
	public void execute(Believer b) {
		
		Timestamp curr_timestamp = new Timestamp(System.currentTimeMillis());
		long milliseconds = curr_timestamp.getTime() - getLastUsed().getTime();
		int seconds = (int) milliseconds / 1000;
		
		if (seconds >= getCooldown()) {
			b.getPlayer().sendMessage("You take a moment to focus all of your energy...");
			b.getPlayer().sendMessage("You speak the name..... " + b.getGod().getName());
			b.getPlayer().sendMessage("And you are rewarded, your belief power is increased!");
			b.increaseBeliefPower(b.getGod(), 1);
		}
		else {
			b.getPlayer().sendMessage("Alas, you are too weak to use this power.");
			b.getPlayer().sendMessage("Perhaps in " + (getCooldown() - seconds) + " seconds you will be strong enough."); 
		}	
	}
}

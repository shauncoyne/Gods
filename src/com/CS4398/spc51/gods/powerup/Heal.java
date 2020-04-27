package com.CS4398.spc51.gods.powerup;

import java.io.Serializable;
import java.sql.Timestamp;

import com.CS4398.spc51.gods.Believer;

public class Heal extends Powerup implements Serializable{

	/**
	 * 
	 */
	private double increaseAmount;
	

	public Heal(String name, int max_duration, int cooldown, double increaseAmount) {
		super(name, max_duration, cooldown);
		this.increaseAmount = increaseAmount;
	}

	@Override
	public void execute(Believer b) {
		Timestamp curr_timestamp = new Timestamp(System.currentTimeMillis());
		long milliseconds = curr_timestamp.getTime() - getLastUsed().getTime();
		int seconds = (int) milliseconds / 1000;
		if (seconds >= getCooldown()) {
			b.getPlayer().sendMessage("You beg for mercy...");
			b.getPlayer().sendMessage("Your wounds glow a little big..... " + b.getGod().getName());
			b.getPlayer().sendMessage("And you are healed.");
			double previousHealth = b.getPlayer().getHealth();
			b.getPlayer().setHealth(previousHealth + increaseAmount); 
		}
		else {
			b.getPlayer().sendMessage("Alas, you are too weak to use this power.");
			b.getPlayer().sendMessage("Perhaps in " + (getCooldown() - seconds) + " seconds you will be strong enough"); 
		}
		
		
		
	}

}

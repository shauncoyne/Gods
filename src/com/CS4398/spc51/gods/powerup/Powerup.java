/*
 * 
 */
package com.CS4398.spc51.gods.powerup;

import java.io.Serializable;
import java.sql.Timestamp;

import com.CS4398.spc51.gods.Believer;

public abstract class Powerup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 737088112482514416L;
	private String name;
	private int max_duration;
	private int current_duration;
	private int cooldown;
	private Timestamp lastUsed;
	
	public Powerup(String name, int max_duration, int cooldown) {
		this.name = name;
		this.max_duration = max_duration;
		this.setCooldown(cooldown);
		lastUsed = new Timestamp(System.currentTimeMillis());
	}
	
	public abstract void execute(Believer b);
	
	public void increaseCooldown(int amount) {
		this.setCooldown(getCooldown() + amount);
	}
	
	public void decreaseCooldown(int amount) {
		this.setCooldown(getCooldown() - amount);
	}
	
	public void increaseMaxDuration(int amount) {
		this.max_duration = max_duration + amount; 
	}
	
	public void decreaseMaxDuration(int amount) {
		this.max_duration = max_duration - amount;
	}

	public Timestamp getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public String getName() {
		return name;
	}

}

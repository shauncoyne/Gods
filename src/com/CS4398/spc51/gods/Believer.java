package com.CS4398.spc51.gods;

import java.util.UUID;

import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.gods.God;

public class Believer {
	private float beliefPower;
	private UUID playerUUID;
	
	public Believer(Player player) {
		beliefPower = 0f;
		this.playerUUID = player.getUniqueId();
	}
	public Believer(Player player, int beliefPower) {
		this.beliefPower = beliefPower;
		this.playerUUID = player.getUniqueId();
	}
	public float getBeliefPower() {
		return beliefPower;
	}

	public void setBeliefPower(float beliefPower) {
		this.beliefPower = beliefPower;
	}
	public void increaseBeliefPower(God god, int level) {
		float multiplyer = Gods.configurator.getMultiplyer(god);
		beliefPower = beliefPower + level * multiplyer;		
	}
	public void decreaseBeliefPower(God god, int level) {
		float multiplyer = Gods.configurator.getMultiplyer(god);
		beliefPower = beliefPower - level * multiplyer;		
	}

}

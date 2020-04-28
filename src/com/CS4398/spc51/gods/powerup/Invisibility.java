package com.CS4398.spc51.gods.powerup;

import java.io.Serializable;
import java.sql.Timestamp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.CS4398.spc51.gods.Believer;

public class Invisibility extends Powerup implements Serializable {

	private static final long serialVersionUID = 2834620570100307562L;

	public Invisibility(String name, int max_duration, int cooldown) {
		super(name, max_duration, cooldown);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(Believer b) {
		
		Timestamp curr_timestamp = new Timestamp(System.currentTimeMillis());
		long milliseconds = curr_timestamp.getTime() - getLastUsed().getTime();
		int seconds = (int) milliseconds / 1000;
		
		if (seconds >= getCooldown()) {
			b.getPlayer().sendMessage("You feel yourself disappear from the world...");
			b.getPlayer().sendMessage("You speak the name..... " + b.getGod().getName());
			b.getPlayer().sendMessage("And you are now invisible!");
			
			for(Player everyone : Bukkit.getOnlinePlayers()) {
				if(b.getPlayer() != everyone)
					everyone.hidePlayer(b.getPlayer());
			}
		}
		else {
			b.getPlayer().sendMessage("Alas, you are too weak to use this power.");
			b.getPlayer().sendMessage("Perhaps in " + (getCooldown() - seconds) + " seconds you will be strong enough.");
		}
	}
}

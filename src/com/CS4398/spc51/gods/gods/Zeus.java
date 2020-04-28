/*
 * 
 */
package com.CS4398.spc51.gods.gods;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.powerup.Heal;
import com.CS4398.spc51.gods.powerup.Powerup;
import com.CS4398.spc51.gods.powerup.Pray;
import com.CS4398.spc51.gods.punishment.Punishment;
import com.CS4398.spc51.gods.punishment.TeleportPunishment;
import com.CS4398.spc51.gods.reward.GiveItem;
import com.CS4398.spc51.gods.reward.Reward;

// TODO: Auto-generated Javadoc
/**
 * The Class Zeus. Put his info here
 */
public class Zeus extends God{

	/**
	 * Instantiates a new zeus.
	 */
	public Zeus() {
		super("Zeus", "Greek");
	}
	
	/**
	 * Observe an event.
	 *
	 * @param believer the believer
	 * @param e the event
	 */
	public void observe(Believer believer, Event e) 
	{
		switch(e.getEventName()) {
		
		
			case "EntityDeathEvent": 

				playerKilledEntity(believer, (EntityDeathEvent) e);
				break;
                 
		}
		
	}
	

	public void reward(float previousBP, float currentBP, Believer believer)

	{
		switch((int)currentBP)
		{
		case 10:  	Reward give = new GiveItem(believer.getPlayer(), "You have been good to me and my purpose");
					give.execute();
					break;
		case 15:
				break;
		case 20:
				break;
		case 30:
				break;
		case 40: 
				break;
		case 50: 
				break;
		case 60:
				break;
		case 70: 
				break;
		case 80:
				break;
		case 90: 
					break;
		case 100:
					break;
			default: break;
		}
	}

	/**
	 * Player Killed entity.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void playerKilledEntity(Believer believer, EntityDeathEvent e) 
	{
		switch(e.getEntityType())
		{
		case SHEEP : 
			sheepKilled(believer, e);
		    break;
	 
		default:
			break;
		}
	}
	
	//private void playerDied(Believer beliver, PlayerDeathEvent e)

	/**
	 * Sheep Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void sheepKilled(Believer believer, EntityDeathEvent e) 
	{

		believer.decreaseBeliefPower(believer.getGod(), 1);
		Punishment punish = new TeleportPunishment(believer.getPlayer(), "I never eally liked sheep....but I also don't like you right now.");
		punish.execute();
		
	}
	

	@Override
	public Collection<? extends Powerup> getPowerUps(int rank) {
		
		ArrayList<Powerup>thing = new ArrayList<Powerup>();
		

		
		switch(rank)
		{
		case 1:
			Powerup p = new Pray("fastPray", 10, 5);
			thing.add(p);
			break;
		case 2:
			Powerup h = new Heal("smallHeal", 30, 10000, 5);
			thing.add(h);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
			default: break;
		}
		return thing;
		// TODO Auto-generated method stub
		//return null;
	}
	


}

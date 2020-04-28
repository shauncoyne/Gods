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
import com.CS4398.spc51.gods.punishment.Death;
import com.CS4398.spc51.gods.punishment.Explode;
import com.CS4398.spc51.gods.punishment.InfiniteFire;
import com.CS4398.spc51.gods.punishment.Punishment;
import com.CS4398.spc51.gods.punishment.TeleportPunishment;
import com.CS4398.spc51.gods.reward.EnchantedBoots;
import com.CS4398.spc51.gods.reward.EnchantedChestplate;
import com.CS4398.spc51.gods.reward.EnchantedHelmet;
import com.CS4398.spc51.gods.reward.EnchantedLeggings;
import com.CS4398.spc51.gods.reward.EnchantedSword;
import com.CS4398.spc51.gods.reward.FrostBoots;
import com.CS4398.spc51.gods.reward.GiveItem;
import com.CS4398.spc51.gods.reward.InvisibilityHelmet;
import com.CS4398.spc51.gods.reward.Reward;
import com.CS4398.spc51.gods.reward.ScubaHelmet;
import com.CS4398.spc51.gods.reward.TorpedoBoots;
import com.CS4398.spc51.gods.reward.Trident;

// TODO: Auto-generated Javadoc
/**
 * The Class Poseidon. Put his info here
 */
public class Poseidon extends God{

	/**
	 * Instantiates a new poseidon.
	 */
	public Poseidon() {
		super("Poseidon", "Greek");
	}
	
	/**
	 * Observe an event.
	 *
	 * @param believer the believer
	 * @param e the event
	 */
	public void observe(Believer believer, Event e) 
	{
		switch (e.getEventName()) 
		{
        case "EntityDeathEvent":  
        		playerKilledEntity(believer, (EntityDeathEvent) e);
                 break;
        default:
        	break;
        	
		}
		
	}

	public void reward(float previousBP, float currentBP, Believer believer)

	{
		switch((int)currentBP)
		{
		case 10:  	Reward give = new GiveItem(believer.getPlayer(), "Welcome to our cult. Here you are safe. Here you are fed.");
					give.execute();
					break;
		case 15:Reward enchanBoots = new EnchantedBoots(believer.getPlayer(), "These boots shall help you on your journey of peace and rightouesness in praising Me.", null);
				enchanBoots.execute();
				break;
		case 20:Reward enchanChest = new EnchantedChestplate(believer.getPlayer(), "Protect yourself from those who wish you ill.", null);
				enchanChest.execute();
				break;
		case 30: Reward enchanLeg = new EnchantedLeggings(believer.getPlayer(), "Armor for a memeber of my army. Praise me, and I shall protect you.", null);
				enchanLeg.execute();
				break;
		case 40: Reward enchanHat = new EnchantedHelmet(believer.getPlayer(), "Your thoughts are sacred. Protect them.", null);
				enchanHat.execute();
				break;
		case 50: Reward enchanSword = new EnchantedSword(believer.getPlayer(), "Kill the nonbelivers. Spread our message to any who resist.", null);
				enchanSword.execute();
				break;
		case 60: Reward frost = new FrostBoots(believer.getPlayer(), "These boots were made with you in mind. use them wisely.", null);
				frost.execute();
				break;	
		case 70: Reward invisi = new InvisibilityHelmet(believer.getPlayer(), "Do not let the enemy see what you are up to. Be safe, be smart.", null);
				invisi.execute();
				break;
		case 80: Reward torBoots = new TorpedoBoots(believer.getPlayer(), "Think of this as an upgrade. Thank me later, child.", null);
				torBoots.execute();
				break;
		case 90: Reward scubaHat = new ScubaHelmet(believer.getPlayer(), "You may now visit the depths without worry. Come, my child.", null);
				scubaHat.execute();
					break;
		case 100:	Reward trid = new Trident(believer.getPlayer(), "The ultimate gift for the ultimate follower. Spread our message. Kill our enemies.", null);
					trid.execute();
					break;
			default: break;
		}
	}

	/**
	 * Player damaged entity.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void playerKilledEntity(Believer believer, EntityDeathEvent e) 
	{
		switch(e.getEntityType())
		{
		case HORSE :
			  horseKilled(believer, e); 
			  break; 
		case SQUID :
			  squidKilled(believer, e); 
			  break;
		case ENDERMAN :
			  endermanKilled(believer, e); 
			  break;
		case TURTLE :
			  turtleKilled(believer, e); 
			  break;	 
		default:
			break;
		}
	}
	
	/**
	 * Horse Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void horseKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.decreaseBeliefPower(believer.getGod(), 4);
			Punishment punish = new InfiniteFire(believer.getPlayer(), "I created the Horse. You must respect the Horse. Respect it!");
			punish.execute();
			
		}
		
	}
	/**
	 * Squid Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void squidKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.decreaseBeliefPower(believer.getGod(), 3);
			Punishment punish = new Death(believer.getPlayer(), "All that are of the sea and live in the sea belong to me. Do not kill them. Now you must pay.");
			punish.execute();
			
		}
		
	}
	/**
	 * Enderman Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void endermanKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.decreaseBeliefPower(believer.getGod(), 5);
			Punishment punish = new TeleportPunishment(believer.getPlayer(), "There is no reson to take the life of a gentle and elegant creature.");
			punish.execute();
			
		}
		
	}
	/**
	 * Turtle Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void turtleKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.decreaseBeliefPower(believer.getGod(), 2);
			Punishment punish = new Explode(believer.getPlayer(), "Graceful, beautiful, and now dead. Just like you.");
			punish.execute();
			
		}
		
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
	}

	


}
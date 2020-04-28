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
import com.CS4398.spc51.gods.reward.GiveItem;
import com.CS4398.spc51.gods.reward.InvisibilityHelmet;
import com.CS4398.spc51.gods.reward.FlamingSword;
import com.CS4398.spc51.gods.reward.FlyingBoots;
import com.CS4398.spc51.gods.reward.LuckyHelmet;
import com.CS4398.spc51.gods.reward.Reward;
import com.CS4398.spc51.gods.reward.SwordOfSouls;

// TODO: Auto-generated Javadoc
/**
 * The Class Hades. Put his info here
 */
public class Hades extends God{

	/**
	 * Instantiates a new Hades.
	 */
	public Hades() {
		super("Hades", "Greek");
	}
	
	/**
	 * Observe an event.
	 *
	 * @param believer the believer
	 * @param e the event
	 */
	public void observe(Believer believer, Event e) 
	{
		//switch based on the type of event
		switch (e.getEventName()) 
		{
        case "EntityDeathEvent":  
        		playerKilledEntity(believer, (EntityDeathEvent) e);
                 break;
		}
		
	}
	

	public void reward(float previousBP, float currentBP, Believer believer)

	{
		switch((int)currentBP)
		{
		case 10:  	Reward give = new GiveItem(believer.getPlayer(), "Here kid, take this. Or throw it on the ground. See if I care.");
					give.execute();
					break;
		case 15: Reward enchanBoots = new EnchantedBoots(believer.getPlayer(), "Your boots? They suck. Have these instead.", null);
				enchanBoots.execute();
				break;
		case 20: Reward enchanChest = new EnchantedChestplate(believer.getPlayer(), "I found this lying around. Thought you would like. Anyways, keep believing in me and I'll get you more cool things.", null);
				enchanChest.execute();
				break;
		case 30: Reward enchanLeg = new EnchantedLeggings(believer.getPlayer(), "I promised you some cool things, didn't I? Take this.", null);
				enchanLeg.execute();
				break;
		case 40: Reward enchanHat = new EnchantedHelmet(believer.getPlayer(), "Protect that head of your. It belives in me, so I like it.", null);
				enchanHat.execute();
				break;
		case 50:Reward enchanSword = new EnchantedSword(believer.getPlayer(), "You impress me everyday, kid. Go kill some more things.", null);
				enchanSword.execute();
				break;
		case 60: Reward enchanBoots2 = new EnchantedBoots(believer.getPlayer(), "You probbaly lost those old boots. Here you go.", null);
		enchanBoots2.execute();
				break;
		case 69: 	Reward flameSword = new FlamingSword(believer.getPlayer(), "Nice.", null);
					flameSword.execute();
					break;
		case 70:Reward luckyHat = new LuckyHelmet(believer.getPlayer(), "Perhaps some luck would do you good. Or not. I just wanna see what will happen.", null);
				luckyHat.execute();
				break;
		case 80: Reward invisi = new InvisibilityHelmet(believer.getPlayer(), "Try to sneak up on an enemy.... and then send me their soul.", null);
					invisi.execute();
				break;
		case 90:	Reward flyBoots = new FlyingBoots(believer.getPlayer(), "The gift of flight from the God of the underworld. You have earned it, young one.", null);
					flyBoots.execute();
					break;
		case 100:	Reward soulSword = new SwordOfSouls(believer.getPlayer(), "This is the best thing I could think of to give you. You're a good kid.", null);
					soulSword.execute();
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
		case ZOMBIE : 
			zombieKilled(believer, e);
		    break;
		case ZOMBIE_HORSE : 
			zombieHorseKilled(believer, e);
		    break;
		case ZOMBIE_VILLAGER : 
			zombieVillagerKilled(believer, e);
		    break;
		case PIG_ZOMBIE : 
			zombiePigKilled(believer, e);
		    break;		 
		default:
			break;
		}
	}

	/**
	 * Zombie damaged.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void zombieKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.decreaseBeliefPower(believer.getGod(), 10);
			Punishment punish = new TeleportPunishment(believer.getPlayer(), "Must I warn you? No one is to kill the army of the dead...");
			punish.execute();
		}
		
	}
	/**
	 * Zombie Horse damaged.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void zombieHorseKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.decreaseBeliefPower(believer.getGod(), 9);
			Punishment punish = new InfiniteFire(believer.getPlayer(), "Those who are undead belong to me. Do not dispose of them...Or I shall dispose of you.");
			punish.execute();
		}
		
	}
	/**
	 * Zombie Villager damaged.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void zombieVillagerKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.decreaseBeliefPower(believer.getGod(), 20);
			Punishment punish = new Explode(believer.getPlayer(), "So now you desire flesh as well...Blood for undead blood is what I say...");
			punish.execute();
		}
		
	}
	/**
	 * Zombie pig damaged.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void zombiePigKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.decreaseBeliefPower(believer.getGod(), 2);
			Punishment punish = new Death(believer.getPlayer(), "The undead are mine. Do not harm them. EVER.");
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
		case 2: Powerup h = new Heal("smallHeal", 30, 10000, 5);
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
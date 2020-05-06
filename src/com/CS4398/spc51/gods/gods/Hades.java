/*
 * 
 */
package com.CS4398.spc51.gods.gods;

import java.util.ArrayList;
import java.util.Collection;

//imports

import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.powerup.Fly;
import com.CS4398.spc51.gods.powerup.Heal;
import com.CS4398.spc51.gods.powerup.Invisibility;
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
import com.CS4398.spc51.gods.reward.FlamingSword;
import com.CS4398.spc51.gods.reward.FlyingBoots;
import com.CS4398.spc51.gods.reward.GiveItem;
import com.CS4398.spc51.gods.reward.InvisibilityHelmet;
import com.CS4398.spc51.gods.reward.LuckyHelmet;
import com.CS4398.spc51.gods.reward.Reward;
import com.CS4398.spc51.gods.reward.SwordOfSouls;

// TODO: Auto-generated Javadoc
/**
 * The Class Hades. Put his info here
 */
public class Hades extends God{
	
	private static ArrayList<Believer> believers = new ArrayList<Believer>();


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
	@Override
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
	

	@Override
	public void reward(float previousBP, float currentBP, Believer believer)

	{
		if(previousBP < 10.0 && currentBP >= 10.0 && currentBP < 15.0)
		{
			Reward give = new GiveItem(believer.getPlayer(), "Here kid, take this. Or throw it on the ground. See if I care.");
			give.execute();
		}
		if(currentBP >= 11 && previousBP < 11)
		{
			believer.increaseRank();
			believer.getPlayer().sendMessage("Your rank has increased, young believer. You may now fastPray to your God.");
		}
		else if(previousBP < 15.0 && currentBP >= 15.0 && currentBP < 20.0)
		{
			Reward enchanBoots = new EnchantedBoots(believer.getPlayer(), "Your boots? They suck. Have these instead.", null);
			enchanBoots.execute();
		}
		else if(previousBP < 20.0 && currentBP >= 20.0 && currentBP < 30.0)
		{
			Reward enchanChest = new EnchantedChestplate(believer.getPlayer(), "I found this lying around. Thought you would like. Anyways, keep believing in me and I'll get you more cool things.", null);
			enchanChest.execute();
		}
		if(currentBP >= 21 && previousBP < 21)
		{
			believer.increaseRank();
			believer.getPlayer().sendMessage("Your rank has increased, young believer. You may now smallHeal.");
		}
		else if(previousBP < 30.0 && currentBP >= 30.0 && currentBP < 40.0)
		{
			Reward enchanLeg = new EnchantedLeggings(believer.getPlayer(), "I promised you some cool things, didn't I? Take this.", null);
			enchanLeg.execute();
		}
		if(currentBP >= 31 && previousBP < 31)
		{
			believer.increaseRank();
			believer.getPlayer().sendMessage("Your rank has increased, young believer. You may now bigHeal.");
		}
		else if(previousBP < 40.0 && currentBP >= 40.0 && currentBP < 50.0)
		{
			Reward enchanHat = new EnchantedHelmet(believer.getPlayer(), "Protect that head of your. It belives in me, so I like it.", null);
			enchanHat.execute();
		}
		if(currentBP >= 41 && previousBP < 41)
		{
			believer.increaseRank();
			believer.getPlayer().sendMessage("Your rank has increased, young believer. Continue to rank up and you will be rewarded.");
		}
		else if(previousBP < 50.0 && currentBP >= 50.0 && currentBP < 60.0)
		{
			Reward enchanSword = new EnchantedSword(believer.getPlayer(), "You impress me everyday, kid. Go kill some more things.", null);
			enchanSword.execute();
		}
		if(currentBP >= 51 && previousBP < 51)
		{
			believer.increaseRank();
		}
		else if(previousBP < 60.0 && currentBP >= 60.0 && currentBP < 69.0)
		{
			Reward enchanBoots2 = new EnchantedBoots(believer.getPlayer(), "You probbaly lost those old boots. Here you go.", null);
			enchanBoots2.execute();
		}
		if(currentBP >= 61 && previousBP < 61)
		{
			believer.increaseRank();
			believer.getPlayer().sendMessage("Your rank has increased, young believer. You have be awarded the power to fly.");
		}
		else if(previousBP < 69.0 && currentBP >= 69.0 && currentBP < 70.0)
		{
			Reward flameSword = new FlamingSword(believer.getPlayer(), "Nice.", null);
			flameSword.execute();
		}
		else if(previousBP < 70.0 && currentBP >= 70.0 && currentBP < 80.0)
		{
			Reward luckyHat = new LuckyHelmet(believer.getPlayer(), "Perhaps some luck would do you good. Or not. I just wanna see what will happen.", null);
			luckyHat.execute();
		}
		if(currentBP >= 71 && previousBP < 71)
		{
			believer.increaseRank();
		}
		else if(previousBP < 80.0 && currentBP >= 80.0 && currentBP < 90.0)
		{
			Reward invisi = new InvisibilityHelmet(believer.getPlayer(), "Try to sneak up on an enemy.... and then send me their soul.", null);
			invisi.execute();
		}
		if(currentBP >= 81 && previousBP < 81)
		{
			believer.increaseRank();
		}
		else if(previousBP < 90.0 && currentBP >= 90.0 && currentBP < 100.0)
		{
			Reward flyBoots = new FlyingBoots(believer.getPlayer(), "The gift of flight from the God of the underworld. You have earned it, young one.", null);
			flyBoots.execute();
		}
		if(currentBP >= 91 && previousBP < 91)
		{
			believer.increaseRank();
		}
		else if(previousBP < 100.0 && currentBP >= 100.0 && currentBP < 110.0)
		{
			Reward soulSword = new SwordOfSouls(believer.getPlayer(), "This is the best thing I could think of to give you. You're a good kid.", null);
			soulSword.execute();
		}
		if(currentBP >= 101 && previousBP < 101)
		{
			believer.increaseRank();
			believer.getPlayer().sendMessage("Your rank has increased, young believer. You have be awarded the power to become invisible.");
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
		case COW : 
			cowKilled(believer, e);
		    break;
		case VILLAGER : 
			villagerKilled(believer, e);
		    break;
	 
		case ENDER_DRAGON : 
			enderdragonKilled(believer, e);
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
			believer.increaseBeliefPower(believer.getGod(), 4);
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
			believer.increaseBeliefPower(believer.getGod(), 3);
			
			
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
			believer.increaseBeliefPower(believer.getGod(), 5);
			
			
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
			believer.increaseBeliefPower(believer.getGod(), 2);
			
		}
		
	}
	/**
	 * Cow Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void cowKilled(Believer believer, EntityDeathEvent e) 
	{

		believer.increaseBeliefPower(believer.getGod(), 3);
		
	}
	
	/**
	 * Villager Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void villagerKilled(Believer believer, EntityDeathEvent e) 
	{

		believer.increaseBeliefPower(believer.getGod(), 2);
		
	}
	
	/**
	 * Ender Dragon Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void enderdragonKilled(Believer believer, EntityDeathEvent e) 
	{

		believer.increaseBeliefPower(believer.getGod(), 4);

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
		case 2: Powerup h = new Heal("smallHeal", 30, 120, 2);
			thing.add(h);
			break;
		case 3:
			Powerup b = new Heal("bigHeal", 30, 600, 10);
			thing.add(b);
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			Powerup f = new Fly("fly", 120, 600);
			thing.add(f);
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			Powerup i = new Invisibility("invisible", 300, 800);
			thing.add(i);
			break;
		
			default: break;
		}
		return thing;

	}
	

	/**
	 * Gets the believers.
	 *
	 * @return the believers
	 */
	@Override
	public ArrayList<Believer> getBelievers() {
		return Hades.believers;
	}
	public static void addBeliever(Believer b) {
		believers.add(b);
	}
	public static void removeBeliever(Believer b) {
		believers.remove(b);
	}

	/**
	 * Sets the believers.
	 *
	 * @param believers the new believers
	 */
	public static void setBelievers(ArrayList<Believer> believers) {
		Hades.believers = believers;
	}

	@Override
	public int getRank(float beliefPower) {
		if(beliefPower >= 11 && beliefPower < 21)
			return 1;
		if(beliefPower >= 21 && beliefPower < 31)
			return 2;
		if(beliefPower >= 31 && beliefPower < 41)
			return 3;
		if(beliefPower >= 41 && beliefPower < 51)
			return 4;
		if(beliefPower >= 51 && beliefPower < 61)
			return 5;
		if(beliefPower >= 61 && beliefPower < 71)
			return 6;
		if(beliefPower >= 71 && beliefPower < 81)
			return 7;
		if(beliefPower >= 81 && beliefPower < 91)
			return 8;
		if(beliefPower >= 91 && beliefPower < 101)
			return 9;
		if(beliefPower >= 101)
			return 10;
		else
			return 0;
	}



}
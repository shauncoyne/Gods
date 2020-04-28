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
import com.CS4398.spc51.gods.reward.EnchantedBoots;
import com.CS4398.spc51.gods.reward.EnchantedChestplate;
import com.CS4398.spc51.gods.reward.EnchantedHelmet;
import com.CS4398.spc51.gods.reward.EnchantedLeggings;
import com.CS4398.spc51.gods.reward.FlamingSword;
import com.CS4398.spc51.gods.reward.FlyingBoots;
import com.CS4398.spc51.gods.reward.GiveItem;
import com.CS4398.spc51.gods.reward.InvisibilityHelmet;
import com.CS4398.spc51.gods.reward.LightningAttack;
import com.CS4398.spc51.gods.reward.LuckyHelmet;
import com.CS4398.spc51.gods.reward.Reward;
import com.CS4398.spc51.gods.reward.TeleportReward;

// TODO: Auto-generated Javadoc
/**
 * The Class Zeus. Put his info here
 */
public class Zeus extends God{
	
	private static ArrayList<Believer> believers = new ArrayList<Believer>();


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
		if(previousBP < 10.0 && currentBP >= 10.0 && currentBP < 15.0)
		{
			Reward give = new GiveItem(believer.getPlayer(), "My child, obey me and you shall be rewarded. Disobey me, and suffer my wrath");
			give.execute();
		}
		if(currentBP >= 11 && previousBP < 11)
		{
			believer.increaseRank();
			believer.getPlayer().sendMessage("Your rank has increase, young believer. You may now fastPray to your God.");
		}
		else if(previousBP < 15.0 && currentBP >= 15.0 && currentBP < 20.0)
		{
			Reward enchanBoots = new EnchantedBoots(believer.getPlayer(), "Be strong, child. May each step you praise me more.", null);
			enchanBoots.execute();
		}
		else if(previousBP < 20.0 && currentBP >= 20.0 && currentBP < 30.0)
		{
			Reward enchanChest = new EnchantedChestplate(believer.getPlayer(), "You were made in my image. May you grow stronger to be like me.", null);
			enchanChest.execute();
		}
		if(currentBP >= 21 && previousBP < 21)
		{
			believer.increaseRank();
			believer.getPlayer().sendMessage("Your rank has increase, young believer. You may now smallHeal.");
		}
		else if(previousBP < 30.0 && currentBP >= 30.0 && currentBP < 40.0)
		{
			Reward enchanLeg = new EnchantedLeggings(believer.getPlayer(), "I shall help you improve, so long as your dedication to me never falters.", null);
			enchanLeg.execute();
		}
		else if(previousBP < 40.0 && currentBP >= 40.0 && currentBP < 50.0)
		{
			Reward enchanHat = new EnchantedHelmet(believer.getPlayer(), "My child, may you feel safe under my protection. May you tell all those who oppose me about my power.", null);
			enchanHat.execute();
		}
		else if(previousBP < 50.0 && currentBP >= 50.0 && currentBP < 60.0)
		{
			Reward flameSword = new FlamingSword(believer.getPlayer(), "You are an extension of me now. Feel my power within you.", null);
			flameSword.execute();
		}
		else if(previousBP < 60.0 && currentBP >= 60.0 && currentBP < 69.0)
		{
			Reward flyBoot = new FlyingBoots(believer.getPlayer(), "Take to the skies, my child. Fly to join me.", null);
			flyBoot.execute();
		}
		else if(previousBP < 70.0 && currentBP >= 70.0 && currentBP < 80.0)
		{
			Reward invisi = new InvisibilityHelmet(believer.getPlayer(), "Your powers grow strong whe I grow strong. Praise me and feel it.", null);
			invisi.execute();
		}
		else if(previousBP < 80.0 && currentBP >= 80.0 && currentBP < 90.0)
		{
			Reward luckHat = new LuckyHelmet(believer.getPlayer(), "You luck has increased just as your chnace of survival increased when you started praising me.", null);
			luckHat.execute();
		}
		else if(previousBP < 90.0 && currentBP >= 90.0 && currentBP < 100.0)
		{
			Reward teleport = new TeleportReward(believer.getPlayer(), "When you follow the strongest God, you are rewarded with gifts that are far beyond your comprehension.", null);
			teleport.execute();
		}
		else if(previousBP < 100.0 && currentBP >= 100.0 && currentBP < 110.0)
		{
			Reward lightining = new LightningAttack(believer.getPlayer(), "Rise, my child, and smite our enemies.");
			lightining.execute();
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
		case COW : 
			cowKilled(believer, e);
		    break;
		case VILLAGER : 
			villagerKilled(believer, e);
		    break;
	 
		case ENDER_DRAGON : 
			enderdragonKilled(believer, e);
		    break;
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
	 
	 
	 
		default:
			break;
		}
	}
	
	//private void playerDied(Believer beliver, PlayerDeathEvent e)

	/**
	 * Cow Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void cowKilled(Believer believer, EntityDeathEvent e) 
	{

		believer.decreaseBeliefPower(believer.getGod(), 1);
		Punishment punish = new Explode(believer.getPlayer(), "There is but one I ask you do not kill, for it is sacred to me. How dare you go against that.");
		punish.execute();
		
	}
	
	/**
	 * Villager Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void villagerKilled(Believer believer, EntityDeathEvent e) 
	{

		believer.decreaseBeliefPower(believer.getGod(), 1);
		Punishment punish = new Death(believer.getPlayer(), "The villagers were made in my image. Do not disrespect my image!");
		punish.execute();
		
	}
	
	/**
	 * Ender Dragon Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void enderdragonKilled(Believer believer, EntityDeathEvent e) 
	{

		believer.decreaseBeliefPower(believer.getGod(), 1);
		Punishment punish = new InfiniteFire(believer.getPlayer(), "How dare you slay the most powerful beast. BE ASHAMED.");
		punish.execute();
		
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
			believer.increaseBeliefPower(believer.getGod(), 1);
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
			believer.increaseBeliefPower(believer.getGod(), 2);
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
			believer.increaseBeliefPower(believer.getGod(), 3);

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
			believer.increaseBeliefPower(believer.getGod(), 2);
			
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
	/**
	 * Gets the believers.
	 *
	 * @return the believers
	 */
	public ArrayList<Believer> getBelievers() {
		return Zeus.believers;
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
		Zeus.believers = believers;
	}
	


}

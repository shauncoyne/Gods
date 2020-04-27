/*
 * 
 */
package com.CS4398.spc51.gods.gods;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.powerup.Powerup;
import com.CS4398.spc51.gods.powerup.Pray;
import com.CS4398.spc51.gods.punishment.Explode;
import com.CS4398.spc51.gods.punishment.InfiniteFire;
import com.CS4398.spc51.gods.punishment.Punishment;
import com.CS4398.spc51.gods.punishment.TeleportPunishment;
import com.CS4398.spc51.gods.reward.Flyer;
import com.CS4398.spc51.gods.reward.GiveItem;
import com.CS4398.spc51.gods.reward.Invisibility;
import com.CS4398.spc51.gods.reward.LightningAttack;
import com.CS4398.spc51.gods.reward.EnchantedBoots;
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
		case 15: Reward giveNext = new GiveItem(believer.getPlayer(), "Please take this small gift of appreciation");
				giveNext.execute();
				break;
		case 20: Reward giveAgain = new GiveItem(believer.getPlayer(), "Please enjoy this");
				giveAgain.execute();
				break;
		case 30: Reward giveAnother = new GiveItem(believer.getPlayer(), "I appreciate you, young one");
				giveAnother.execute();
				break;
		case 40: //Reward leggings - new EnchantedLeggings(believer.getPlayer(), "Be safe, young one.", leggings, LOOT_BONUS_MOBS);
				//leggings.execute();
				break;
		case 50: 
				break;
		case 60://Reward helmet - new EnchantedHelmet(believer.getPlayer(), "Be safe, young one.", helmet, LOOT_BONUS_MOBS);
				//helmet.execute();
				break;
		case 69: 	
					break;
		case 70: //Reward boots = new EnchantedBoots(believer.getPlayer(), "Be safe, young one.", BOOTS);
				//boots.execute();
				break;
		case 80: //Reward chestplate - new EnchantedChestplate(believer.getPlayer(), "Be safe, young one.", chestPlate, LOOT_BONUS_MOBS);
				//chestplate.execute();
				break;
		case 90: 	//Reward sword - new EnchantedSword(believer.getPlayer(), "Be safe, young one.", sword, LOOT_BONUS_MOBS);
					//sword.execute();
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
		
		  case COW : 
			  cowKilled(believer, e); 
			  break; 
		  case HORSE :
			  horseKilled(believer, e); 
			  break; 
		  case CREEPER : 
			  creeperKilled(believer,e);
		  	  break;
//		 
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
	
	/**
	 * Cow Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void cowKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.increaseBeliefPower(believer.getGod(), 1);
			ItemStack item = new ItemStack(Material.EGG);
			Reward reward = new GiveItem(believer.getPlayer(), "Cows are a sutible means of gaining nutrients when they are killed and harvested. I approve....for now", item);
			reward.execute();
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
			believer.increaseBeliefPower(believer.getGod(), 2);
			ItemStack item = new ItemStack(Material.EGG);
			Reward reward = new GiveItem(believer.getPlayer(), "You have killed one of my brother's dastardly creations...I approve.", item);
			reward.execute();
			
		}
		
	}
	
	/**
	 * Creeper Killed.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void creeperKilled(Believer believer, EntityDeathEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.increaseBeliefPower(believer.getGod(), 1);
			ItemStack item = new ItemStack(Material.CAKE);
			Reward reward = new GiveItem(believer.getPlayer(), "You have taken down another enemy. This has pleased me. I hope you didn't die.", item);
			reward.execute();
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

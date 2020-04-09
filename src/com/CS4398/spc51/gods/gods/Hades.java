/*
 * 
 */
package com.CS4398.spc51.gods.gods;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.powerup.Powerup;
import com.CS4398.spc51.gods.reward.Flyer;
import com.CS4398.spc51.gods.reward.GiveItem;
import com.CS4398.spc51.gods.reward.Invisibility;
import com.CS4398.spc51.gods.reward.LightningAttack;
import com.CS4398.spc51.gods.reward.Reward;

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
        case "EntityDamageByEntityEvent":  
        		playerDamagedEntity(believer, (EntityDamageByEntityEvent) e);
                 break;
		}
		
	}
	

	public void reward(int previousBP, int currentBP, Believer believer)

	{
		switch(currentBP)
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
		case 50: Reward invisible = new Invisibility(believer.getPlayer(), "You have been good to me and my purpose");
				invisible.execute();
				break;
		case 60://Reward helmet - new EnchantedHelmet(believer.getPlayer(), "Be safe, young one.", helmet, LOOT_BONUS_MOBS);
				//helmet.execute();
				break;
		case 69: 	Reward lightning = new LightningAttack(believer.getPlayer(), "You now behold my power. Smite them all!");
					lightning.execute();
					break;
		case 70: //Reward boots - new EnchantedBoots(believer.getPlayer(), "Be safe, young one.", boots, LOOT_BONUS_MOBS);
				//boots.execute();
				break;
		case 80: //Reward chestplate - new EnchantedChestplate(believer.getPlayer(), "Be safe, young one.", chestPlate, LOOT_BONUS_MOBS);
				//chestplate.execute();
				break;
		case 90: 	//Reward sword - new EnchantedSword(believer.getPlayer(), "Be safe, young one.", sword, LOOT_BONUS_MOBS);
					//sword.execute();
					break;
		case 100:	Reward flyer = new Flyer(believer.getPlayer(), "Fly, my son. See the world as your creator intended.");
					flyer.execute();
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
	private void playerDamagedEntity(Believer believer, EntityDamageByEntityEvent e) 
	{
		//I can't think of a good way to make a switch statement here.
		//you could investigate this if you like
		if (e.getEntityType() == EntityType.SHEEP) 
		{
			sheepDamaged(believer, e);
		}
		
	}

	/**
	 * Sheep damaged.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void sheepDamaged(Believer believer, EntityDamageByEntityEvent e) 
	{
		//Small methods best. This allows us to change Zeus' reaction to damaging sheep
		
		//only take action if damage resulted in death
		if (e.getEntity().isDead()) 
		{
			//believer.decreaseBeliefPower(believer.getGod(), 1); // 1 is the smallest int. The bigger the int, the bigger the decrease
			//believer.getPlayer().sendMessage("You have killed a sheep, I don't like this"); //Actually, we make a punishment object here.
			
			////OR////
			
			believer.increaseBeliefPower(believer.getGod(), 1);
			ItemStack item = new ItemStack(Material.BAKED_POTATO);
			Reward reward = new GiveItem(believer.getPlayer(), "I, Zues, accept your sacrafice", item);
			reward.execute(); //this returns a boolean if it was successful. This is important for rewards that are delayed. (false if player offline for example)
		}
		
	}

	@Override
	public Collection<? extends Powerup> getPowerUps(int rank) {

		ArrayList<PowerUp>[]thing = new;
		ArrayList<PowerUp>();
		
		
		switch(rank)
		{
		case 1:
			break;
			default break;
		}
		return thing;
		// TODO Auto-generated method stub
		//return null;
		// TODO Auto-generated method stub
		return null;
	}


}
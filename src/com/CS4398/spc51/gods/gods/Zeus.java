package com.CS4398.spc51.gods.gods;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.reward.Flyer;
import com.CS4398.spc51.gods.reward.GiveItem;
import com.CS4398.spc51.gods.reward.Invisibility;
import com.CS4398.spc51.gods.reward.LightningAttack;
import com.CS4398.spc51.gods.reward.Reward;

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
		//switch based on the type of event
		switch (e.getEventName()) 
		{
        case "EntityDamageByEntityEvent":  
        		playerDamagedEntity(believer, (EntityDamageByEntityEvent) e);
                 break;
       // case "PlayerDeathEvent":
        	//playerDied(believer, (PlayerDeathEvent)e);
        	//break;
                 
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
		switch(e.getEntityType())
		{
		case SHEEP : sheepDamaged(believer, e);
		     break;
		case COW : cowDamaged(believer, e);
	         break;
		case HORSE : horseDamaged(believer, e);
	         break;
		case CREEPER : creeperDamaged(believer,e);
		default:
			break;
		}
	}
	
	//private void playerDied(Believer beliver, PlayerDeathEvent e)

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
			believer.increaseBeliefPower(believer.getGod(), 1);
			ItemStack item = new ItemStack(Material.BAKED_POTATO);
			Reward reward = new GiveItem(believer.getPlayer(), "Thank you for providing me with more sheep in my little sheep heaven!", item);
			reward.execute();
		}
		
		
	}
	
	/**
	 * Cow damaged.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void cowDamaged(Believer believer, EntityDamageByEntityEvent e) 
	{
		//Small methods best. This allows us to change Zeus' reaction to damaging sheep
		
		//only take action if damage resulted in death
		if (e.getEntity().isDead()) 
		{
			believer.increaseBeliefPower(believer.getGod(), 1);
			ItemStack item = new ItemStack(Material.EGG);
			Reward reward = new GiveItem(believer.getPlayer(), "I really do love it when you kill cows.", item);
			reward.execute(); //this returns a boolean if it was successful. This is important for rewards that are delayed. (false if player offline for example)
		}
		
		
	}
	
	/**
	 * Horse damaged.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void horseDamaged(Believer believer, EntityDamageByEntityEvent e) 
	{
		//Small methods best. This allows us to change Zeus' reaction to damaging sheep
		
		//only take action if damage resulted in death
		if (e.getEntity().isDead()) 
		{
			believer.decreaseBeliefPower(believer.getGod(), 1);
			//ItemStack item = new ItemStack(Material.DIRT);
			//Punishment punishment = new GiveItem(believer.getPlayer(), "I have been angered by your actions. How dare you kill my little pet! My friend. My brother.", item);
			//punishment.execute();
			//removed for errors
			
		}
		
	}
	
	/**
	 * Creeper damaged.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void creeperDamaged(Believer believer, EntityDamageByEntityEvent e) 
	{
		if (e.getEntity().isDead()) 
		{
			believer.increaseBeliefPower(believer.getGod(), 1);
			ItemStack item = new ItemStack(Material.CAKE);
			Reward reward = new GiveItem(believer.getPlayer(), "You have taken down another enemy. This has pleased me. I hope you didn't die.", item);
			reward.execute();
		}
		
	}
	


}

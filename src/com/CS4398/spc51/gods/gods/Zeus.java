package com.CS4398.spc51.gods.gods;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.reward.GiveItem;
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
	
	public void reward(float previousBP, float currentBP)
	{
		
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

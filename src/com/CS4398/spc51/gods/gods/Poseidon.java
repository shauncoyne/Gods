package com.CS4398.spc51.gods.gods;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.reward.GiveItem;
import com.CS4398.spc51.gods.reward.Reward;

/**
 * The Class Poseidon. Put his info here
 */
public class Poseidon extends God{

	/**
	 * Instantiates a new zeus.
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
        case "EntityDamageByEntityEvent":  
        		playerDamagedEntity(believer, (EntityDamageByEntityEvent) e);
                 break;
        //case "VehicleCreateEvent" :
        default:
        	break;
        	
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
	private void playerDamagedEntity(Believer believer, EntityDamageByEntityEvent e) {
		//I can't think of a good way to make a switch statement here.
		//you could investigate this if you like
		if (e.getEntityType() == EntityType.SHEEP) {
			sheepDamaged(believer, e);
		}
		
	}

	/**
	 * Sheep damaged.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	private void sheepDamaged(Believer believer, EntityDamageByEntityEvent e) {
		//Small methods best. This allows us to change Zeus' reaction to damaging sheep
		
		//only take action if damage resulted in death
		if (e.getEntity().isDead()) {
			believer.decreaseBeliefPower(believer.getGod(), 1); // 1 is the smallest int. The bigger the int, the bigger the decrease
			believer.getPlayer().sendMessage("You have killed a sheep, I don't like this"); //Actually, we make a punishment object here.
			
			////OR////
			
			believer.increaseBeliefPower(believer.getGod(), 1);
			ItemStack item = new ItemStack(Material.BAKED_POTATO);
			Reward reward = new GiveItem(believer.getPlayer(), "I, Zues, accept your sacrafice", item);
			reward.execute(); //this returns a boolean if it was successful. This is important for rewards that are delayed. (false if player offline for example)
		}
		
	}


}
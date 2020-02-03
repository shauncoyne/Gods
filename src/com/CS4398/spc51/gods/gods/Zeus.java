package com.CS4398.spc51.gods.gods;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.CS4398.spc51.gods.Believer;

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
	public void observe(Believer believer, Event e) {
		//switch based on the type of event
		switch (e.getEventName()) {
        case "EntityDamageByEntityEvent":  
        		playerDamagedEntity(believer, (EntityDamageByEntityEvent) e);
                 break;
		}
		
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
			believer.getPlayer().sendMessage("You have killed a sheep, I don't like this");
		}
		
	}


}

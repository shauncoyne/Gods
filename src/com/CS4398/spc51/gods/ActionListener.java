/*
 * 
 */
package com.CS4398.spc51.gods;

import java.awt.event.ActionEvent;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.CS4398.spc51.gods.alter.Alter;
import com.CS4398.spc51.gods.alter.AlterManager;
import com.CS4398.spc51.gods.gods.Atheist;


// TODO: Auto-generated Javadoc
/**
 * 
 *  * The listener interface for receiving action events.
 * The class that is interested in processing an action
 * event relevant to Gods. It will identify the god it
 * needs to pass the event to, unless the believer is an
 * Atheist. At this point we pick a god at random to send
 * it to.
 * 
 * 
 * The listener interface for receiving action events.
 * The class that is interested in processing a action
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addActionListener<code> method. When
 * the action event occurs, that object's appropriate
 * method is invoked.
 *
 * @author Shaun Coyne (spc51)
 * 
 * @see ActionEvent
 */
public class ActionListener implements Listener{
		
		
		/**
		 * Entity damage by entity.
		 *
		 * @param e the entity that got damaged
		 */
		@EventHandler
		public void EntityDeathEvent(EntityDeathEvent e) {
			LivingEntity killed = e.getEntity();
		    EntityDamageEvent damageEvent = killed.getLastDamageCause();
		    if (damageEvent instanceof EntityDamageByEntityEvent)
		    {
		        EntityDamageByEntityEvent damageByEvent = (EntityDamageByEntityEvent)damageEvent;
				if (damageByEvent.getDamager() instanceof Player) {
					Believer believer = Believer.getBeliever(damageByEvent.getDamager().getUniqueId());
					if (!(believer.getGod() instanceof Atheist)) {
						for (Alter alter : AlterManager.alterList) {
							if(alter.getGod().getClass() == believer.getGod().getClass()) {
								if(alter.near(e.getEntity().getLocation())){
									SacrificeEvent sacrafice = new SacrificeEvent(e, alter); //TODO fix this
									alter.getGod().observe(believer, sacrafice);
									return;
								}
							}
		
						}
						believer.getGod().observe(believer, e);
					}
			}

				
		}
		}
			
		
	     /**
     	 * On player join. When a play joins we need to load or create a believer object and add it to the believer list. 
     	 * This method also welcomes the player back to the server
     	 *
     	 * @param e the player that joined
     	 */
     	@EventHandler
	     public void onPlayerJoin(PlayerJoinEvent e){
	    	 Believer.loadBeliever(e.getPlayer());
	    	 e.getPlayer().sendMessage("Welcome Back!");
	     }
	     
	     
		

	

}

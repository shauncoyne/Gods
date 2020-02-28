package com.CS4398.spc51.gods;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.CS4398.spc51.gods.alter.Alter;
import com.CS4398.spc51.gods.alter.AlterManager;
import com.CS4398.spc51.gods.gods.Atheist;
import com.CS4398.spc51.gods.gods.God;


/**
 * The listener interface for receiving action events.
 * The class that is interested in processing an action
 * event relevant to Gods. It will identify the god it
 * needs to pass the event to, unless the believer is an
 * Atheist. At this point we pick a god at random to send
 * it to
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
		public void EntityDamageByEntity(EntityDamageByEntityEvent e) {
			if (e.getDamager() instanceof Player) {
				Believer believer = Believer.getBeliever(e.getDamager().getUniqueId());
				if (!(believer.getGod() instanceof Atheist)) {
					for (Alter alter : AlterManager.alterList) {
						if(alter.getGod().getClass() == believer.getGod().getClass()) {
							if(alter.near(e.getEntity().getLocation())){
								SacrificeEvent sacrafice = new SacrificeEvent(e, alter);
								alter.getGod().observe(believer, sacrafice);
								return;
							}
						}

					}
					believer.getGod().observe(believer, e);
				}

				
		}
		}
			
		
	     @EventHandler
	     public void onPlayerJoin(PlayerJoinEvent e){
	    	 Believer.loadBeliever(e.getPlayer());
	     }
	     
	     
		

	

}

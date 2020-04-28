/*
 * 
 */
package com.CS4398.spc51.gods;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving chat events.
 * The class that is interested in processing a chat
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addChatListener<code> method. When
 * the chat event occurs, that object's appropriate
 * method is invoked.
 *
 * @author Shaun Coyne (spc51)
 * The listener interface for receiving chat events.
 * The class that is interested in processing a chat
 * event that references the Gods, or includes things
 * that may anger the gods such as cursing. 
 * @see ChatEvent
 */
public class ChatListener implements Listener{
	
	
	/**
	 * Async chat event.
	 *
	 * @param e the chat event contents
	 */
	@EventHandler
	public void AsyncChatEvent(AsyncPlayerChatEvent e) {
		
		
	}
	

}

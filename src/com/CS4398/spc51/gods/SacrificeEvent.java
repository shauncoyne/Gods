/*
 * 
 */
package com.CS4398.spc51.gods;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import com.CS4398.spc51.gods.alter.Alter;

// TODO: Auto-generated Javadoc
/**
 * @author Shaun Coyne (spc51)
 * The Class SacrificeEvent.
 */
public class SacrificeEvent extends Event implements Cancellable {
    
    /** The alter. */
    private Alter alter;
    
    /** The e. */
    private EntityDeathEvent e;
    
    /** The Constant HANDLERS_LIST. */
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    
    /** The is cancelled. */
    private boolean isCancelled;

    /**
     * Instantiates a new sacrifice event.
     *
     * @param e the e
     * @param alter the alter
     */
    public SacrificeEvent(EntityDeathEvent e, Alter alter){
        this.e = e;
        this.alter = alter;
        this.isCancelled = false;
    }

    /**
     * Checks if is cancelled.
     *
     * @return true, if is cancelled
     */
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Sets the cancelled.
     *
     * @param cancelled the new cancelled
     */
    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    /**
     * Gets the handlers.
     *
     * @return the handlers
     */
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    /**
     * Gets the handler list.
     *
     * @return the handler list
     */
    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

   // public EntityDamageByEntityEvent getEntityDamageByEntityEvent() {
        //return e;
   /**
    * Gets the alter.
    *
    * @return the alter
    */
   // }
    public Alter getAlter() {
    	return alter;
    }


}
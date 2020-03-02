package com.CS4398.spc51.gods;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import com.CS4398.spc51.gods.alter.Alter;

public class SacrificeEvent extends Event implements Cancellable {
    private Alter alter;
    private EntityDeathEvent e;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;

    public SacrificeEvent(EntityDeathEvent e, Alter alter){
        this.e = e;
        this.alter = alter;
        this.isCancelled = false;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

   // public EntityDamageByEntityEvent getEntityDamageByEntityEvent() {
        //return e;
   // }
    public Alter getAlter() {
    	return alter;
    }


}
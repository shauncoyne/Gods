/*
 * 
 */
package com.CS4398.spc51.gods.gods;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.powerup.Powerup;

// TODO: Auto-generated Javadoc
/*
 * Gods will be created via code, not config. This is because we want gods to be unique.
 * Their punishments and powers should be unique to some extent. 
 * We will enable the ability the change the name
 * We may enable the ability to change the dialog
 * 
 * 
 * What would be harder to do, is not hardcode the gods and instead make a god builder. 
 * where server owners could configure all the aspects of a god. This isn't as fun.
 */

/**
 * The Class God.
 *
 * @author Shaun Coyne (spc51)
 * The Class God.
 */
public abstract class God {
	
	/** The name. */
	private String name;
	//hello test
	
	/** The religion. */
	private String religion;
	

	
	/** The player enemies. */
	private ArrayList enemies;

	/**
	 * Instantiates a new god.
	 *
	 * @param name the name
	 * @param religion the religion
	 */
	public God(String name, String religion) {
		this.setName(name);
		this.religion = religion;
	}
	
	/**
	 * Observe.
	 *
	 * @param believer the believer
	 * @param e the entity
	 */
	public abstract void observe(Believer believer, Event e);
	
	/**
	 * Reward.
	 *
	 * @param previousBP the previous BP
	 * @param currentBP the current BP
	 * @param believer the believer
	 */
	public abstract void reward(float previousBP, float currentBP, Believer believer);

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the power ups.
	 *
	 * @param rank the rank
	 * @return the power ups
	 */
	public abstract Collection<? extends Powerup> getPowerUps(int rank);

	public abstract Object getBelievers();

	protected abstract void getRank(float beliefPower);


	

	
	

}

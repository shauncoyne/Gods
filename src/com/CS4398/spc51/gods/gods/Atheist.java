/*
 * 
 */
package com.CS4398.spc51.gods.gods;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.event.Event;

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.powerup.Powerup;

// TODO: Auto-generated Javadoc
/**
 * @author Shaun Coyne (spc51)
 * The Class Atheist.
 */
public class Atheist extends God{

	/**
	 * Instantiates a new atheist.
	 */
	public Atheist() {
		super("atheist", "none");
		// TODO Auto-generated constructor stub
	}

	/**
	 * Observe.
	 *
	 * @param believer the believer
	 * @param e the e
	 */
	@Override
	public void observe(Believer believer, Event e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Reward.
	 *
	 * @param previousBP the previous BP
	 * @param currentBP the current BP
	 */
	@Override
	public void reward(float previousBP, float currentBP, Believer believer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<? extends Powerup> getPowerUps(int rank) {
		ArrayList<PowerUp>()thing = new;
		ArrayList<PowerUp>();
		return thing;
		// TODO Auto-generated method stub
		//return null;
	}

}

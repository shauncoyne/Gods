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
 * The Class Atheist.
 *
 * @author Shaun Coyne (spc51)
 * The Class Atheist.
 */
public class Atheist extends God{
	
	private static ArrayList<Believer> believers = new ArrayList<Believer>();

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
	 * @param believer the believer
	 */
	@Override
	public void reward(float previousBP, float currentBP, Believer believer) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Gets the power ups.
	 *
	 * @param rank the rank
	 * @return the power ups
	 */
	@Override
	public Collection<? extends Powerup> getPowerUps(int rank) {
		ArrayList<Powerup>thing = new ArrayList<Powerup>();
		
		
		return thing;
		// TODO Auto-generated method stub
		//return null;
	}
	
	/**
	 * Gets the believers.
	 *
	 * @return the believers
	 */
	public ArrayList<Believer> getBelievers() {
		return Atheist.believers;
	}
	public static void addBeliever(Believer b) {
		believers.add(b);
	}
	public static void removeBeliever(Believer b) {
		believers.remove(b);
	}

	/**
	 * Sets the believers.
	 *
	 * @param believers the new believers
	 */
	public static void setBelievers(ArrayList<Believer> believers) {
		Atheist.believers = believers;
	}

}

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
	@Override
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

	@Override
	public int getRank(float beliefPower) {
		if(beliefPower >= 11 && beliefPower < 21)
			return 1;
		if(beliefPower >= 21 && beliefPower < 31)
			return 2;
		if(beliefPower >= 31 && beliefPower < 41)
			return 3;
		if(beliefPower >= 41 && beliefPower < 51)
			return 4;
		if(beliefPower >= 51 && beliefPower < 61)
			return 5;
		if(beliefPower >= 61 && beliefPower < 71)
			return 6;
		if(beliefPower >= 71 && beliefPower < 81)
			return 7;
		if(beliefPower >= 81 && beliefPower < 91)
			return 8;
		if(beliefPower >= 91 && beliefPower < 101)
			return 9;
		if(beliefPower >= 101)
			return 10;
		else
			return 0;
	}

}

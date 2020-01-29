package com.CS4398.spc51.gods.alter;

import java.util.HashMap;
import java.util.UUID;

import com.CS4398.spc51.gods.gods.God;


/**
 * The Class Alter.
 */
public class Alter {
	
	/** The god. */
	private God god;
	
	/** The creater UUID. */
	private UUID createrUUID;
	
	/** The random phrases the god may say. */
	private HashMap phrases; 
	
	/** The responses specific responses the god says on certain interactions. */
	private HashMap responses; 
	
	/**
	 * Instantiates a new alter.
	 *
	 * @param createrUUID the creater UUID
	 * @param god the god
	 */
	public Alter(UUID createrUUID, God god) {
		this.god = god;
		this.createrUUID = createrUUID;
		
	}

}

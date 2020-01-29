package com.CS4398.spc51.gods.alter;

import java.util.HashMap;
import java.util.UUID;

import com.CS4398.spc51.gods.gods.God;

public class Alter {
	private God god;
	private UUID createrUUID;
	private HashMap phrases; //random phrases the god may say
	private HashMap responses; //specific responses the god says on certain interactions
	
	public Alter(UUID createrUUID, God god) {
		this.god = god;
		this.createrUUID = createrUUID;
		
	}

}

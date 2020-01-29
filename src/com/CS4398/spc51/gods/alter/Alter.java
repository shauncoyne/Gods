package com.CS4398.spc51.gods.alter;

import java.util.UUID;

import com.CS4398.spc51.gods.gods.God;

public class Alter {
	private God god;
	private UUID createrUUID;
	
	public Alter(UUID createrUUID, God god) {
		this.god = god;
		this.createrUUID = createrUUID;
		
	}

}

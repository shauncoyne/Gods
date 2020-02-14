package com.CS4398.asb104.gods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.bukkit.plugin.java.JavaPlugin;

import com.CS4398.spc51.gods.Gods;


/*
 * Notes for future tests:
 * 
 * Need to check various testing abilities.
 * 
 * Simulate a player join
 * simulate a player death
 * simulate a player kills mob
 * simulate a player breaks block ////this might be hard
 * simulate a player places a block ///this might be hard
 * simulate a player chat event
 * simulate a player command event
 * 
 */

public class GodsTest {

	@Before
	public void setup() {
		
	}
	
	@Test
	public void VariableCreation() {
		Gods testGod = new Gods();
		Gods gods = new Gods();
		assertEquals(testGod, gods);
	}

}

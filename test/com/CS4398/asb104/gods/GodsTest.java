package com.CS4398.asb104.gods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.bukkit.plugin.java.JavaPlugin;

import com.CS4398.spc51.gods.Gods;


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

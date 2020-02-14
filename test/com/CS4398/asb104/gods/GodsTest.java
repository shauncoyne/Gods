package com.CS4398.asb104.gods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.bukkit.plugin.java.JavaPlugin;

import com.CS4398.spc51.gods.Gods;


import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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

@PowerMockIgnore("org.mockito.*")
//@RunWith(PowerMockRunner.class)
@PrepareForTest(PlayerJoinEvent.class)
public class GodsTest {

	@Before
	public void setup() {
	}
	
	@Test
    public void testOnPlayerJoin() {
        
   }

}
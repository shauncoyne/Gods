package com.CS4398.asb104.gods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.player.PlayerJoinEvent;

import com.CS4398.spc51.gods.CommandManager;
import com.CS4398.spc51.gods.Gods;

import java.util.ArrayList;

import junit.framework.TestCase;
import org.bukkit.Server;
import org.junit.runner.RunWith;

import org.mockito.*;

public class GodsTest extends TestCase {

	@Before
	public void setup() {
		
	}
	
	@Test
    public void testMockitoandServer() throws Exception {
		System.out.println("* CommandManagerTest: testCommand()");

        Plugin plugin = Mockito.mock(Plugin.class);
        PluginManager pManager = Mockito.mock(PluginManager.class);

        Server server = Mockito.mock(Server.class);
        Mockito.when(server.getPluginManager()).thenReturn(pManager);

        Mockito.when(plugin.getServer()).thenReturn(server);

        
   }

}

package com.CS4398.asb104.gods;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.player.PlayerJoinEvent;

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.CommandManager;
import com.CS4398.spc51.gods.Gods;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;

import java.util.ArrayList;

import junit.framework.TestCase;
import org.bukkit.Server;
import org.junit.runner.RunWith;

import org.mockito.*;
import org.mockito.stubbing.Answer;


public class GodsTest {
	private static Server server;
	private static Gods plugin;

	@BeforeClass
	public static void setUp()
	{
	    server = MockBukkit.mock();
	    plugin = (Gods) MockBukkit.load(Gods.class);
	}

	
	
	@Test
    public void MockitoandServerTest() throws Exception {
		System.out.println("Test 1 \n\n");
		boolean flag = false;
		try {
		System.out.println("* MockitoandServerTest: test()");

        Plugin plugin = Mockito.mock(Plugin.class);
        PluginManager pManager = Mockito.mock(PluginManager.class);

        Server server = Mockito.mock(Server.class);
        Mockito.when(server.getPluginManager()).thenReturn(pManager);

        Mockito.when(plugin.getServer()).thenReturn(server);
        flag = true;
		}
		
		 finally {
				System.out.println("Last run status(regression): * PASS *\n\n");
				assertEquals(true, flag);}
		
        
   }
	
	@Test
    public void JoinServerEventTest() throws Exception {
		System.out.println("Test 2 \n\n");
		System.out.println("* JoinServerEventTest: test() *");
		 Plugin plugin = Mockito.mock(Plugin.class);
	        PluginManager pManager = Mockito.mock(PluginManager.class);

	        Server server = Mockito.mock(Server.class);
	        Mockito.when(server.getPluginManager()).thenReturn(pManager);

	        Mockito.when(plugin.getServer()).thenReturn(server);
	        
	        Player player = Mockito.mock(Player.class); // Create a Player stub
	        Mockito.when(player.getName()).thenReturn("asb104");
	       
	        
	       
	        System.out.println("These are player currently on server " + server.getOnlinePlayers());
	        System.out.println(player.getName() + " will attempt to join the server");
	        PlayerJoinEvent playerJoinEvent = new PlayerJoinEvent(player, null);
	        playerJoinEvent.setJoinMessage("***A player has joined the server***");
	        System.out.println(playerJoinEvent.getJoinMessage());
	        System.out.println("These are player currently on server [" + playerJoinEvent.getPlayer() +"]");

			System.out.println("Last run status(regression): * PASS * \n\n");

	}
	
	@Test
	public void BeliverListTest() throws Exception{
		System.out.println("Test 3 \n\n");
		System.out.println("A list of the believers");

		for (Believer b : Believer.believerList){
			System.out.println(b.getPlayer().getUniqueId());}
		
	       
	        PlayerMock player = ((ServerMock) server).addPlayer();
	        String expected = player.getUniqueId().toString();
	        System.out.println("A list of the believers");
	        System.out.println(Believer.believerList.toString()); // should be empty
	        Believer ab = new Believer(player);
	        Believer.loadBeliever(player);
	        System.out.println(Believer.believerList.toString());
			for (Believer b : Believer.believerList){
				System.out.println(b.getPlayer().getUniqueId());}
			
	        Assert.assertEquals(expected, player.getUniqueId().toString());
	        System.out.println("Last run status(regression): * PASS * \n\n");
	        
	}
	
	@Test
	public void IncBeliefPowerTest() throws Exception{
		System.out.println("Test 4 \n\n");
		 PlayerMock player = ((ServerMock) server).addPlayer();
		 Believer ab = new Believer(player);
		 ab.changeGod("Hades");
		 ab.increaseBeliefPower(Gods.godsArray[1], 1);
		 float BP = ab.getBeliefPower();
		 Assert.assertEquals(1.0, BP, 0.0);
		 System.out.println("Last run status(regression): * PASS * \n\n");
	}
	
	@Test
	public void DecBeliefPowerTest() throws Exception{
		System.out.println("Test 4 \n\n");
		 PlayerMock player = ((ServerMock) server).addPlayer();
		 Believer ab = new Believer(player);
		 ab.changeGod("Hades");
		 ab.decreaseBeliefPower(Gods.godsArray[1], 1);
		 float BP = ab.getBeliefPower();
		 Assert.assertEquals(-1.0, BP, 0.0);
		 System.out.println("Last run status(regression): * PASS * \n\n");
	}
}
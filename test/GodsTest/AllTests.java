package GodsTest;

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
import java.util.UUID;

import junit.framework.TestCase;
import org.bukkit.Server;
import org.junit.runner.RunWith;

import org.mockito.*;
import org.powermock.*;
import org.powermock.*;

public class AllTests {

	
	@Test
    public void MockitoandServerTest() throws Exception {
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
		
		 finally {assertEquals(true, flag);}
		
        
   }

	@Test
    public void JoinServerEventTest() throws Exception {
		
		System.out.println("* JoinServerEventTest: test()");
		 Plugin plugin = Mockito.mock(Plugin.class);
	        PluginManager pManager = Mockito.mock(PluginManager.class);

	        Server server = Mockito.mock(Server.class);
	        Mockito.when(server.getPluginManager()).thenReturn(pManager);

	        Mockito.when(plugin.getServer()).thenReturn(server);
	        
	        Player player = Mockito.mock(Player.class); // Create a Player stub
	        Mockito.when(player.getName()).thenReturn("asb104");
	        System.out.println(player.getName());
		
	}
	
}

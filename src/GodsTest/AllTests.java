package GodsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.bukkit.plugin.java.JavaPlugin;
import com.CS4398.spc51.gods.*;

import com.CS4398.spc51.gods.Gods;


import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import static org.mockito.Mockito.never;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//@PowerMockIgnore("org.mockito.*")
@RunWith(PowerMockRunner.class)
@PrepareForTest(PlayerJoinEvent.class)

public class AllTests  {

	
	@Before
	public void setup() {
		
	}
	
	@Test
    public void testOnPlayerJoin() {
        
   }
	@Test
	public void testLoginEvent() {
	    Player player = PowerMockito.mock(Player.class); // Create a Player stub
	    PowerMockito.when(player.getName()).thenReturn("asb104"); // Return a username when getName is called
	    PowerMockito.when(player.getUniqueId()).thenReturn(UUID.randomUUID()); // Return a random UUID when getUniqueId is called

	    PlayerJoinEvent event = PowerMockito.mock(PlayerJoinEvent.class); // Create a PlayerJoinEvent stub
	    PowerMockito.when(event.getPlayer()).thenReturn(player); // Return our fake player when getPlayer is called

	   // ActionListener testListener = new ActionListener(); // Obviously change as appropriate
	}

}

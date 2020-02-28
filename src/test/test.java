package test;

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

@PowerMockIgnore("org.mockito.*")
//@RunWith(PowerMockRunner.class)
@PrepareForTest(PlayerJoinEvent.class)
public class test {

	@Before
	public void setup() {
		
	}
	
	@Test
    public void testOnPlayerJoin() throws Exception {
        
   }

}

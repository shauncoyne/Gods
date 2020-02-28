package com.CS4398.spc51.gods.alter;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFertilizeEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.block.SignChangeEvent;


/**
 * The Class AlterManager. Listens for actions on blocks to see if the Alters have been created or destroyed. If this method is inefficent, we could periodically check the alters to see if they are intact.
 */
public class AlterManager implements Listener{
	
	/** The alter list contains all alters. Needs to be populated from
	 * a save file when the plugin is loaded */
	public static ArrayList<Alter> alterList = new ArrayList<Alter>();
	static ArrayList<AlterTemplate> alterTemplateList = new ArrayList<AlterTemplate>();
	private static int maxAlterSize = 20; //the number of layers we look at to find an alter.
	private static String originBlockType = "Emerald";
	
	/**
	 * Instantiates a new alter manager. Loads the save file to populate the 
	 * alterList.
	 */
	public AlterManager() {
		
	}
	
	
	/**
	 * On block break. This is the general catch-all for detecting the destruction of
	 * altars. Should check to see who broke it. Was it sabotage? Or is a believer rebelling. 
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
	}
	
	/**
	 * On block burn. Can natural, can be caused by players. The block is destroyed
	 * when it is burned, so the alter is broken.
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockBurn(BlockBurnEvent event) {
		
	}
	
	/**
	 * On block damage. This is called as the block is being broken
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockDamage(BlockDamageEvent event) {
		
	}
	
	/**
	 * On block explode. Could be natural, could be cause by a player.
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockExplode(BlockExplodeEvent event) {
		
	}
	
	/**
	 * On block fade. Unlikley this will ever occur
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockFade(BlockFadeEvent event) {
		
	}
	
	/**
	 * On block fertilize. This is relevant to wildlife/farming gods 
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockFertilize(BlockFertilizeEvent event) {
		
	}
	
	/**
	 * On block ignite. Always caused by players
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockIgnite(BlockIgniteEvent event) {
		
	}
	
	/**
	 * On block physics. Unlikely to happen, could be related to sand/gravel gods
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockPhysics(BlockPhysicsEvent event) {
		
	}
	
	/**
	 * On block piston. Ultimately caused by a player, but we can't know who
	 * Thus, a clever way to deface an alter without repercussions. 
	 * 
	 * This is also heavily related to gods of machinery and invention.
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockPiston(BlockPistonEvent event) {
		
	}
	
	/**
	 * On block redstone. Heavily related to gods of machinery and invention.
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockRedstone(BlockRedstoneEvent event) {
		
	}
	
	/**
	 * On sign change. This can be used to clearly designate the name of the god.
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onSignChange(SignChangeEvent event) {
		
	}
	
	/**
	 * On note played. Used for music gods
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onNotePlayed(NotePlayEvent event) {
		
	}
	
	/**
	 * Creates the alter.
	 */
	public void createAlter() { 
		
	}
	
	/**
	 * Destroy alter.
	 */
	public void destroyAlter() {
		
	}
	
	/**
	 * Check for alter creation by looking at nearby blocks against templates. 
	 * For efficency, we should check if the player is in alter building mode. 
	 */
	public static void checkForAlterCreation(Block block) {
		
		try {
			Location origin = getOrigin(block);
		} catch (NoOriginException e) {
			return;
		}
		
		for (AlterTemplate alterTemplate : alterTemplateList) {
			Boolean matching = true;
			for (ArrayList<Material> layer : alterTemplate.getTemplate()) {
				int incrementTracker = 0; //this controls which direction we increment in
				int currentX = 0;
				int currentY = 0;
				int currentZ = 0;
				for (Material material : layer) {
					if (block.getLocation().add(currentX, currentY, currentZ) == null ) {
						currentX++;
						currentY++; //TODO fix this, see line 200
						currentZ++;
					}
					else if (block.getLocation().add(currentX, currentY, currentZ).getBlock().getType() == material ) {
						currentX++;
						currentY++;
						currentZ++;					}
					else{
						matching = false;
						currentX++;
						currentY++;
						currentZ++;
					}
				}
			}
			if (matching) {
				//TODO create Alter Here
			}
		}
	}
	
	public static Location getOrigin(Block block) throws NoOriginException{
		//first check if 0 is emerald!
		if (block.getType().name() == originBlockType) {
			return block.getLocation();
		}
		for (int i = -1 * maxAlterSize; i <= maxAlterSize; i++) { 
			if (block.getLocation().add(0, 0, i).getBlock().getType().name() == originBlockType) {
				return block.getLocation().add(0, 0, i);
			}
			if (block.getLocation().add(0, i, 0).getBlock().getType().name() == originBlockType) {
				return block.getLocation().add(0, i, 0);
			}
			if (block.getLocation().add(i, 0, 0).getBlock().getType().name() == originBlockType) {
				return block.getLocation().add(i, 0, 0);
			}
			for (int j = 0; j <= i; j++) {

				if (block.getLocation().add(0, j, i).getBlock().getType().name() == originBlockType) {
					return block.getLocation().add(0, j, i);
				}
				if (block.getLocation().add(j, 0, i).getBlock().getType().name() == originBlockType) {
					return block.getLocation().add(j, 0, i);
				}
				if (block.getLocation().add(j, j, i).getBlock().getType().name() == originBlockType) {
					return block.getLocation().add(j, j, i);
				}
				if (block.getLocation().add(0, i, j).getBlock().getType().name() == originBlockType) {
					return block.getLocation().add(0, i, j);
				}
				if (block.getLocation().add(j, i, 0).getBlock().getType().name() == originBlockType) {
					return block.getLocation().add(j, i, 0);
				}
				if (block.getLocation().add(j, i, j).getBlock().getType().name() == originBlockType) {
					return block.getLocation().add(j, i, j);
				}
				if (block.getLocation().add(i, j, 0).getBlock().getType().name() == originBlockType) {
					return block.getLocation().add(i, j, 0);
				}
				if (block.getLocation().add(i, 0, j).getBlock().getType().name() == originBlockType) {
					return block.getLocation().add(i, 0, j);
				}
				if (block.getLocation().add(i, j, j).getBlock().getType().name() == originBlockType) {
					return block.getLocation().add(i, j, j);
				}
			}
			
				
		}
		throw new NoOriginException("Couldn't find origion, max searching distance reached!");
	}
	

	/**
	 * Gets the alter based on the block.
	 *
	 * @param block the block
	 * @return the alter
	 */
	public Alter getAlter(Block block) {
		return null;
	}
	
	/**
	 * Checks if is in alter at this block.
	 *
	 * @param block the block
	 * @return the boolean
	 */
	public Boolean isInAlter(Block block) {
		return false;
	}
	
}

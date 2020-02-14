package com.CS4398.spc51.gods.alter;

import java.util.ArrayList;

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
 * The Class AlterManager.
 */
public class AlterManager implements Listener{
	
	/** The alter list contains all alters. Needs to be populated from
	 * a save file when the plugin is loaded */
	ArrayList<Alter> alterList = new ArrayList<Alter>();
	
	/**
	 * Instantiates a new alter manager. Loads the save file to populate the 
	 * alterList.
	 */
	public AlterManager() {
		
	}
	
	/**
	 * On block placed. This is the general catch-all for detecting the creation of
	 * altars
	 *
	 * @param event the event
	 */
	@EventHandler
    public void onBlockPlaced(BlockPlaceEvent event){

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
	 */
	public void checkForAlterCreation(Block block) {
		for (Alter alter : alterList) {
			AlterTemplate template = alter.getTemplate();
			AlterBlock alterblock = new AlterBlock(block);
			if
		}
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

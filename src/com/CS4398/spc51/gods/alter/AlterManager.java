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


public class AlterManager implements Listener{
	ArrayList<Alter> alterList = new ArrayList<Alter>();
	
	public AlterManager() {
		
	}
	@EventHandler
    public void onBlockPlaced(BlockPlaceEvent event){

    }
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
	}
	@EventHandler
	public void onBlockBurn(BlockBurnEvent event) {
		
	}
	@EventHandler
	public void onBlockDamage(BlockDamageEvent event) {
		
	}
	@EventHandler
	public void onBlockExplode(BlockExplodeEvent event) {
		
	}
	@EventHandler
	public void onBlockFade(BlockFadeEvent event) {
		
	}
	@EventHandler
	public void onBlockFertilize(BlockFertilizeEvent event) {
		
	}
	@EventHandler
	public void onBlockIgnite(BlockIgniteEvent event) {
		
	}
	@EventHandler
	public void onBlockPhysics(BlockPhysicsEvent event) {
		
	}
	@EventHandler
	public void onBlockPiston(BlockPistonEvent event) {
		
	}
	@EventHandler
	public void onBlockRedstone(BlockRedstoneEvent event) {
		
	}
	@EventHandler
	public void onSignChange(SignChangeEvent event) {
		
	}
	@EventHandler
	public void onNotePlayed(NotePlayEvent event) {
		
	}
	public void createAlter() { 
		
	}
	public void destroyAlter() {
		
	}
	public void checkForAlterCreation() {
		
	}
	public Alter getAlter(Block block) {
		return null;
	}
	public Boolean isInAlter(Block block) {
		return false;
	}
	
}

/*
 * 
 */
package com.CS4398.spc51.gods.alter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
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

import com.CS4398.spc51.gods.Believer;
import com.CS4398.spc51.gods.Gods;
import com.CS4398.spc51.gods.gods.God;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;


// TODO: Auto-generated Javadoc
/**
 * @author Shaun Coyne (spc51)
 * The Class AlterManager. Listens for actions on blocks to see if the Alters have been created or destroyed. If this method is inefficent, we could periodically check the alters to see if they are intact.
 */
public class AlterManager implements Listener{
	
	/** The alter list contains all alters. Needs to be populated from
	 * a save file when the plugin is loaded */
	public static ArrayList<Alter> alterList = new ArrayList<Alter>();
	
	/** The alter template list. */
	static ArrayList<AlterTemplate> alterTemplateList = new ArrayList<AlterTemplate>();
	
	/** The max alter size. */
	private static int maxAlterSize = 20; //the number of layers we look at to find an alter.
	
	/** The origin block type. */

	
	private static Material originBlockMaterial= Material.EMERALD_BLOCK;

	
	public static boolean simpleAlter = true;
	
	/**
	 * Instantiates a new alter manager. Loads the save file to populate the 
	 * alterList.
	 */
	public AlterManager() {
		load();
		
	}
	
	
	private void load() {
		try {

			Gson gson = new Gson();
			ArrayList<Alter> alters = gson.fromJson(new FileReader(Gods.gods.getDataFolder() + File.separator + "alters" + File.separator + "alters" +".data"), ArrayList.class);
			if ( alters == null) {
				System.out.println("ERROR: LOADED NULL FROM JSON");
				return;
			}
			else {
			alterList = alters;
			}
		}
		catch(Exception e) {
			//TODO log error
			System.out.println(e.getMessage());
		}
		
	}


	/**
	 * On block break. This is the general catch-all for detecting the destruction of
	 * altars. Should check to see who broke it. Was it sabotage? Or is a believer rebelling. 
	 *
	 * @param event the event
	 */
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		for ( Alter alter : alterList) {
			if (alter.hit(event.getBlock().getLocation())) {
				alterDamaged(alter, event.getPlayer());
			}
			else if(alter.near(event.getBlock().getLocation())) {
				alterAlmostDamaged(alter, event.getPlayer());
			}			

		}
		
	}
	
	private void alterAlmostDamaged(Alter alter, Player player) {
		for(Believer b : alter.getGod().getBelievers()) {
			if(Bukkit.getPlayer(b.getPlayerUUID()) != null) {
				b.getPlayer().sendMessage("Your God's Alter is being attacked by " + player.getCustomName() +"!");
			}
		}
		
	}


	private void alterDamaged(Alter alter, Player player) {
		alterList.remove(alter);
		for(Believer b : alter.getGod().getBelievers()) {
			if(Bukkit.getPlayer(b.getPlayerUUID()) != null) {
				b.getPlayer().sendMessage("Your God's Alter has been destroyed by " + player.getCustomName() +"!");
			}
		}
		
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
	 *TODO need to use BlockPistonRetractEvent and BlockPistonExtendEvent instead of BlockPistonEvent 
	 *
	 * @param event the event
	 */
	/*
	 * @EventHandler public void onBlockPiston(BlockPistonEvent event) {
	 * 
	 * }
	 */
	
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
	 * @param origin 
	 * @param index 
	 * @param believer 
	 */
	public static void createAlter(Believer believer, int index, Location origin) {
		believer.getPlayer().sendMessage("AlterManager 258");
		ArrayList<AlterBlock> list = new ArrayList<AlterBlock>();
		AlterBlock block = new AlterBlock(origin, Material.EMERALD_BLOCK);
		list.add(block);
		ArrayList<ArrayList<AlterBlock>> super_list = new ArrayList<ArrayList<AlterBlock>>();
		super_list.add(list);
		Alter alter = new Alter(believer.getPlayerUUID(), Gods.godsArray[index], super_list);
		alterList.add(alter);
		believer.getPlayer().sendMessage("You have created an Alter for the god: " + Gods.godsArray[index].getName());
		believer.changeGod(Gods.godsArray[index].getName());
		believer.getPlayer().sendMessage("You now worship me, " + Gods.godsArray[index].getName() + ", the most gracious God. Protect my alter at all costs.");

	}
	
	/**
	 * Destroy alter.
	 */
	public void destroyAlter() {
		
	}
	
	/**
	 * Check for alter creation by looking at nearby blocks against templates. 
	 * For efficency, we should check if the player is in alter building mode.
	 *
	 * @param block the block
	 */
	public static void checkForAlterCreation(Block block, Believer believer) {
		if (simpleAlter) {
			believer.getPlayer().sendMessage("AlterManager 286");
			Location origin = null;
			String name = "null";
			int index = 0;
			if(block.getType().equals(Material.WALL_SIGN) || block.getType().equals(Material.LEGACY_SIGN_POST) || block.getType().equals(Material.SIGN)){
				believer.getPlayer().sendMessage("AlterManager 291");
 
				Sign sign = (Sign) block.getState();
		         String[] ln = sign.getLines();
		         name = checkForGod(ln);
		         if (name.equalsIgnoreCase("null")) {
					believer.getPlayer().sendMessage("No god name.");
		        	 System.out.println("Sign did not contain the gods name.");
		        	 return;
		         }
		         for (int i = 0; i < Gods.godsArray.length; i++) {
		        	 if (Gods.godsArray[i].getName().equalsIgnoreCase(name))
		        	 {
		        		 index = i;
		        	 }
		         }

			}
			try {
				origin = getOrigin(block);
			} catch (NoOriginException e) {
				believer.getPlayer().sendMessage("No origin");

				System.out.println("No origin.");
				return;
			}
			createAlter(believer, index, origin);
			
			
		}
		else {
		
			try {
				Location origin = getOrigin(block);
			} catch (NoOriginException e) {
				return;
			}
			
			for (AlterTemplate alterTemplate : alterTemplateList) {
				Boolean matching = true;
				int layerNumber = 3;
				for (ArrayList<Material> layer : alterTemplate.getTemplate()) {
					int incrementTracker = 0; //this controls which direction we increment in
					int i = 0;
					int currentX = -(layerNumber - 1)/2;
					int currentY = (layerNumber - 1)/2;
					int currentZ = (layerNumber - 1)/2;
					for (Material material : layer) {
						if (block.getLocation().add(currentX, currentY, currentZ) == null ) {
							i++; 
							if (i > layerNumber) {
								currentX = -(layerNumber - 1)/2;
								incrementTracker++;
								if(incrementTracker == 1) {
									currentZ--;
								}
								if(incrementTracker == 2) {
									currentY--;
	
								}
								else {
									incrementTracker = 0;
								}
							}
						}
						else if (block.getLocation().add(currentX, currentY, currentZ).getBlock().getType() == material ) {
							i++; 
							if (i > layerNumber) {
								currentX = -(layerNumber - 1)/2;
								incrementTracker++;
								if(incrementTracker == 1) {
									currentZ--;
								}
								if(incrementTracker == 2) {
									currentY--;
	
								}
								else {
									incrementTracker = 0;
								}
							}				
							}
						else if(isExemptedMaterial(block.getLocation().add(currentX, currentY, currentZ).getBlock().getType())){
							i++; 
							if (i > layerNumber) {
								currentX = -(layerNumber - 1)/2;
								incrementTracker++;
								if(incrementTracker == 1) {
									currentZ--;
								}
								if(incrementTracker == 2) {
									currentY--;
	
								}
								else {
									incrementTracker = 0;
								}
							}
						}
						else{
							matching = false;
							break;
	
						}
					}
				}
				if (matching) {
					//TODO create Alter Here
				}
			}
		}
	}
	
	private static String checkForGod(String[] ln) {
		for (String s : ln) {
			System.out.println(s);
			for (God g: Gods.godsArray) {
				if (s.contains(g.getName()) || s.equalsIgnoreCase(g.getName())) {
					return g.getName();
				}
			}
		}
		
		return "null";
	}


	private static boolean isExemptedMaterial(Material type) {
		if (type == Material.AIR) {
			return true;
		}
		else {
			return false;
		}
	}


	/**
	 * Gets the origin.
	 *
	 * @param block the block
	 * @return the origin
	 * @throws NoOriginException the no origin exception
	 */
	public static Location getOrigin(Block block) throws NoOriginException{
		//first check if 0 is emerald!
		if (block.getType() == originBlockMaterial) {
			return block.getLocation();
		}
		for (int i = -1 * maxAlterSize; i <= maxAlterSize; i++) { 
			if (block.getLocation().add(0, 0, i).getBlock().getType() == originBlockMaterial) {
				return block.getLocation().add(0, 0, i);
			}
			if (block.getLocation().add(0, i, 0).getBlock().getType() == originBlockMaterial) {
				return block.getLocation().add(0, i, 0);
			}
			if (block.getLocation().add(i, 0, 0).getBlock().getType() == originBlockMaterial) {
				return block.getLocation().add(i, 0, 0);
			}
			for (int j = 0; j <= i; j++) {

				if (block.getLocation().add(0, j, i).getBlock().getType() == originBlockMaterial) {
					return block.getLocation().add(0, j, i);
				}
				if (block.getLocation().add(j, 0, i).getBlock().getType() == originBlockMaterial) {
					return block.getLocation().add(j, 0, i);
				}
				if (block.getLocation().add(j, j, i).getBlock().getType() == originBlockMaterial) {
					return block.getLocation().add(j, j, i);
				}
				if (block.getLocation().add(0, i, j).getBlock().getType() == originBlockMaterial) {
					return block.getLocation().add(0, i, j);
				}
				if (block.getLocation().add(j, i, 0).getBlock().getType() == originBlockMaterial) {
					return block.getLocation().add(j, i, 0);
				}
				if (block.getLocation().add(j, i, j).getBlock().getType() == originBlockMaterial) {
					return block.getLocation().add(j, i, j);
				}
				if (block.getLocation().add(i, j, 0).getBlock().getType() == originBlockMaterial) {
					return block.getLocation().add(i, j, 0);
				}
				if (block.getLocation().add(i, 0, j).getBlock().getType() == originBlockMaterial) {
					return block.getLocation().add(i, 0, j);
				}
				if (block.getLocation().add(i, j, j).getBlock().getType() == originBlockMaterial) {
					return block.getLocation().add(i, j, j);
				}
			}
			
				
		}
		throw new NoOriginException("Couldn't find origin, max searching distance reached!");
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


	public static void saveAll() {
		try {
	    	if(!Gods.gods.getDataFolder().exists()) {
	    		Gods.gods.getDataFolder().mkdir();
	    	}
	    	File d = new File(Gods.gods.getDataFolder() + File.separator + "alters");
	    	if(!d.exists())
	    	{
	    		d.mkdir();
	    	}
	    	FileWriter fw = new FileWriter(Gods.gods.getDataFolder() + File.separator + "alters" + File.separator + "alters" +".data");
	    	Gson gson = new Gson();

	        gson.toJson(alterList, fw);
	    	fw.close();

	    } catch (JsonIOException | IOException e) {
	        //TODO log error
	    	System.out.println(e.getMessage());
	    }	
		
	}
	
}

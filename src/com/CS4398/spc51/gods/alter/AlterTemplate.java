/*
 * 
 */
package com.CS4398.spc51.gods.alter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

// TODO: Auto-generated Javadoc
/**
 * The Class AlterTemplate.
 *
 * @author Shaun Coyne (spc51)
 * The Class AlterTemplate contains the layout for alters. 
 * 
 * The algorithm used to determine if a player has created
 * an alter is as follows:
 * 
 * Get the block the player just placed. 
 * Determine if this block is the origin block
 * Procedurally check surrounding blocks if they match the template
 * 
 * 
 * An alter will contain ArrayList<ArrayList<>> which will contain list of layers which is a list of either alterblocks or the string null
 * An alter template will contain an ArrayList<ArrayList<>> which will contain a list of layer which will contain a list of materials
 */
public class AlterTemplate {
	
	/** The origin. */
	private Material origin;
	
	/** The template. */
	private ArrayList<ArrayList<Material>> template = new ArrayList<ArrayList<Material>>();
	
	/**
	 * Gets the template.
	 *
	 * @return the template
	 */
	public ArrayList<ArrayList<Material>> getTemplate() {
		return template;
	}

	/**
	 * Sets the template.
	 *
	 * @param template the new template
	 */
	public void setTemplate(ArrayList<ArrayList<Material>> template) {
		this.template = template;
	}

	/**
	 * Instantiates a new alter template.
	 *
	 * @param templateName the template name
	 */
	public AlterTemplate(String templateName) {
		try {
		File csvFile = new File(templateName + ".csv");
		if (csvFile.isFile()) {
			BufferedReader csvReader = new BufferedReader(new FileReader(templateName + ".csv"));
			String row;
			
				while ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    //this one row should contain all the data
				    if (data[0].compareTo("null") == 0) {
				    	//TODO log error here!
				    }
				    else {
				    this.origin = convertToMaterial(data[0]);
				    for(int i = 3; i < data.length; i = i + 2) {
			    		ArrayList temp = new ArrayList();
				    	for(int j = 0; j < Math.pow(i, i); j++) {
				    		if(j < Math.pow(i,(1/i))) {
				    			//do nothing we want to skip this block
				    		}
				    		else {
				    			if(data[j].compareTo("null") == 0) {
				    				temp.add("null");
				    			}
				    			else {
					    			temp.add(convertToMaterial(data[j])); 
				    			}
				    		}
				    	}
				    	this.template.add(temp);
				    	
				    }
				}
				}
				csvReader.close();
		}
			} catch (IOException e) {
				e.printStackTrace();
			}		
	}

	/**
	 * Convert to material.
	 *
	 * @param string the string
	 * @return the material
	 */
	private Material convertToMaterial(String string) {
		Material material = Material.getMaterial(string); //block ID
		return material;
	}

	/**
	 * Convert to block.
	 *
	 * @param string the string
	 * @return the alter block
	 */
	private AlterBlock convertToBlock(String string) {
	    String[] data = string.split(":");
		Location location = new Location(Bukkit.getWorld(data[0]), Float.parseFloat(data[1]), Float.parseFloat(data[2]), Float.parseFloat(data[3]));//World x y z
		Material material = Material.getMaterial(data[4]); //block ID
		return new AlterBlock(location, material);
	}

}

package com.CS4398.spc51.gods.alter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.block.Block;

/**
 * The Class AlterTemplate contains the layout for alters. 
 * 
 * The algorithm used to determine if a player has created
 * an alter is as follows:
 * 
 * Get the block the player just placed. 
 * Determine if this block is the origin block
 * Procedurally check surrounding blocks if they match the template
 */
public class AlterTemplate {
	
	private Block origin;
	private ArrayList<ArrayList<Block>> template = new ArrayList();
	
	public AlterTemplate(String templateName) {
		try {
		File csvFile = new File(templateName + ".csv");
		if (csvFile.isFile()) {
			BufferedReader csvReader = new BufferedReader(new FileReader(templateName + ".csv"));
			String row;
			
				while ((row = csvReader.readLine()) != null) {
				    String[] data = row.split(",");
				    //this one row should contain all the data
				    this.origin = data[0];//TODO need to convert to block first
				    for(int i = 3; i < data.length; i = i + 2) {
			    		ArrayList temp = new ArrayList();
				    	for(int j = 0; j < Math.pow(i, i); j++) {
				    		if(j < Math.pow(i,(1/i))) {
				    			//do nothing we want to skip this block
				    		}
				    		else {
				    			temp.add(data[j]); //TODO need to convert to block first
				    		}
				    	}
				    	this.template.add(temp);
				    	
				    }
				}
				csvReader.close();
		}
			} catch (IOException e) {
				e.printStackTrace();
			}		
	}

}

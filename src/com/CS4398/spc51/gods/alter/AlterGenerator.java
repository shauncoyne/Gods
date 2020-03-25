package com.CS4398.spc51.gods.alter;
/*
 * This class is used for debugging, design, and research purposes. It is created such that someone can create a floating
 * 10 by 10 structure in the air and have the structure printed to a csv. 
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class AlterGenerator {

public static void generateAlter(Block block) {
		
		try {
			Location origin = AlterManager.getOrigin(block);
		} catch (NoOriginException e) {
			return;
		}
		FileWriter csvWriter =null;
		try {
			csvWriter = new FileWriter("new.csv");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		Boolean matching = true;
		int layerNumber = 3;
		int incrementTracker = 0; //this controls which direction we increment in
		int currentX = -(layerNumber - 1)/2;
		int currentY = (layerNumber - 1)/2;
		int currentZ = (layerNumber - 1)/2;
		for (int i = 0; i < 1000; i++) {
			try {
			csvWriter.append(block.getLocation().add(currentX, currentY, currentZ).getBlock().getLocation().toString());
			csvWriter.append("split");
			csvWriter.append(block.getLocation().add(currentX, currentY, currentZ).getBlock().getType().name());
			csvWriter.append(",");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

				
				
		try {
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (matching) {
			//TODO create Alter Here
		}
		
	}
}

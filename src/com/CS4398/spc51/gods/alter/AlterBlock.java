/*
 * 
 */
package com.CS4398.spc51.gods.alter;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

// TODO: Auto-generated Javadoc
/**
 * @author Shaun Coyne (spc51)
 * The Class AlterBlock.
 */
public class AlterBlock {
	
	/** The location. */
	Location location;
	
	/** The material. */
	Material material;
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Gets the material.
	 *
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * Sets the material.
	 *
	 * @param material the new material
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * Instantiates a new alter block.
	 *
	 * @param location the location
	 * @param material the material
	 */
	public AlterBlock(Location location, Material material) {
		this.location = location;
		this.material = material;
	}

	/**
	 * Instantiates a new alter block.
	 *
	 * @param block the block
	 */
	public AlterBlock(Block block) {
		this.location = block.getLocation();
		this.material = block.getType();
	}
	
	/**
	 * Equals.
	 *
	 * @param alterblock the alterblock
	 * @return true, if successful
	 */
	public boolean equals(AlterBlock alterblock) {
		if(this.location == alterblock.getLocation() && this.material == alterblock.getMaterial()) {
			return true;
		}
		else {
			return false;
		}
	}

}

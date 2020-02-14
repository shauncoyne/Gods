package com.CS4398.spc51.gods.alter;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class AlterBlock {
	Location location;
	Material material;
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public AlterBlock(Location location, Material material) {
		this.location = location;
		this.material = material;
	}

	public AlterBlock(Block block) {
		this.location = block.getLocation();
		this.material = block.getType();
	}
	public boolean equals(AlterBlock alterblock) {
		if(this.location == alterblock.getLocation() && this.material == alterblock.getMaterial()) {
			return true;
		}
		else {
			return false;
		}
	}

}

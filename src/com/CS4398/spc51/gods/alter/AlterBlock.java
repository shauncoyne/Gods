package com.CS4398.spc51.gods.alter;

import org.bukkit.Location;
import org.bukkit.Material;

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

}

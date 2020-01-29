package com.CS4398.spc51.gods.gods;

import java.util.ArrayList;

/*
 * Gods will be created via code, not config. This is because we want gods to be unique.
 * Their punishments and powers should be unique to some extent. 
 * We will enable the ability the change the name
 * We may enable the ability to change the dialog
 * 
 * 
 * What would be harder to do, is not hardcode the gods and instead make a god builder. 
 * where server owners could configure all the aspects of a god. This isn't as fun.
 */

public abstract class God {
	private String name;
	private String religion;
	private ArrayList believers;
	private ArrayList enemies;
	

}

package com.CS4398.spc51.gods;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * The Class CommandManager will listen for all commands and handle Gods
 * plugin commands. 
 */
public class CommandManager implements CommandExecutor{
	

	
	/**
	 * Instantiates a new command manager.

	 */
	public CommandManager() {

	}

	/**
	 * On command, determines if the command is relevant to
	 * this plugin and if so, takes appropriate action.
	 *
	 * @param sender the sender
	 * @param command the command
	 * @param label the label
	 * @param args the args
	 * @return true, if successful
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}

}

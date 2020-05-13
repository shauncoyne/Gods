/*
 * 
 */
package com.CS4398.spc51.gods;

import com.CS4398.spc51.gods.alter.AlterGenerator;
import com.CS4398.spc51.gods.alter.AlterManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class CommandManager.
 *
 * @author Shaun Coyne (spc51)
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
		if (sender instanceof Player) {
			switch (command.getName()) {
				case "gods":
					//do info stuff here
					break;
				case "powerups":
					//do info stuff here
					break;
				case "info":
					//do info stuff here
					break;
				case "generate":
					AlterGenerator.generateAlter(((Player) sender).getLocation().getBlock(), Believer.getBeliever(((Player) sender).getUniqueId()));
				default:
					break;
			}
		}
		return false;
	}

}

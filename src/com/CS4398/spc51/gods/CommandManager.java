/*
 * 
 */
package com.CS4398.spc51.gods;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// TODO: Auto-generated Javadoc
/**
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
			Believer believer = Believer.getBeliever(((Player) sender).getUniqueId());
			if (believer == null) {
				System.out.println("Believer was not loaded! Trying again...");
				Believer.loadBeliever(((Player) sender).getUniqueId());
				believer = Believer.getBeliever(((Player) sender).getUniqueId());
			}
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("worship")){
					believer.changeGod(args[1]);
					return true;
				}
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("info")) {

					String god_name = believer.getGod().getName();
					float belief_power = believer.getBeliefPower();
					int rank = believer.getRank();
					sender.sendMessage("You currently worship: " + god_name);
					sender.sendMessage("Your current belief power is: " + belief_power);
					sender.sendMessage("Your current rank is: " + rank);
				}
				if(args[0].equalsIgnoreCase("build")) {
					believer.startListeningForAlter();
				}
			}
		}
		return false;
	}

}

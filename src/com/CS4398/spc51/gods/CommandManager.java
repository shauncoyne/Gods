package com.CS4398.spc51.gods;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
		if (sender instanceof Player) {
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("worship")){
					Believer.getBeliever(((Player) sender).getUniqueId()).changeGod(args[1]);
					return true;
				}
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("info")) {
					Believer b = Believer.getBeliever(((Player) sender).getUniqueId());
					String god_name = b.getGod().getName();
					float belief_power = b.getBeliefPower();
					int rank = b.getRank();
					sender.sendMessage("You currently worship: " + god_name);
					sender.sendMessage("Your current belief power is: " + belief_power);
					sender.sendMessage("Your current rank is: " + rank);
				}
			}
		}
		return false;
	}

}

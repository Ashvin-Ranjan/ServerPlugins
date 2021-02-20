package vin.ash.donationcommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import vin.ash.donationcommands.Main;

public class SetOnCommand implements CommandExecutor{
	
	private Main plugin;
	
	public SetOnCommand(Main pl) {
		this.plugin = pl;
		pl.getCommand("startcommands").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO: get this to set everything on
		
		return true;
	}
}

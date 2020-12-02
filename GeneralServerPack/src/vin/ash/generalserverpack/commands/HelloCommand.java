package vin.ash.generalserverpack.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import vin.ash.generalserverpack.PluginMainManager;


public class HelloCommand implements CommandExecutor{
	
	private PluginMainManager plugin;
	
	public HelloCommand(PluginMainManager pl) {
		this.plugin = pl;
		plugin.getCommand("hello").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This can only be used by players");
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("hello.use")) {
			p.sendMessage("Hey " + p.getName() + "!");
			return true;
		}
		
		p.sendMessage("You do not have permission to use this command");
		return true;
	}
	
}

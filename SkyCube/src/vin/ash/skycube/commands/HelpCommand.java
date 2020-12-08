package vin.ash.skycube.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import vin.ash.skycube.Main;
import vin.ash.skycube.utils.Utils;

public class HelpCommand implements CommandExecutor{
	
	private Main plugin;
	
	public HelpCommand(Main pl) {
		this.plugin = pl;
		pl.getCommand("helpme").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This can only be used by players");
			return true;
		}
		
		Player p = (Player) sender;
		
		Utils.playerQuickStart(p, plugin);
		
		return true;
	}
}

package vin.ash.skycube.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import vin.ash.skycube.Main;


public class HomeCommand implements CommandExecutor{
	
	private Main plugin;
	
	public HomeCommand(Main pl) {
		this.plugin = pl;
		plugin.getCommand("home").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This can only be used by players");
			return true;
		}
		
		Player p = (Player) sender;
		
		
		p.sendMessage(ChatColor.ITALIC +"Your home is at X: " + p.getBedSpawnLocation().getBlockX() + ", Y: " + p.getBedSpawnLocation().getBlockY() + ", Z: " + p.getBedSpawnLocation().getBlockZ() + ChatColor.RESET);
			
		return true;
	}
	
}

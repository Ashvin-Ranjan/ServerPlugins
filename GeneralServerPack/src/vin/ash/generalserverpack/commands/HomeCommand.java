package vin.ash.generalserverpack.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import vin.ash.generalserverpack.PluginMainManager;


public class HomeCommand implements CommandExecutor{
	
	private PluginMainManager plugin;
	
	public HomeCommand(PluginMainManager pl) {
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
		
		if(args.length == 1) {
			if (args[0].equalsIgnoreCase("set")) {
				int[] playerloc = {p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ()};
				plugin.homeData.put(p.getUniqueId(), playerloc);
				p.sendMessage(ChatColor.GREEN + "Set new home location!" + ChatColor.RESET);
				return true;
			}
			else if(args[0].equalsIgnoreCase("clear")) {
				plugin.homeData.remove(p.getUniqueId());
				p.sendMessage(ChatColor.GREEN +"Home location removed!" + ChatColor.RESET);
				return true;
			}
			else if(!args[0].equalsIgnoreCase("get")) {
				p.sendMessage(ChatColor.RED + "Incorrect Arguments for home" + ChatColor.RESET);
				return true;
			}
		}
		
		if (plugin.homeData.containsKey(p.getUniqueId())) {
			p.sendMessage(ChatColor.ITALIC +"Your home is at X: " + plugin.homeData.get(p.getUniqueId())[0] + ", Y: " + plugin.homeData.get(p.getUniqueId())[1] + ", Z: " + plugin.homeData.get(p.getUniqueId())[2] + ChatColor.RESET);
			return true;
		}
		
		p.sendMessage( ChatColor.RED + "You do not have your home location set. set yours using \"/home set\"" + ChatColor.RESET);
		return true;
	}
	
}

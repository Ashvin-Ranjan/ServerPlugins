package vin.ash.generalserverpack.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import vin.ash.generalserverpack.PluginMainManager;


public class ShareLocationCommand implements CommandExecutor{
	
	private PluginMainManager plugin;
	
	public ShareLocationCommand(PluginMainManager pl) {
		this.plugin = pl;
		plugin.getCommand("sharelocation").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This can only be used by players");
			return true;
		}
		
		Player p = (Player) sender;
		
		if (args.length != 1) {
			p.sendMessage(ChatColor.RED + "Incorrect amount of arguments it is /sharelocation playername" + ChatColor.RESET);
			return true;
		}
		
		Player sendto = (Player) Bukkit.getPlayer(args[0]);
		
		if (sendto == null) {
			p.sendMessage(ChatColor.RED + "Player not found!" + ChatColor.RESET);
			return true;
		}
		
		sendto.sendMessage(ChatColor.ITALIC + p.getName() + "'s whispers to you that their location is X: " + p.getLocation().getBlockX() + ", Y: " + p.getLocation().getBlockY() + ", Z: " + p.getLocation().getBlockZ() + ChatColor.RESET);
		p.sendMessage(ChatColor.GREEN + "Sent your message to " + sendto.getName() + "!" + ChatColor.RESET);
		return true;
	}
	
}

package vin.ash.generalserverpack.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import vin.ash.generalserverpack.PluginMainManager;


public class GetTimeCommand implements CommandExecutor{
	
	private PluginMainManager plugin;
	
	public GetTimeCommand(PluginMainManager pl) {
		this.plugin = pl;
		plugin.getCommand("gettime").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		long ticks = Bukkit.getServer().getWorlds().get(0).getTime();
		long hour = ((long) Math.floor(ticks / 1000.0) + 6);
		hour = (hour > 24 ? hour - 6 : hour);
		String time = (hour > 12 ? (hour - 12) + (hour - 12 == 12 ? " AM" : " PM") : hour + (hour == 12 ? " PM" : " AM"));
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("The time is " + ticks + " ticks or " + time);
			return true;
		}
		
		Player p = (Player) sender;
		
		
		p.sendMessage(ChatColor.ITALIC + "The time is " + ticks + " ticks or " + time + ChatColor.RESET);
		return true;
	}
	
}

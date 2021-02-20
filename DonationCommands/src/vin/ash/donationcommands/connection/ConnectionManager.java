package vin.ash.donationcommands.connection;

import java.util.TreeMap;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.ChatColor;

public class ConnectionManager {
	
	String key;
	TreeMap<Double, String> map;
	
	public ConnectionManager(String k, TreeMap<Double, String> m)
	{
		key = k;
		map = m;
	}
	
	public void runCommandOnAmount(double amount)
	{
		if (map.containsKey(amount))
		{
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			try {
			Bukkit.dispatchCommand(console, map.get(amount));
			} catch (CommandException e)
			{
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Something went wrong! Please make sure that the commands you inputted are correct" + ChatColor.RESET);
			} catch (Exception e) 
			{
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Oh no, an interal error! Please contact the developer and send them the message in your Server Console!" + ChatColor.RESET);
				e.printStackTrace();
			}
			return;
		}
		
		double[] keys = new double[map.keySet().toArray().length];
		
		for(int i = 0; i < keys.length; i++) {
			keys[i] = (double) map.keySet().toArray()[i];
		}
		
		double distance = Math.abs(keys[0] - amount);
		int idx = 0;
		for(int c = 1; c < keys.length; c++){
			double cdistance = Math.abs(keys[c] - amount);
		    if(cdistance < distance){
		        idx = c;
		        distance = cdistance;
		    }
		}
		
		double nearestValue = keys[idx];
		
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		try {
			Bukkit.dispatchCommand(console, map.get(nearestValue));
		} catch (CommandException e)
		{
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Something went wrong! Please make sure that the commands you inputted are correct" + ChatColor.RESET);
		} catch (Exception e) 
		{
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Oh no, an interal error! Please contact the developer and send them the message in your Server Console!" + ChatColor.RESET);
			e.printStackTrace();
		}

	}
}

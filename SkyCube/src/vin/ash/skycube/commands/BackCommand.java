package vin.ash.skycube.commands;

import java.io.File;
import java.io.FileReader;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import vin.ash.skycube.Main;

public class BackCommand implements CommandExecutor{
	 
	private Main plugin;
	
	public BackCommand(Main pl) {
		this.plugin = pl;
		
		if(pl.getConfig().getBoolean("allowBack"))
			this.plugin.getCommand("back").setExecutor(this);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This can only be used by players");
			return true;
		}
		
		
		Player p = (Player) sender;
		
		
		
		File file = new File(plugin.getDataFolder(), plugin.getConfig().getString("spawn_file") + ".json");
		JSONObject playerspawn = new JSONObject();
		if(!file.exists()) {
			return true;
		} else {
			JSONParser parser = new JSONParser();
			try {
				playerspawn = (JSONObject) parser.parse(new FileReader(file));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		String spawn = (String) playerspawn.get(p.getUniqueId().toString());
		String[] coords = spawn.split(" ");
		p.teleport(new Location(p.getWorld(), Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2])));
		p.sendMessage(ChatColor.GREEN + "You have been teleported!" + ChatColor.RESET);
		
		return true;
	}
}

package vin.ash.skycube.commands;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import vin.ash.skycube.Main;

public class TeleportCommand implements CommandExecutor{
	
	private Main plugin;
	
	private ArrayList<TeleportRequest> requests;
	
	public TeleportCommand(Main pl) {
		this.plugin = pl;
		requests = new ArrayList<TeleportRequest>();
		
		if(pl.getConfig().getBoolean("allowTeleport"))
			this.plugin.getCommand("tpr").setExecutor(this);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("This can only be used by players");
			return true;
		}
		
		
		ArrayList<TeleportRequest> temp = new ArrayList<TeleportRequest>();
		for(int i = 0; i < requests.size(); i++)
		{
			if(requests.get(0).isValid())
				temp.add(requests.get(0));
		}
		
		requests = temp;
		
		Player p = (Player) sender;
		
		if (args.length != 2) {
			p.sendMessage(ChatColor.RED + "Incorrect amount of arguments it is /tpr request [playername]" + ChatColor.RESET);
			return true;
		}
		
		Player sendto = (Player) Bukkit.getPlayer(args[1]);
		
		if (sendto == null) {
			p.sendMessage(ChatColor.RED + "Player not found!" + ChatColor.RESET);
			return true;
		}
		
		if (sendto.getUniqueId() == p.getUniqueId())
		{
			p.sendMessage(ChatColor.RED + "You can't send a request to yourself!" + ChatColor.RESET);
			return true;
		}
		
		if(args[0].equals("request"))
		{
			for(TeleportRequest request: requests)
			{
				if (request.isValid() && request.getFrom().getUniqueId() == p.getUniqueId())
				{
					p.sendMessage(ChatColor.RED + "You already have a request open!" + ChatColor.RESET);
					return true;
				}
			}
			
			TextComponent message = new TextComponent(p.getName() + " would like to go to your island, click anywhere to accept. [This will expire in 30 seconds].");
			message.setColor(net.md_5.bungee.api.ChatColor.GREEN);
			message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpr accept " + p.getName()));
			message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("/tpr accept " + p.getName())));
			requests.add(new TeleportRequest(sendto, p));
			sendto.spigot().sendMessage(message);
			p.sendMessage(ChatColor.GREEN + "Your request has been sent!" + ChatColor.RESET);
		} else if (args[0].equals("accept"))
		{
			for(int i = 0; i < requests.size(); i++)
			{
				TeleportRequest request = requests.get(i);
				if (request.isValid() && request.getFrom().getUniqueId() == p.getUniqueId() && request.getTo().getUniqueId() == sendto.getUniqueId())
				{
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
					sendto.teleport(new Location(p.getWorld(), Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2])));
					p.sendMessage(ChatColor.GREEN + "They have been teleported!" + ChatColor.RESET);
					requests.remove(i);
					return true;
				}
			}
			p.sendMessage(ChatColor.RED + "There are no open requests at the moment" + ChatColor.RESET);
		} else
		{
			p.sendMessage(ChatColor.RED + "I do not undersand what you are trying to do." + ChatColor.RESET);
		}
		
		
		return true;
	}
}

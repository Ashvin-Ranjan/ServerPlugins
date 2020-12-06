package vin.ash.skycube.listeners;

import java.io.File;
import java.io.FileReader;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import vin.ash.skycube.Main;

public class PlayerRespawnListener implements Listener{
	private Main plugin;
	
	public PlayerRespawnListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		File file = new File(plugin.getDataFolder(), plugin.getConfig().getString("spawn_file") + ".json");
		JSONObject playerspawn = new JSONObject();
		if(!file.exists()) {
			return;
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
		e.setRespawnLocation(new Location(p.getWorld(), Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2])));
	}
}

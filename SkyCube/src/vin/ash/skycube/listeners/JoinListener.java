package vin.ash.skycube.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import vin.ash.skycube.Main;

public class JoinListener implements Listener{
	
	private Main plugin;
	
	public JoinListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if (!p.hasPlayedBefore()) {
			//TODO initialize island for player to join
			Bukkit.broadcastMessage("");
		}
	}
	
}

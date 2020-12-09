package vin.ash.skycube.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import vin.ash.skycube.Main;

public class PlayerMoveListener implements Listener{
	private Main plugin;
	
	public PlayerMoveListener(Main pl) {
		this.plugin = pl;
		
		if(pl.getConfig().getBoolean("registerMinHeight"))
			Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(e.getPlayer().getLocation().getBlockY() <= plugin.getConfig().getInt("minHeight") && e.getPlayer().getGameMode() == GameMode.SURVIVAL)
			e.getPlayer().setHealth(0);
	}
}

package vin.ash.skycube.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.metadata.FixedMetadataValue;

import vin.ash.skycube.Main;

public class RegenerateListener implements Listener{
	private Main plugin;
	
	public RegenerateListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(!e.getBlock().getMetadata("Unbreakable").get(0).asBoolean())
			return;
		
		plugin.getServer().getWorlds().get(0).getBlockAt(e.getBlock().getLocation()).setBlockData(e.getBlock().getBlockData());
		plugin.getServer().getWorlds().get(0).getBlockAt(e.getBlock().getLocation()).setMetadata("Unbreakable", new FixedMetadataValue(plugin, true));
	}
}

package vin.ash.moreenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import vin.ash.moreenchants.Main;
import vin.ash.moreenchants.enchants.CustomEnchants;

public class PlayerMoveListener implements Listener{
	private Main plugin;
	
	public PlayerMoveListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	private void handleSpeed(PlayerMoveEvent e) {
		if(e.getPlayer().getInventory().getBoots() == null) {
			e.getPlayer().setWalkSpeed(0.2f);
			return;
		}
		if(!e.getPlayer().getInventory().getBoots().hasItemMeta()) {
			e.getPlayer().setWalkSpeed(0.2f);
			return;
		}
		if(!e.getPlayer().getInventory().getBoots().getItemMeta().hasEnchant(CustomEnchants.SPEED)) {
			e.getPlayer().setWalkSpeed(0.2f);
			return;
		}
		if(0.2f + (e.getPlayer().getInventory().getBoots().getItemMeta().getEnchantLevel(CustomEnchants.SPEED) * 0.05f) > 1) {
			e.getPlayer().setWalkSpeed(0.2f);
			return;
		}
		
		e.getPlayer().setWalkSpeed(0.2f + (e.getPlayer().getInventory().getBoots().getItemMeta().getEnchantLevel(CustomEnchants.SPEED) * 0.05f));
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(plugin.getConfig().getBoolean("speed"))
			handleSpeed(e);
	}
}
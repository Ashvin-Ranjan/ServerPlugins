package vin.ash.floweroftruth.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import vin.ash.floweroftruth.Main;

public class PlayerInteractListener implements Listener{
	private Main plugin;
	
	public PlayerInteractListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBlockPlace(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getItem() != null && e.getItem().containsEnchantment(Enchantment.DAMAGE_ALL) && e.getItem().getType() == Material.POPPY) {
			e.setCancelled(true);
		}
	}
}

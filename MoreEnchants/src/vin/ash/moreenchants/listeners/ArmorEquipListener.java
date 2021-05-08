package vin.ash.moreenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import vin.ash.moreenchants.Main;
import vin.ash.moreenchants.enchants.CustomEnchants;
import vin.ash.moreenchants.events.ArmorEquipEvent;

public class ArmorEquipListener implements Listener{
	private Main plugin;
	
	public ArmorEquipListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	private void handleSpeed(ArmorEquipEvent e) {
		if(e.getNewArmorPiece() == null) {
			e.getPlayer().setWalkSpeed(0.2f);
			return;
		}
		if(!e.getNewArmorPiece().hasItemMeta()) {
			e.getPlayer().setWalkSpeed(0.2f);
			return;
		}
		if(!e.getNewArmorPiece().getItemMeta().hasEnchant(CustomEnchants.SPEED)) {
			e.getPlayer().setWalkSpeed(0.2f);
			return;
		}
		if(0.2f + (e.getNewArmorPiece().getItemMeta().getEnchantLevel(CustomEnchants.SPEED) * 0.05f) > 1) {
			e.getPlayer().setWalkSpeed(0.2f);
			return;
		}
		
		e.getPlayer().setWalkSpeed(0.2f + (e.getNewArmorPiece().getItemMeta().getEnchantLevel(CustomEnchants.SPEED) * 0.05f));
	}
	
	@EventHandler
	public void onArmorEquip(ArmorEquipEvent e) {
		if(plugin.getConfig().getBoolean("speed"))
			handleSpeed(e);
	}
}
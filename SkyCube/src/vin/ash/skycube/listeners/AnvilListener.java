package vin.ash.skycube.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

import vin.ash.skycube.Main;
import vin.ash.skycube.enchants.CustomEnchants;

public class AnvilListener implements Listener{
	private Main plugin;
	
	public AnvilListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null)
			return;
		if (e.getInventory().getType() != InventoryType.ANVIL)
			return;
		AnvilInventory inv = (AnvilInventory) e.getInventory();
		if (inv.isEmpty())
			return;
		if (inv.getItem(0) == null)
			return;
		if (!inv.getItem(0).hasItemMeta())
			return;
		if (!inv.getItem(0).getItemMeta().hasEnchant(CustomEnchants.TRANSMUTATION))
			return;
		if (e.getResult() == null)
			return;
		if(e.getSlotType() != InventoryType.SlotType.RESULT)
			return;
		ItemStack item = e.getCurrentItem();
		
		try {
			item.addEnchantment(CustomEnchants.TRANSMUTATION, inv.getItem(0).getItemMeta().getEnchantLevel(CustomEnchants.TRANSMUTATION));
		} catch (Exception ex){
			e.setCancelled(true);
		}
		
		e.setCurrentItem(item);
		
	}
}

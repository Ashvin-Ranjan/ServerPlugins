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
		System.out.println("Test8");
		if (e.getCurrentItem() == null)
			return;
		System.out.println("Test7");
		if (e.getInventory().getType() != InventoryType.ANVIL)
			return;
		System.out.println("Test6");
		AnvilInventory inv = (AnvilInventory) e.getInventory();
		if (inv.isEmpty())
			return;
		System.out.println("Test5");
		if (inv.getItem(0) == null)
			return;
		System.out.println("Test");
		if (!inv.getItem(0).hasItemMeta())
			return;
		System.out.println("Test4");
		if (!inv.getItem(0).getItemMeta().hasEnchant(CustomEnchants.TRANSMUTATION))
			return;
		System.out.println("Test3");
		if (e.getResult() == null)
			return;
		System.out.println("Test2");
		if(e.getSlotType() != InventoryType.SlotType.RESULT)
			return;
		System.out.println("Test1");
		ItemStack item = e.getCurrentItem();
		
		try {
			item.addEnchantment(CustomEnchants.TRANSMUTATION, inv.getItem(0).getItemMeta().getEnchantLevel(CustomEnchants.TRANSMUTATION));
		} catch (Exception ex){
			e.setCancelled(true);
		}
		
		e.setCurrentItem(item);
		
	}
}

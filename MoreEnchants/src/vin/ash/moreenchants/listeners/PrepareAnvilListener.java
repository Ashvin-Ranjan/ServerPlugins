package vin.ash.moreenchants.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import vin.ash.moreenchants.Main;
import vin.ash.moreenchants.enchants.CustomEnchants;
import vin.ash.moreenchants.utils.Utils;

public class PrepareAnvilListener implements Listener{
	private Main plugin;
	
	public PrepareAnvilListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	private void dealWithEnderSlayer(PrepareAnvilEvent e) {
		AnvilInventory inventory = e.getInventory();
		ItemStack first = inventory.getItem(0);
		ItemStack second = inventory.getItem(1);
		
		if (first == null || second == null)
			return;
		if (!first.hasItemMeta() && !second.hasItemMeta())
			return;
		if (!second.getItemMeta().hasEnchant(CustomEnchants.ENDER_SLAYER))
			return;
		
		if(!first.getItemMeta().hasEnchant(CustomEnchants.ENDER_SLAYER)) {
			if(!Utils.isSword(first.getType()) && first.getType() != Material.ENCHANTED_BOOK)
				return;
			ItemStack out = first.clone();
			ItemMeta meta = out.getItemMeta();
			meta.addEnchant(CustomEnchants.ENDER_SLAYER, second.getItemMeta().getEnchantLevel(CustomEnchants.ENDER_SLAYER), false);
			List<String> lore = (meta.getLore() == null ? new ArrayList<String>() : meta.getLore());
			lore.add("Ender Slayer " + Utils.toRoman(second.getItemMeta().getEnchantLevel(CustomEnchants.ENDER_SLAYER)));
			meta.setLore(lore);
			out.setItemMeta(meta);
			e.setResult(out);
			plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(second.getItemMeta().getEnchantLevel(CustomEnchants.ENDER_SLAYER) * 2));
			return;
		}
		if (first.getItemMeta().getEnchantLevel(CustomEnchants.ENDER_SLAYER) != second.getItemMeta().getEnchantLevel(CustomEnchants.ENDER_SLAYER))
			return;
		if (first.getItemMeta().getEnchantLevel(CustomEnchants.ENDER_SLAYER) >= CustomEnchants.ENDER_SLAYER.getMaxLevel())
			return;
		
		ItemStack out = first.clone();
		ItemMeta meta = out.getItemMeta();
		meta.removeEnchant(CustomEnchants.ENDER_SLAYER);
		meta.addEnchant(CustomEnchants.ENDER_SLAYER, second.getItemMeta().getEnchantLevel(CustomEnchants.ENDER_SLAYER) + 1, false);
		List<String> lore = meta.getLore();
		for(int i = 0; i < lore.size(); i ++) {
			if(lore.get(i).startsWith("Ender Slayer ")) {
				lore.set(i, "Ender Slayer " + Utils.toRoman(second.getItemMeta().getEnchantLevel(CustomEnchants.ENDER_SLAYER) + 1));
			}
		}
		meta.setLore(lore);
		out.setItemMeta(meta);
		e.setResult(out);
		plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost((second.getItemMeta().getEnchantLevel(CustomEnchants.ENDER_SLAYER) + 1) * 2));
	}
	
	public void dealWithPlanting(PrepareAnvilEvent e) {
		AnvilInventory inventory = e.getInventory();
		ItemStack first = inventory.getItem(0);
		ItemStack second = inventory.getItem(1);
		
		if (first == null || second == null)
			return;
		if (!first.hasItemMeta() && !second.hasItemMeta())
			return;
		if (!second.getItemMeta().hasEnchant(CustomEnchants.PLANTING))
			return;
		if(first.hasItemMeta() && first.getItemMeta().hasEnchant(CustomEnchants.PLANTING)) 
			return;
		if(!Utils.isHoe(first.getType()) || second.getType() != Material.ENCHANTED_BOOK)
			return;
		
		ItemStack out = first.clone();
		ItemMeta meta = out.getItemMeta();
		meta.addEnchant(CustomEnchants.PLANTING, 1, false);
		List<String> lore = (meta.getLore() == null ? new ArrayList<String>() : meta.getLore());
		lore.add("Planting " + Utils.toRoman(second.getItemMeta().getEnchantLevel(CustomEnchants.PLANTING)));
		meta.setLore(lore);
		out.setItemMeta(meta);
		e.setResult(out);
		plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(2));
		return;
	}
	
	@EventHandler
	public void onPrepareAnvil(PrepareAnvilEvent e) {
		dealWithEnderSlayer(e);
		dealWithPlanting(e);
	}
}
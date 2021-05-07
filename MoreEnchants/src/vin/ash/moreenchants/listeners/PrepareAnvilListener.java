package vin.ash.moreenchants.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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
	
	@SuppressWarnings("deprecation")
	private void dealWithMultipleLevelEnchant(PrepareAnvilEvent e, Enchantment ench) {
		AnvilInventory inventory = e.getInventory();
		ItemStack first = inventory.getItem(0);
		ItemStack second = inventory.getItem(1);
		
		if (first == null || second == null)
			return;
		if (!first.hasItemMeta() && !second.hasItemMeta())
			return;
		if (!second.getItemMeta().hasEnchant(ench))
			return;
		
		if(!first.getItemMeta().hasEnchant(ench)) {
			if(!ench.canEnchantItem(first) && first.getType() != Material.ENCHANTED_BOOK)
				return;
			ItemStack out = first.clone();
			ItemMeta meta = out.getItemMeta();
			meta.addEnchant(ench, second.getItemMeta().getEnchantLevel(ench), false);
			List<String> lore = (meta.getLore() == null ? new ArrayList<String>() : meta.getLore());
			lore.add(ench.getName() + " " + Utils.toRoman(second.getItemMeta().getEnchantLevel(ench)));
			meta.setLore(lore);
			out.setItemMeta(meta);
			e.setResult(out);
			plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(second.getItemMeta().getEnchantLevel(ench) * 2));
			return;
		}
		if (first.getItemMeta().getEnchantLevel(ench) != second.getItemMeta().getEnchantLevel(ench))
			return;
		if (first.getItemMeta().getEnchantLevel(ench) >= ench.getMaxLevel())
			return;
		
		ItemStack out = first.clone();
		ItemMeta meta = out.getItemMeta();
		meta.removeEnchant(ench);
		meta.addEnchant(ench, second.getItemMeta().getEnchantLevel(ench) + 1, false);
		List<String> lore = meta.getLore();
		for(int i = 0; i < lore.size(); i ++) {
			if(lore.get(i).startsWith(ench.getName() + " ")) {
				lore.set(i, ench.getName() + " " + Utils.toRoman(second.getItemMeta().getEnchantLevel(ench) + 1));
			}
		}
		meta.setLore(lore);
		out.setItemMeta(meta);
		e.setResult(out);
		plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost((second.getItemMeta().getEnchantLevel(ench) + 1) * 2));
	}
	
	@SuppressWarnings("deprecation")
	public void dealWithSingleLevelEnchant(PrepareAnvilEvent e, Enchantment ench) {
		AnvilInventory inventory = e.getInventory();
		ItemStack first = inventory.getItem(0);
		ItemStack second = inventory.getItem(1);
		
		if (first == null || second == null)
			return;
		if (!first.hasItemMeta() && !second.hasItemMeta())
			return;
		if (!second.getItemMeta().hasEnchant(ench))
			return;
		if(first.hasItemMeta() && first.getItemMeta().hasEnchant(ench)) 
			return;
		if(ench.canEnchantItem(first) || second.getType() != Material.ENCHANTED_BOOK)
			return;
		
		ItemStack out = first.clone();
		ItemMeta meta = out.getItemMeta();
		meta.addEnchant(ench, 1, false);
		List<String> lore = (meta.getLore() == null ? new ArrayList<String>() : meta.getLore());
		lore.add(ench.getName() + " " + Utils.toRoman(second.getItemMeta().getEnchantLevel(ench)));
		meta.setLore(lore);
		out.setItemMeta(meta);
		e.setResult(out);
		plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(2));
		return;
	}
	
	@EventHandler
	public void onPrepareAnvil(PrepareAnvilEvent e) {
		if(plugin.getConfig().getBoolean("ender_slayer"))
			dealWithMultipleLevelEnchant(e, CustomEnchants.ENDER_SLAYER);
		if(plugin.getConfig().getBoolean("planting"))
			dealWithSingleLevelEnchant(e, CustomEnchants.PLANTING);
		if(plugin.getConfig().getBoolean("cubeism"))
			dealWithMultipleLevelEnchant(e, CustomEnchants.CUBEISM);
	}
}
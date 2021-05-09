package vin.ash.moreenchants.listeners;

import java.util.Set;

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
import vin.ash.moreenchants.utils.Utils;

public class PrepareAnvilListener implements Listener{
	private Main plugin;
	
	public PrepareAnvilListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPrepareAnvil(PrepareAnvilEvent e) {
		AnvilInventory inventory = e.getInventory();
		ItemStack first = inventory.getItem(0);
		ItemStack second = inventory.getItem(1);
		
		if(first == null)
			return;
		if(second == null) {
			if (!first.hasItemMeta())
				return;
			if (e.getResult() == null)
				return;
			if (first.getItemMeta().getEnchants().keySet().size() == 0)
				return;
			
			ItemStack out = first.clone();
			ItemMeta meta = out.getItemMeta();
			meta.setDisplayName(e.getResult().getItemMeta().getDisplayName());
			out.setItemMeta(meta);
			e.setResult(out);
			plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(1));
			return;
		}
		
		if (e.getResult() != null) {
			if (!first.hasItemMeta()) {
				if(!second.hasItemMeta())
					return;
				ItemStack out = e.getResult().clone();
				ItemMeta meta = second.getItemMeta().clone();
				meta.setDisplayName(e.getResult().getItemMeta().getDisplayName());
				out.setItemMeta(meta);
				e.setResult(out);
				plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(second.getEnchantments().size() * 2));
				return;
			}
			
			if (!second.hasItemMeta()) {
				ItemStack out = e.getResult().clone();
				ItemMeta meta = first.getItemMeta().clone();
				meta.setDisplayName(e.getResult().getItemMeta().getDisplayName());
				out.setItemMeta(meta);
				e.setResult(out);
				plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(first.getEnchantments().size() * 2));
				return;
			}
			
			Set<Enchantment> enchants = first.getItemMeta().getEnchants().keySet();
			enchants.addAll(second.getItemMeta().getEnchants().keySet());
			ItemStack out = e.getResult().clone();
			ItemMeta meta = e.getResult().getItemMeta().clone();
			meta.setDisplayName(e.getResult().getItemMeta().getDisplayName());
			
			for (Enchantment ench : enchants) {
				if(!ench.canEnchantItem(e.getResult()))
					return;
				if(!e.getResult().getItemMeta().hasEnchant(ench)) {
					if(first.getItemMeta().hasEnchant(ench) && first.getItemMeta().hasEnchant(ench)) {
						if(first.getItemMeta().getEnchantLevel(ench) != second.getItemMeta().getEnchantLevel(ench))
							return;
						
						meta.addEnchant(ench, (first.getItemMeta().getEnchantLevel(ench) + 1 > ench.getMaxLevel() ? ench.getMaxLevel() : first.getItemMeta().getEnchantLevel(ench) + 1), false);
						meta.getLore().add(ench.getName() + " " + Utils.toRoman((first.getItemMeta().getEnchantLevel(ench) + 1 > ench.getMaxLevel() ? ench.getMaxLevel() : first.getItemMeta().getEnchantLevel(ench) + 1)));
					}
					
					meta.addEnchant(ench, first.getItemMeta().getEnchantLevel(ench), false);
					meta.getLore().add(ench.getName() + " " + Utils.toRoman(first.getItemMeta().getEnchantLevel(ench)));
				}
			}
			out.setItemMeta(meta);
			e.setResult(out);
			plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(out.getEnchantments().size() * 2));
			return;
		}
		
		if (second.getType() != Material.ENCHANTED_BOOK && first.getType() != second.getType())
			return;
		
		if (!first.hasItemMeta()) {
			if (!second.hasItemMeta())
				return;
			for (Enchantment ench : second.getItemMeta().getEnchants().keySet()) {
				if (!ench.canEnchantItem(first))
					return;
			}
			

			ItemStack out = first.clone();
			ItemMeta meta = second.getItemMeta().clone();
			out.setItemMeta(meta);
			e.setResult(out);
			plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(second.getEnchantments().size() * 2));
			return;
		}
		
		if (!second.hasItemMeta()) {
			ItemStack out = first.clone();
			ItemMeta meta = first.getItemMeta().clone();
			out.setItemMeta(meta);
			e.setResult(out);
			plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(first.getEnchantments().size() * 2));
			return;
		}
		
		Set<Enchantment> enchants = first.getItemMeta().getEnchants().keySet();
		enchants.addAll(second.getItemMeta().getEnchants().keySet());
		ItemStack out = new ItemStack(first.getType(), first.getAmount());
		ItemMeta meta = first.getItemMeta().clone();
		
		for (Enchantment ench : enchants) {
			if(!ench.canEnchantItem(out))
				return;
			if(!out.getItemMeta().hasEnchant(ench)) {
				if(first.getItemMeta().hasEnchant(ench) && first.getItemMeta().hasEnchant(ench)) {
					if(first.getItemMeta().getEnchantLevel(ench) != second.getItemMeta().getEnchantLevel(ench))
						return;
					
					meta.addEnchant(ench, (first.getItemMeta().getEnchantLevel(ench) + 1 > ench.getMaxLevel() ? ench.getMaxLevel() : first.getItemMeta().getEnchantLevel(ench) + 1), false);
					meta.getLore().add(ench.getName() + " " + Utils.toRoman((first.getItemMeta().getEnchantLevel(ench) + 1 > ench.getMaxLevel() ? ench.getMaxLevel() : first.getItemMeta().getEnchantLevel(ench) + 1)));
				}
				
				meta.addEnchant(ench, first.getItemMeta().getEnchantLevel(ench), false);
				meta.getLore().add(ench.getName() + " " + Utils.toRoman(first.getItemMeta().getEnchantLevel(ench)));
			}
		}
		out.setItemMeta(meta);
		e.setResult(out);
		plugin.getServer().getScheduler().runTask(plugin, () -> e.getInventory().setRepairCost(out.getEnchantments().size() * 2));
		return;
		
		
	}
}
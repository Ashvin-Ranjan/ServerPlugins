package vin.ash.floweroftruth.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.enchantments.Enchantment;

import vin.ash.floweroftruth.Main;

public class FlowerOfTruthRecipe {
	Main plugin;
	
	public FlowerOfTruthRecipe(Main pl) {
		this.plugin = pl;

		Bukkit.addRecipe(flowerOfTruthRecipe());
	}
	
	public ShapedRecipe flowerOfTruthRecipe() {
		ItemStack item = new ItemStack(Material.POPPY);
		
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.RED + "Flower of Truth" + ChatColor.RESET);
		
		meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 10, true);
		meta.addEnchant(Enchantment.SWEEPING_EDGE, 10, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 10, true);
		
		item.setItemMeta(meta);
		
		
		NamespacedKey key = new NamespacedKey(plugin, "flower_of_truth");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("PNP", "PNP", "PBP");
		
		recipe.setIngredient('P', Material.POPPY);
		recipe.setIngredient('N', Material.NETHERITE_INGOT);
		recipe.setIngredient('B', Material.BLAZE_ROD);
		
		return recipe;
	}
}

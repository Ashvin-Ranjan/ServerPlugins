package vin.ash.moreenchants.recipes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import vin.ash.moreenchants.Main;
import vin.ash.moreenchants.enchants.CustomEnchants;
import vin.ash.moreenchants.utils.Utils;

public class EnchantedBooksRecipes {
	Main plugin;
	
	public EnchantedBooksRecipes(Main pl) {
		this.plugin = pl;

		Bukkit.addRecipe(enderSlayer());
		Bukkit.addRecipe(planting());
	}
	
	private ShapelessRecipe planting() {
		ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(CustomEnchants.PLANTING, 1, false);
		List<String> lore = new ArrayList<String>();
		lore.add("Planting " + Utils.toRoman(1));
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "planting");
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, item);
		
		recipe.addIngredient(3, Material.PAPER);
		recipe.addIngredient(1, Material.HAY_BLOCK);
		
		return recipe;
	}

	private ShapelessRecipe enderSlayer() {
		ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(CustomEnchants.ENDER_SLAYER, 1, false);
		List<String> lore = new ArrayList<String>();
		lore.add("Ender Slayer " + Utils.toRoman(1));
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "ender_slayer");
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, item);
		
		recipe.addIngredient(3, Material.PAPER);
		recipe.addIngredient(1, Material.ENDER_PEARL);
		
		return recipe;
	}
}

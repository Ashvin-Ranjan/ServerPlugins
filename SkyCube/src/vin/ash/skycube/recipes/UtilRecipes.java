package vin.ash.skycube.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import vin.ash.skycube.Main;

public class UtilRecipes {
	Main plugin;
	
	public UtilRecipes(Main pl) {
		this.plugin = pl;
		Bukkit.addRecipe(this.grassRecipe());
	}
	
	public ShapelessRecipe grassRecipe() {
		ItemStack item = new ItemStack(Material.GRASS_BLOCK);
		
		NamespacedKey key = new NamespacedKey(plugin, "grass");
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, item);
		
		recipe.addIngredient(1, Material.DIRT);
		
		return recipe;
	}
}

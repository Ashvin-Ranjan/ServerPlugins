package vin.ash.skycube.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import vin.ash.skycube.Main;

public class ItemRecipes {
	Main plugin;
	
	public ItemRecipes(Main pl) {
		this.plugin = pl;
		Bukkit.addRecipe(this.coalRecipe());
		Bukkit.addRecipe(this.ironRecipe());
		Bukkit.addRecipe(this.goldRecipe());
		Bukkit.addRecipe(this.redstoneRecipe());
		Bukkit.addRecipe(this.lapisRecipe());
		Bukkit.addRecipe(this.diamondRecipe());
	}

	public ShapedRecipe coalRecipe() {
		ItemStack item = new ItemStack(Material.COAL);
		
		NamespacedKey key = new NamespacedKey(plugin, "coal");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape(" S ", "SSS", " S ");
		
		recipe.setIngredient('S', Material.COBBLESTONE);
		
		return recipe;
	}
	
	public ShapedRecipe ironRecipe() {
		ItemStack item = new ItemStack(Material.IRON_INGOT);
		
		NamespacedKey key = new NamespacedKey(plugin, "iron_ingot");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape(" C ", "CCC", " C ");
		
		recipe.setIngredient('C', Material.COAL);
		
		return recipe;
	}
	
	public ShapedRecipe goldRecipe() {
		ItemStack item = new ItemStack(Material.GOLD_INGOT);
		
		NamespacedKey key = new NamespacedKey(plugin, "gold_ingot");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape(" I ", "III", " I ");
		
		recipe.setIngredient('I', Material.IRON_INGOT);
		
		return recipe;
	}
	
	public ShapedRecipe redstoneRecipe() {
		ItemStack item = new ItemStack(Material.REDSTONE);
		
		NamespacedKey key = new NamespacedKey(plugin, "redstone");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape(" G ", "GGG", " G ");
		
		recipe.setIngredient('G', Material.GOLD_INGOT);
		
		return recipe;
	}
	
	public ShapedRecipe lapisRecipe() {
		ItemStack item = new ItemStack(Material.LAPIS_LAZULI);
		
		NamespacedKey key = new NamespacedKey(plugin, "lapis_lazuli");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape(" R ", "RRR", " R ");
		
		recipe.setIngredient('R', Material.REDSTONE);
		
		return recipe;
	}
	
	public ShapedRecipe diamondRecipe() {
		ItemStack item = new ItemStack(Material.DIAMOND);
		
		NamespacedKey key = new NamespacedKey(plugin, "diamond");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape(" L ", "LLL", " L ");
		
		recipe.setIngredient('L', Material.LAPIS_LAZULI);
		
		return recipe;
	}
}

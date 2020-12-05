package vin.ash.skycube.recipes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import vin.ash.skycube.Main;
import vin.ash.skycube.enchants.CustomEnchants;

public class TransmutationRecipes {
	Main plugin;
	
	public TransmutationRecipes(Main pl) {
		this.plugin = pl;
		Bukkit.addRecipe(this.coalTransmutationRecipe());
		Bukkit.addRecipe(this.ironTransmutationRecipe());
		Bukkit.addRecipe(this.goldTransmutationRecipe());
		Bukkit.addRecipe(this.redstoneTransmutationRecipe());
		Bukkit.addRecipe(this.lapisTransmutationRecipe());
		Bukkit.addRecipe(this.diamondTransmutationRecipe());
	}
	
	public ShapedRecipe coalTransmutationRecipe() {
		ItemStack item = new ItemStack(Material.STONE_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(CustomEnchants.TRANSMUTATION, 1, false);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLUE + "Transmutation I" + ChatColor.RESET);
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "stone_pickaxe");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("CCC", "CPC", "CCC");
		
		recipe.setIngredient('C', Material.COAL);
		recipe.setIngredient('P', Material.STONE_PICKAXE);
		
		return recipe;
	}
	
	public ShapedRecipe ironTransmutationRecipe() {
		ItemStack item = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(CustomEnchants.TRANSMUTATION, 2, false);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLUE + "Transmutation II" + ChatColor.RESET);
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "iron_pickaxe");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("III", "IPI", "III");
		
		recipe.setIngredient('I', Material.IRON_INGOT);
		recipe.setIngredient('P', Material.IRON_PICKAXE);
		
		return recipe;
	}
	
	public ShapedRecipe goldTransmutationRecipe() {
		ItemStack item = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(CustomEnchants.TRANSMUTATION, 3, false);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLUE + "Transmutation III" + ChatColor.RESET);
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "gold_pickaxe");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("III", "IPI", "III");
		
		recipe.setIngredient('I', Material.GOLD_INGOT);
		recipe.setIngredient('P', Material.IRON_PICKAXE);
		
		return recipe;
	}
	
	public ShapedRecipe redstoneTransmutationRecipe() {
		ItemStack item = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(CustomEnchants.TRANSMUTATION, 4, false);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLUE + "Transmutation IV" + ChatColor.RESET);
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "redstone_pickaxe");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("RRR", "RPR", "RRR");
		
		recipe.setIngredient('R', Material.REDSTONE);
		recipe.setIngredient('P', Material.IRON_PICKAXE);
		
		return recipe;
	}
	
	public ShapedRecipe lapisTransmutationRecipe() {
		ItemStack item = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(CustomEnchants.TRANSMUTATION, 5, false);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLUE + "Transmutation V" + ChatColor.RESET);
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "lapis_pickaxe");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("LLL", "LPL", "LLL");
		
		recipe.setIngredient('L', Material.LAPIS_LAZULI);
		recipe.setIngredient('P', Material.IRON_PICKAXE);
		
		return recipe;
	}
	
	public ShapedRecipe diamondTransmutationRecipe() {
		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(CustomEnchants.TRANSMUTATION, 6, false);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLUE + "Transmutation VI" + ChatColor.RESET);
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "diamond_pickaxe");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("DDD", "DPD", "DDD");
		
		recipe.setIngredient('D', Material.DIAMOND);
		recipe.setIngredient('P', Material.DIAMOND_PICKAXE);
		
		return recipe;
	}
}

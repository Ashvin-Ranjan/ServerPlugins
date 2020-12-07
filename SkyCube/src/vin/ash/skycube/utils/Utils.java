package vin.ash.skycube.utils;

import java.util.Calendar;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

import vin.ash.skycube.Main;


public class Utils {
	
	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static double getDist(Location a, Location b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2)+Math.pow(a.getZ() - b.getZ(), 2));
	}
	
	public static Location getRandomLocation(World w, int spread) {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Location(w, r.nextDouble() * spread, 65, r.nextDouble() * spread);
	}
	
	public static void registerSimpleRecipe(ItemStack out, Material in, Main plugin) {
		NamespacedKey key = new NamespacedKey(plugin, out.getType().name());
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, out);
		
		recipe.addIngredient(1, in);
		
		Bukkit.addRecipe(recipe);
	}
	
	public static void registerSimpleRecipe(Material out, Material in, Main plugin) {
		ItemStack item = new ItemStack(out, 1);
		
		NamespacedKey key = new NamespacedKey(plugin, out.name());
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, item);
		
		recipe.addIngredient(1, in);
		
		Bukkit.addRecipe(recipe);
	}
	
	public static void registerSimpleRecipe(Material out, Material in, Material in2, Main plugin) {
		ItemStack item = new ItemStack(out, 1);
		
		NamespacedKey key = new NamespacedKey(plugin, out.name());
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, item);
		
		recipe.addIngredient(1, in);
		recipe.addIngredient(1, in2);
		
		Bukkit.addRecipe(recipe);
	}

	public static void registerRecipeCycle(Material[] items, Main plugin) {
		for(int i = 0; i < items.length; i++) {
			if(i == items.length - 1) 
				Utils.registerSimpleRecipe(items[0], items[0], plugin);
			else 
				Utils.registerSimpleRecipe(items[i + 1], items[i], plugin);
		}
	}
	
	public static void registerCubeRecipe(Material out, Material in, Main plugin) {
		ItemStack item = new ItemStack(out, 1);
		
		NamespacedKey key = new NamespacedKey(plugin, out.name());
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("III", "III", "III");
		
		recipe.setIngredient('I', in);
		
		Bukkit.addRecipe(recipe);
	}
	
	public static void registerXRecipe(Material out, Material in, Material in2, Main plugin) {
		ItemStack item = new ItemStack(out, 1);
		
		NamespacedKey key = new NamespacedKey(plugin, out.name());
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("IXI", "XIX", "IXI");
		
		recipe.setIngredient('I', in);
		recipe.setIngredient('X', in2);
		
		Bukkit.addRecipe(recipe);
	}
	
}

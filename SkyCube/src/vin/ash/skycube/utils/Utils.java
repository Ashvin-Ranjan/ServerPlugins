package vin.ash.skycube.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.BookMeta;

import vin.ash.skycube.Main;


public class Utils {
	
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static List<String> chat(List<String> s) {
		List<String> out = new ArrayList<String>();
		for(String st : s)
			out.add(ChatColor.translateAlternateColorCodes('&', st));
		return out;
	}
	
	public static double getDist(Location a, Location b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2)+Math.pow(a.getZ() - b.getZ(), 2));
	}
	
	public static Location getRandomLocation(World w, int spread) {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Location(w, ((r.nextDouble() * spread * 2) - spread), 65, ((r.nextDouble() * spread * 2) - spread));
	}
	
	public static void registerSimpleRecipe(ItemStack out, Material in, Main plugin) {
		NamespacedKey key = new NamespacedKey(plugin, out.getType().name());
		int index = 0;
		do {
			if(index == 0)
				key = new NamespacedKey(plugin, out.getType().name());
			else
				key = new NamespacedKey(plugin, out.getType().name() + index);
			index++;
		} while (Bukkit.getRecipe(key) != null);
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, out);
		
		recipe.addIngredient(1, in);
		
		Bukkit.addRecipe(recipe);
	}
	
	public static void registerSimpleRecipe(Material out, Material in, Main plugin) {
		ItemStack item = new ItemStack(out, 1);
		
		NamespacedKey key = new NamespacedKey(plugin, out.name());
		int index = 0;
		do {
			if(index == 0)
				key = new NamespacedKey(plugin, out.name());
			else
				key = new NamespacedKey(plugin, out.name() + index);
			index++;
		} while (Bukkit.getRecipe(key) != null);
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, item);
		
		recipe.addIngredient(1, in);
		
		Bukkit.addRecipe(recipe);
	}
	
	public static void registerSimpleRecipe(Material out, Material in, Material in2, Main plugin) {
		ItemStack item = new ItemStack(out, 1);
		
		NamespacedKey key = new NamespacedKey(plugin, out.name());
		int index = 0;
		do {
			if(index == 0)
				key = new NamespacedKey(plugin, out.name());
			else
				key = new NamespacedKey(plugin, out.name() + index);
			index++;
		} while (Bukkit.getRecipe(key) != null);
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, item);
		
		recipe.addIngredient(1, in);
		recipe.addIngredient(1, in2);
		
		Bukkit.addRecipe(recipe);
	}

	public static void registerRecipeCycle(Material[] items, Main plugin) {
		for(int i = 0; i < items.length; i++) {
			if(i == items.length - 1) 
				Utils.registerSimpleRecipe(items[0], items[i], plugin);
			else 
				Utils.registerSimpleRecipe(items[i + 1], items[i], plugin);
		}
	}
	
	public static void registerCubeRecipe(Material out, Material in, Main plugin) {
		ItemStack item = new ItemStack(out, 1);
		
		NamespacedKey key = new NamespacedKey(plugin, out.name());
		int index = 0;
		do {
			if(index == 0)
				key = new NamespacedKey(plugin, out.name());
			else
				key = new NamespacedKey(plugin, out.name() + index);
			index++;
		} while (Bukkit.getRecipe(key) != null);
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("III", "III", "III");
		
		recipe.setIngredient('I', in);
		
		Bukkit.addRecipe(recipe);
	}
	
	public static void registerXRecipe(Material out, Material in, Material in2, Main plugin) {
		ItemStack item = new ItemStack(out, 1);
		
		NamespacedKey key = new NamespacedKey(plugin, out.name());
		int index = 0;
		do {
			if(index == 0)
				key = new NamespacedKey(plugin, out.name());
			else
				key = new NamespacedKey(plugin, out.name() + index);
			index++;
		} while (Bukkit.getRecipe(key) != null);
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("IXI", "XIX", "IXI");
		
		recipe.setIngredient('I', in);
		recipe.setIngredient('X', in2);
		
		Bukkit.addRecipe(recipe);
	}
	
	public static void playerQuickStart(Player p, Main plugin) {
		
		File file = new File(plugin.getDataFolder(), plugin.getConfig().getString("startBook_pages") + ".txt");
		if(!file.exists()) {
			return;
		} else {
			try {
				Scanner reader;
				reader = new Scanner(file);
		    	List<String> out = new ArrayList<String>();
		    	String outraw = "";
		        while (reader.hasNextLine()) {
		          outraw += reader.nextLine() + "\n";
		        }
		        reader.close();
		        
		        out = Arrays.asList(outraw.split("~"));
				
				ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
				BookMeta bm = (BookMeta) book.getItemMeta();
				bm.setTitle("Help book");
				bm.setAuthor(chat(plugin.getConfig().getString("startBook_author")));
				bm.setTitle(chat(plugin.getConfig().getString("startBook_title")));
				bm.setPages(chat(out));
				book.setItemMeta(bm);

		        p.getInventory().addItem(book);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
}

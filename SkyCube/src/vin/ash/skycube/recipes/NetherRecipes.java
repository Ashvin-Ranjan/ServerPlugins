package vin.ash.skycube.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import vin.ash.skycube.Main;
import vin.ash.skycube.utils.Utils;

public class NetherRecipes {
	Main plugin;
	
	public NetherRecipes(Main pl) {
		this.plugin = pl;
		
		Utils.registerSimpleRecipe(Material.NETHERRACK, Material.STONE, Material.RED_DYE, pl);
		Utils.registerSimpleRecipe(Material.NETHER_WART, Material.RED_MUSHROOM, Material.NETHERRACK, pl);
		Utils.registerSimpleRecipe(Material.SOUL_SAND, Material.SAND, Material.NETHER_WART, pl);
		Utils.registerSimpleRecipe(Material.SOUL_SOIL, Material.SOUL_SAND, pl);
		Utils.registerSimpleRecipe(Material.NETHER_BRICK, Material.BRICK, Material.NETHER_WART, pl);
		Utils.registerXRecipe(Material.ANCIENT_DEBRIS, Material.DIAMOND_BLOCK, Material.GOLD_BLOCK, pl);
		Utils.registerXRecipe(Material.NETHER_QUARTZ_ORE, Material.NETHERRACK, Material.WHITE_DYE, pl);
		Utils.registerXRecipe(Material.PIGLIN_BANNER_PATTERN, Material.PORKCHOP, Material.PAPER, pl);
		Bukkit.addRecipe(blazeRodRecipe());
		Bukkit.addRecipe(netherStarRecipe());
		Bukkit.addRecipe(glowstoneRecipe());
		Bukkit.addRecipe(pigstepRecipe());
		Bukkit.addRecipe(ghastTearRecipe());
	}
	
	private ShapedRecipe glowstoneRecipe() {
		ItemStack item = new ItemStack(Material.GLOWSTONE);
		
		NamespacedKey key = new NamespacedKey(plugin, "glowstone");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("GGG", "GTG", "GGG");
		
		recipe.setIngredient('G', Material.GLASS);
		recipe.setIngredient('T', Material.TORCH);
		
		return recipe;
	}
	
	private ShapedRecipe pigstepRecipe() {
		ItemStack item = new ItemStack(Material.MUSIC_DISC_PIGSTEP);
		
		NamespacedKey key = new NamespacedKey(plugin, "pigstep");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("PPP", "PJP", "PPP");
		
		recipe.setIngredient('P', Material.PORKCHOP);
		recipe.setIngredient('J', Material.JUKEBOX);
		
		return recipe;
	}
	
	private ShapedRecipe ghastTearRecipe() {
		ItemStack item = new ItemStack(Material.GHAST_TEAR);
		
		NamespacedKey key = new NamespacedKey(plugin, "ghast_tear");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("FFF", "FBF", "FFF");
		
		recipe.setIngredient('F', Material.FEATHER);
		recipe.setIngredient('B', Material.BLAZE_POWDER);
		
		return recipe;
	}
	
	private ShapedRecipe blazeRodRecipe() {
		ItemStack item = new ItemStack(Material.BLAZE_ROD);
		
		NamespacedKey key = new NamespacedKey(plugin, "blaze_rod");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("GGG", "GSG", "GGG");
		
		recipe.setIngredient('G', Material.GOLD_INGOT);
		recipe.setIngredient('S', Material.STICK);
		
		return recipe;
	}
	
	private ShapedRecipe netherStarRecipe() {
		ItemStack item = new ItemStack(Material.NETHER_STAR);
		
		NamespacedKey key = new NamespacedKey(plugin, "nether_star");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape(" B ", "BNB", " B ");
		
		recipe.setIngredient('B', Material.BLAZE_ROD);
		recipe.setIngredient('N', Material.NETHERITE_INGOT);
		
		return recipe;
	}
}

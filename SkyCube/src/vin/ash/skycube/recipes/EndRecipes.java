package vin.ash.skycube.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import vin.ash.skycube.Main;
import vin.ash.skycube.utils.Utils;

public class EndRecipes {
Main plugin;
	
	public EndRecipes(Main pl) {
		this.plugin = pl;
		
		Utils.registerSimpleRecipe(Material.END_STONE, Material.CHORUS_FRUIT, Material.COBBLESTONE, pl);
		Utils.registerSimpleRecipe(Material.CHORUS_FRUIT, Material.BEETROOT, Material.PURPLE_DYE, pl);
		Utils.registerSimpleRecipe(Material.PURPUR_BLOCK, Material.END_STONE, Material.PURPLE_DYE, pl);
		Utils.registerSimpleRecipe(Material.CHORUS_FLOWER, Material.CHORUS_FRUIT, pl);
		Bukkit.addRecipe(elytraRecipe());
	}
	
	private ShapedRecipe elytraRecipe() {
		ItemStack item = new ItemStack(Material.ELYTRA);
		
		NamespacedKey key = new NamespacedKey(plugin, "elytra");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("ERE", "E E", "E E");
		
		recipe.setIngredient('E', Material.PHANTOM_MEMBRANE);
		recipe.setIngredient('R', Material.END_ROD);
		
		return recipe;
	}
}

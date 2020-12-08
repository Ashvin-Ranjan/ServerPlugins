package vin.ash.skycube.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import vin.ash.skycube.Main;
import vin.ash.skycube.utils.Utils;

public class UtilRecipes {
	Main plugin;
	
	public UtilRecipes(Main pl) {
		this.plugin = pl;
		
		Utils.registerSimpleRecipe(Material.GRASS_BLOCK, Material.DIRT, pl);
		Utils.registerSimpleRecipe(Material.SEAGRASS, Material.GRASS, pl);
		Utils.registerSimpleRecipe(Material.TALL_SEAGRASS, Material.TALL_GRASS, pl);
		
		Utils.registerSimpleRecipe(Material.GRASS_BLOCK, Material.GRAVEL, Material.ACACIA_LEAVES, pl);
		Utils.registerSimpleRecipe(Material.GRASS_BLOCK, Material.GRAVEL, Material.BIRCH_LEAVES, pl);
		Utils.registerSimpleRecipe(Material.GRASS_BLOCK, Material.GRAVEL, Material.DARK_OAK_LEAVES, pl);
		Utils.registerSimpleRecipe(Material.GRASS_BLOCK, Material.GRAVEL, Material.JUNGLE_LEAVES, pl);
		Utils.registerSimpleRecipe(Material.GRASS_BLOCK, Material.GRAVEL, Material.OAK_LEAVES, pl);
		Utils.registerSimpleRecipe(Material.GRASS_BLOCK, Material.GRAVEL, Material.SPRUCE_LEAVES, pl);

		Utils.registerSimpleRecipe(Material.MYCELIUM, Material.GRASS_BLOCK, Material.MUSHROOM_STEM, pl);
		Utils.registerSimpleRecipe(Material.PODZOL, Material.GRASS_BLOCK, Material.VINE, pl);
		
		Utils.registerSimpleRecipe(Material.BONE_MEAL, Material.ACACIA_PLANKS, pl);
		Utils.registerSimpleRecipe(Material.BONE_MEAL, Material.BIRCH_PLANKS, pl);
		Utils.registerSimpleRecipe(Material.BONE_MEAL, Material.CRIMSON_PLANKS, pl);
		Utils.registerSimpleRecipe(Material.BONE_MEAL, Material.DARK_OAK_PLANKS, pl);
		Utils.registerSimpleRecipe(Material.BONE_MEAL, Material.JUNGLE_PLANKS, pl);
		Utils.registerSimpleRecipe(Material.BONE_MEAL, Material.OAK_PLANKS, pl);
		Utils.registerSimpleRecipe(Material.BONE_MEAL, Material.SPRUCE_PLANKS, pl);
		Utils.registerSimpleRecipe(Material.BONE_MEAL, Material.WARPED_PLANKS, pl);
		
		Utils.registerSimpleRecipe(new ItemStack(Material.GRAVEL, 2), Material.COBBLESTONE, pl);
		Utils.registerSimpleRecipe(new ItemStack(Material.SAND, 2), Material.GRAVEL, pl);
		Utils.registerSimpleRecipe(Material.CLAY, Material.SAND, pl);
		
		Bukkit.addRecipe(vineRecipe(Material.ACACIA_LEAVES));
		Bukkit.addRecipe(vineRecipe(Material.BIRCH_LEAVES));
		Bukkit.addRecipe(vineRecipe(Material.DARK_OAK_LEAVES));
		Bukkit.addRecipe(vineRecipe(Material.JUNGLE_LEAVES));
		Bukkit.addRecipe(vineRecipe(Material.OAK_LEAVES));
		Bukkit.addRecipe(vineRecipe(Material.SPRUCE_LEAVES));

		Bukkit.addRecipe(saplingRecipe());
		
		Bukkit.addRecipe(waterBucketRecipe());
		
		Bukkit.addRecipe(boneRecipe());

		Utils.registerXRecipe(Material.OBSIDIAN, Material.DIAMOND, Material.COBBLESTONE, pl);
		
		Bukkit.addRecipe(mushroomRecipe(Material.RED_MUSHROOM, Material.RED_MUSHROOM_BLOCK));
		Bukkit.addRecipe(mushroomRecipe(Material.BROWN_MUSHROOM, Material.BROWN_MUSHROOM_BLOCK));
		Utils.registerSimpleRecipe(Material.MUSHROOM_STEM, Material.RED_MUSHROOM_BLOCK, Material.WHITE_DYE, pl);
		Utils.registerSimpleRecipe(Material.MUSHROOM_STEM, Material.BROWN_MUSHROOM_BLOCK, Material.WHITE_DYE, pl);
		
		
	}
	
	public ShapedRecipe mushroomRecipe(Material mushroom, Material block) {
		ItemStack item = new ItemStack(block);
		
		NamespacedKey key = new NamespacedKey(plugin, block.name());
		int index = 0;
		do {
			if(index == 0)
				key = new NamespacedKey(plugin, block.name());
			else
				key = new NamespacedKey(plugin, block.name() + index);
			index++;
		} while (Bukkit.getRecipe(key) != null);
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MM", "MM");
		
		recipe.setIngredient('M', mushroom);
		
		return recipe;
	}
	
	public ShapedRecipe vineRecipe(Material leaf) {
		ItemStack item = new ItemStack(Material.VINE);
		
		NamespacedKey key = new NamespacedKey(plugin, "vine");
		int index = 0;
		do {
			if(index == 0)
				key = new NamespacedKey(plugin, "vine");
			else
				key = new NamespacedKey(plugin, "vine" + index);
			index++;
		} while (Bukkit.getRecipe(key) != null);
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("L L", "LLL", "L L");
		
		recipe.setIngredient('L', leaf);
		
		return recipe;
	}
	
	public ShapedRecipe waterBucketRecipe() {
		ItemStack item = new ItemStack(Material.WATER_BUCKET);
		
		NamespacedKey key = new NamespacedKey(plugin, "water_bucket");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("ILI", " I ");
		
		recipe.setIngredient('I', Material.IRON_INGOT);
		recipe.setIngredient('L', Material.LAPIS_BLOCK);
		
		return recipe;
	}
	
	public ShapedRecipe saplingRecipe() {
		ItemStack item = new ItemStack(Material.OAK_SAPLING);
		
		NamespacedKey key = new NamespacedKey(plugin, "oak_sapling");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("S", "S");
		
		recipe.setIngredient('S', Material.WHEAT_SEEDS);
		
		return recipe;
	}
	
	public ShapedRecipe boneRecipe() {
		ItemStack item = new ItemStack(Material.BONE);
		
		NamespacedKey key = new NamespacedKey(plugin, "bone");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("BBB");
		
		recipe.setIngredient('B', Material.BONE_MEAL);
		
		return recipe;
	}
}

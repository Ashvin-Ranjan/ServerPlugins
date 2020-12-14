package vin.ash.skycube.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import vin.ash.skycube.Main;
import vin.ash.skycube.utils.Utils;

public class SpawnEggRecipes {
	Main plugin;
	
	public SpawnEggRecipes(Main pl) {
		this.plugin = pl;
		
		Utils.registerCubeRecipe(Material.CHICKEN_SPAWN_EGG, Material.WHEAT_SEEDS, pl);
		Utils.registerSimpleRecipe(Material.COW_SPAWN_EGG, Material.HAY_BLOCK, pl);
		Utils.registerCubeRecipe(Material.SHEEP_SPAWN_EGG, Material.HAY_BLOCK, pl);
		Utils.registerCubeRecipe(Material.COD_SPAWN_EGG, Material.BONE, pl);
		Utils.registerCubeRecipe(Material.MOOSHROOM_SPAWN_EGG, Material.RED_MUSHROOM, pl);
		Utils.registerCubeRecipe(Material.PANDA_SPAWN_EGG, Material.BAMBOO, pl);
		Utils.registerCubeRecipe(Material.TURTLE_SPAWN_EGG, Material.SEAGRASS, pl);
		Utils.registerCubeRecipe(Material.TURTLE_SPAWN_EGG, Material.TALL_SEAGRASS, pl);
		
		Utils.registerXRecipe(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG, Material.GOLD_INGOT, Material.ROTTEN_FLESH, pl);
		Utils.registerXRecipe(Material.PIGLIN_SPAWN_EGG, Material.GOLD_INGOT, Material.PORKCHOP, pl);
		Utils.registerXRecipe(Material.HOGLIN_SPAWN_EGG, Material.PORKCHOP, Material.GOLD_INGOT, pl);
		Utils.registerXRecipe(Material.BLAZE_SPAWN_EGG, Material.FIRE_CHARGE, Material.GOLD_INGOT, pl);
		Utils.registerXRecipe(Material.WITHER_SKELETON_SPAWN_EGG, Material.BONE, Material.COAL, pl);

		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.DANDELION, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.POPPY, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.BLUE_ORCHID, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.ALLIUM, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.AZURE_BLUET, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.RED_TULIP, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.ORANGE_TULIP, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.WHITE_TULIP, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.PINK_TULIP, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.OXEYE_DAISY, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.CORNFLOWER, Material.SUGAR, pl);
		Utils.registerXRecipe(Material.BEE_SPAWN_EGG, Material.LILY_OF_THE_VALLEY, Material.SUGAR, pl);

		Bukkit.addRecipe(villagerRecipe());
		Bukkit.addRecipe(shulkerRecipe());
	}
	
	public ShapedRecipe villagerRecipe() {
		ItemStack item = new ItemStack(Material.VILLAGER_SPAWN_EGG);
		
		NamespacedKey key = new NamespacedKey(plugin, "villager_spawn_egg");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("EEE", "EPE", "EEE");
		
		recipe.setIngredient('E', Material.EMERALD);
		recipe.setIngredient('P', Material.PLAYER_HEAD);
		
		return recipe;
	}
	
	public ShapedRecipe shulkerRecipe() {
		ItemStack item = new ItemStack(Material.SHULKER_SPAWN_EGG);
		
		NamespacedKey key = new NamespacedKey(plugin, "shulker_spawn_egg");
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("CCC", "CBC", "CCC");
		
		recipe.setIngredient('C', Material.CHORUS_FRUIT);
		recipe.setIngredient('B', Material.BARREL);
		
		return recipe;
	}
}



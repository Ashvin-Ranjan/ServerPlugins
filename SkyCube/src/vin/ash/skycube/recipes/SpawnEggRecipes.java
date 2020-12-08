package vin.ash.skycube.recipes;

import org.bukkit.Material;

import vin.ash.skycube.Main;
import vin.ash.skycube.utils.Utils;

public class SpawnEggRecipes {
	Main plugin;
	
	public SpawnEggRecipes(Main pl) {
		this.plugin = pl;
		
		Utils.registerCubeRecipe(Material.CHICKEN_SPAWN_EGG, Material.WHEAT_SEEDS, pl);
		Utils.registerCubeRecipe(Material.COW_SPAWN_EGG, Material.WHEAT, pl);
		Utils.registerCubeRecipe(Material.SHEEP_SPAWN_EGG, Material.HAY_BLOCK, pl);
		Utils.registerCubeRecipe(Material.COD_SPAWN_EGG, Material.BONE, pl);
		Utils.registerCubeRecipe(Material.MOOSHROOM_SPAWN_EGG, Material.RED_MUSHROOM, pl);
		
		Utils.registerXRecipe(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG, Material.GOLD_INGOT, Material.ROTTEN_FLESH, pl);
		Utils.registerXRecipe(Material.PIGLIN_SPAWN_EGG, Material.GOLD_INGOT, Material.PORKCHOP, pl);
		Utils.registerXRecipe(Material.HOGLIN_SPAWN_EGG, Material.PORKCHOP, Material.GOLD_INGOT, pl);
		Utils.registerXRecipe(Material.BLAZE_SPAWN_EGG, Material.FIRE_CHARGE, Material.GOLD_INGOT, pl);
		Utils.registerXRecipe(Material.WITHER_SKELETON_SPAWN_EGG, Material.BONE, Material.COAL, pl);
	}
}

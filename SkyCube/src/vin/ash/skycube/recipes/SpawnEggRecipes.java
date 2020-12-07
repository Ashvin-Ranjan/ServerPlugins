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
		Utils.registerSimpleRecipe(Material.COD_SPAWN_EGG, Material.BONE, pl);
	}
}

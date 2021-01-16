package vin.ash.skycube.recipes;

import org.bukkit.Material;

import vin.ash.skycube.Main;
import vin.ash.skycube.utils.Utils;

public class CycleRecipes {
	Main plugin;
	final Material[] seedCycle = {
		Material.WHEAT_SEEDS,
		Material.PUMPKIN_SEEDS,
		Material.MELON_SEEDS,
		Material.BEETROOT_SEEDS,
		Material.POTATO,
		Material.CARROT,
		Material.SUGAR_CANE,
		Material.BAMBOO,
		Material.RED_MUSHROOM,
		Material.BROWN_MUSHROOM,
		Material.CACTUS,
		Material.KELP
	};
	final Material[] saplingCycle = {
		Material.ACACIA_SAPLING,
		Material.BIRCH_SAPLING,
		Material.DARK_OAK_SAPLING,
		Material.JUNGLE_SAPLING,
		Material.OAK_SAPLING,
		Material.SPRUCE_SAPLING,
		Material.CRIMSON_FUNGUS,
		Material.WARPED_FUNGUS
	};
	final Material[] fishCycle = {
		Material.COD_SPAWN_EGG,
		Material.TROPICAL_FISH_SPAWN_EGG,
		Material.PUFFERFISH_SPAWN_EGG,
		Material.SALMON_SPAWN_EGG,
		Material.SQUID_SPAWN_EGG,
		Material.DOLPHIN_SPAWN_EGG
	};
	
	public CycleRecipes(Main pl) {
		this.plugin = pl;
		
		Utils.registerRecipeCycle(seedCycle, pl);
		Utils.registerRecipeCycle(saplingCycle, pl);
		Utils.registerRecipeCycle(fishCycle, pl);
	}
}

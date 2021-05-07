package vin.ash.floweroftruth;

import org.bukkit.plugin.java.JavaPlugin;

import vin.ash.floweroftruth.listeners.PlayerInteractListener;
import vin.ash.floweroftruth.recipes.FlowerOfTruthRecipe;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new FlowerOfTruthRecipe(this);
		
		new PlayerInteractListener(this);
	}
	
}

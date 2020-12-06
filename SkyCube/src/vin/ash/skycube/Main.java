package vin.ash.skycube;

import org.bukkit.plugin.java.JavaPlugin;

import vin.ash.skycube.enchants.CustomEnchants;
import vin.ash.skycube.listeners.BlockBreakListener;
import vin.ash.skycube.listeners.JoinListener;
import vin.ash.skycube.recipes.ItemRecipes;
import vin.ash.skycube.recipes.TransmutationRecipes;
import vin.ash.skycube.recipes.UtilRecipes;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new JoinListener(this);
		new BlockBreakListener(this);
		
		new ItemRecipes(this);
		new UtilRecipes(this);
		new TransmutationRecipes(this);
		
		CustomEnchants.register(CustomEnchants.TRANSMUTATION);
	}
	
}

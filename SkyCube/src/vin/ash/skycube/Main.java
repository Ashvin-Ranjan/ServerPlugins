package vin.ash.skycube;

import org.bukkit.plugin.java.JavaPlugin;

import vin.ash.skycube.commands.HelpCommand;
import vin.ash.skycube.enchants.CustomEnchants;
import vin.ash.skycube.listeners.BlockBreakListener;
import vin.ash.skycube.listeners.JoinListener;
import vin.ash.skycube.listeners.PlayerMoveListener;
import vin.ash.skycube.listeners.PlayerRespawnListener;
import vin.ash.skycube.recipes.CycleRecipes;
import vin.ash.skycube.recipes.EndRecipes;
import vin.ash.skycube.recipes.ItemRecipes;
import vin.ash.skycube.recipes.NetherRecipes;
import vin.ash.skycube.recipes.SpawnEggRecipes;
import vin.ash.skycube.recipes.TransmutationRecipes;
import vin.ash.skycube.recipes.UtilRecipes;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();

		new PlayerRespawnListener(this);
		new JoinListener(this);
		new BlockBreakListener(this);
		new PlayerMoveListener(this);
		
		new ItemRecipes(this);
		new UtilRecipes(this);
		new TransmutationRecipes(this);
		new CycleRecipes(this);
		new SpawnEggRecipes(this);
		new NetherRecipes(this);
		new EndRecipes(this);
		
		new HelpCommand(this);
		
		CustomEnchants.register(CustomEnchants.TRANSMUTATION);
	}
	
}

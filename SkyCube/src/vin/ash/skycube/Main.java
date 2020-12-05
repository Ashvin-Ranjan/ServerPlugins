package vin.ash.skycube;

import org.bukkit.plugin.java.JavaPlugin;

import vin.ash.skycube.commands.GetTimeCommand;
import vin.ash.skycube.commands.HomeCommand;
import vin.ash.skycube.commands.ShareLocationCommand;
import vin.ash.skycube.recipes.ItemRecipes;
import vin.ash.skycube.recipes.UtilRecipes;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new HomeCommand(this);
		new ShareLocationCommand(this);
		new GetTimeCommand(this);
		
		new ItemRecipes(this);
		new UtilRecipes(this);
	}
	
}

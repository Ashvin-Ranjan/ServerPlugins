package vin.ash.playablevoid;

import org.bukkit.plugin.java.JavaPlugin;

import vin.ash.playablevoid.generators.VoidGenerator;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new VoidGenerator(this);
	}
	
}

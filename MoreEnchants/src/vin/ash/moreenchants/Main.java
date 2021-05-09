package vin.ash.moreenchants;

import org.bukkit.plugin.java.JavaPlugin;

import vin.ash.moreenchants.enchants.CustomEnchants;
import vin.ash.moreenchants.listeners.BlockBreakListener;
import vin.ash.moreenchants.listeners.EntityDamageByEntityListener;
import vin.ash.moreenchants.listeners.PlayerMoveListener;
import vin.ash.moreenchants.listeners.PrepareAnvilListener;
import vin.ash.moreenchants.recipes.EnchantedBooksRecipes;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new EntityDamageByEntityListener(this);
		new PrepareAnvilListener(this);
		new BlockBreakListener(this);
		new PlayerMoveListener(this);
		
		new EnchantedBooksRecipes(this);
		
		if(getConfig().getBoolean("enderSlayer"))
			CustomEnchants.register(CustomEnchants.ENDER_SLAYER);
		if(getConfig().getBoolean("planting"))
			CustomEnchants.register(CustomEnchants.PLANTING);
		if(getConfig().getBoolean("cubeism"))
			CustomEnchants.register(CustomEnchants.CUBEISM);
		if(getConfig().getBoolean("speed"))
			CustomEnchants.register(CustomEnchants.SPEED);
		if(getConfig().getBoolean("glowing"))
			CustomEnchants.register(CustomEnchants.GLOWING);
		if(getConfig().getBoolean("fireFist"))
			CustomEnchants.register(CustomEnchants.FIRE_FIST);
	}
	
}

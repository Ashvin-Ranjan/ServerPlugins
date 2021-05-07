package vin.ash.moreenchants;

import org.bukkit.plugin.java.JavaPlugin;

import vin.ash.moreenchants.enchants.CustomEnchants;
import vin.ash.moreenchants.listeners.BlockBreakListener;
import vin.ash.moreenchants.listeners.EntityDamageByEntityListener;
import vin.ash.moreenchants.listeners.PrepareAnvilListener;
import vin.ash.moreenchants.recipes.EnchantedBooksRecipes;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		new EntityDamageByEntityListener(this);
		new PrepareAnvilListener(this);
		new BlockBreakListener(this);
		
		new EnchantedBooksRecipes(this);
		
		CustomEnchants.register(CustomEnchants.ENDER_SLAYER);
		CustomEnchants.register(CustomEnchants.PLANTING);
	}
	
}

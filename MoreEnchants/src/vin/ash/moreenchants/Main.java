package vin.ash.moreenchants;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import vin.ash.moreenchants.enchants.CustomEnchants;
import vin.ash.moreenchants.listeners.ArmorEquipListener;
import vin.ash.moreenchants.listeners.ArmorListener;
import vin.ash.moreenchants.listeners.BlockBreakListener;
import vin.ash.moreenchants.listeners.DispenserArmorListener;
import vin.ash.moreenchants.listeners.EntityDamageByEntityListener;
import vin.ash.moreenchants.listeners.PrepareAnvilListener;
import vin.ash.moreenchants.recipes.EnchantedBooksRecipes;

public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new EntityDamageByEntityListener(this);
		new PrepareAnvilListener(this);
		new BlockBreakListener(this);
		new ArmorEquipListener(this);
		
		new EnchantedBooksRecipes(this);
		
		if(getConfig().getBoolean("enderSlayer"))
			CustomEnchants.register(CustomEnchants.ENDER_SLAYER);
		if(getConfig().getBoolean("planting"))
			CustomEnchants.register(CustomEnchants.PLANTING);
		if(getConfig().getBoolean("cubeism"))
			CustomEnchants.register(CustomEnchants.CUBEISM);
		if(getConfig().getBoolean("speed"))
			CustomEnchants.register(CustomEnchants.SPEED);
		
		getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
		
		try {
			Class.forName("org.bukkit.event.block.BlockDispenseArmorEvent");
			getServer().getPluginManager().registerEvents((Listener) new DispenserArmorListener(), this);
		} catch (Exception e) {}
	}
	
}

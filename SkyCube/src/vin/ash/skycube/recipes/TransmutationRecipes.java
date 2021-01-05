package vin.ash.skycube.recipes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import vin.ash.skycube.Main;
import vin.ash.skycube.enchants.CustomEnchants;

public class TransmutationRecipes {
	Main plugin;
	
	private static final Material[] PICKAXES = {
			Material.STONE_PICKAXE,
			Material.IRON_PICKAXE,
			Material.GOLDEN_PICKAXE,
			Material.DIAMOND_PICKAXE
	};
	private static final Material[] VALUES = {
			Material.COAL,
			Material.IRON_INGOT,
			Material.GOLD_INGOT,
			Material.REDSTONE,
			Material.LAPIS_LAZULI,
			Material.DIAMOND
	};
	
	public TransmutationRecipes(Main pl) {
		this.plugin = pl;

		for(int i = 0; i < VALUES.length; i++)
		{
			for(Material pick: PICKAXES)
			{
				Bukkit.addRecipe(pickaxeRecipe(pick, VALUES[i], i + 1));
			}
		}
	}
	
	public String roman(int level)
	{
		switch(level) {
			case 1:
				return "I";
			case 2:
				return "II";
			case 3:
				return "III";
			case 4:
				return "IV";
			case 5:
				return "V";
			case 6:
				return "VI";
			
		}
		return "null";
	}
	
	public ShapedRecipe pickaxeRecipe(Material pick, Material val, int level)
	{
		ItemStack item = new ItemStack(pick);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(CustomEnchants.TRANSMUTATION, level, false);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.BLUE + "Transmutation " + roman(level) + ChatColor.RESET);
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, pick.name());
		int index = 0;
		do {
			if(index == 0)
				key = new NamespacedKey(plugin, pick.name());
			else
				key = new NamespacedKey(plugin, pick.name() + index);
			index++;
		} while (Bukkit.getRecipe(key) != null);
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("VVV", "VPV", "VVV");
		
		recipe.setIngredient('V', val);
		recipe.setIngredient('P', pick);
		
		return recipe;
	}
	
}

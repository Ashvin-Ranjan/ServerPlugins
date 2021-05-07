package vin.ash.moreenchants.recipes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import vin.ash.moreenchants.Main;
import vin.ash.moreenchants.enchants.CustomEnchants;
import vin.ash.moreenchants.utils.Utils;

public class EnchantedBooksRecipes {
	Main plugin;
	
	public EnchantedBooksRecipes(Main pl) {
		this.plugin = pl;

		if(plugin.getConfig().getBoolean("ender_slayer"))
			Bukkit.addRecipe(enchantedBookRecipe(CustomEnchants.ENDER_SLAYER, Material.ENDER_PEARL, "ender_slayer"));
		if(plugin.getConfig().getBoolean("planting"))
			Bukkit.addRecipe(enchantedBookRecipe(CustomEnchants.PLANTING, Material.HAY_BLOCK, "planting"));
		if(plugin.getConfig().getBoolean("cubeism"))
			Bukkit.addRecipe(enchantedBookRecipe(CustomEnchants.CUBEISM, Material.CARVED_PUMPKIN, "cubeism"));
	}
	
	@SuppressWarnings("deprecation")
	private ShapelessRecipe enchantedBookRecipe(Enchantment enchant, Material material, String namespace) {
		ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(enchant, 1, false);
		List<String> lore = new ArrayList<String>();
		lore.add(enchant.getName() + " " + Utils.toRoman(1));
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, namespace);
		
		ShapelessRecipe recipe = new ShapelessRecipe(key, item);
		
		recipe.addIngredient(3, Material.PAPER);
		recipe.addIngredient(1, material);
		
		return recipe;
	}
}

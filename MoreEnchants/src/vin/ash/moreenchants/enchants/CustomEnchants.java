package vin.ash.moreenchants.enchants;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;

public class CustomEnchants {
	public static final Enchantment ENDER_SLAYER = new EnchantmentWrapper("ender_slayer", "Ender Slayer", 5, EnchantmentTarget.WEAPON, 1);
	public static final Enchantment PLANTING = new EnchantmentWrapper("planting", "Planting", 1, EnchantmentTarget.TOOL, 1);
	
	public static void register(Enchantment e) {
		boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(e);
		if (!registered)
			registerEnchantment(e);
	}
	
	public static void registerEnchantment(Enchantment e) {
		try {
			Field f = Enchantment.class.getDeclaredField("acceptingNew");
			f.setAccessible(true);
			f.set(null, true);
			Enchantment.registerEnchantment(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

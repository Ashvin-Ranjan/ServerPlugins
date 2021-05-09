package vin.ash.moreenchants.enchants;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;

public class CustomEnchants {
	public static final Enchantment ENDER_SLAYER = new EnchantmentWrapper("ender_slayer", "Ender Slayer", 5, EnchantmentTarget.WEAPON, 1);
	public static final Enchantment PLANTING = new EnchantmentWrapper("planting", "Planting", 1, EnchantmentTarget.TOOL, 1);
	public static final Enchantment CUBEISM = new EnchantmentWrapper("cubeism", "Cubeism", 5, EnchantmentTarget.WEAPON, 1);
	public static final Enchantment SPEED = new EnchantmentWrapper("speed", "Speed", 5, EnchantmentTarget.ARMOR_FEET, 1);
	public static final Enchantment GLOWING = new EnchantmentWrapper("glowing", "Glowing", 3, EnchantmentTarget.WEAPON, 1);
	public static final Enchantment FIRE_FIST = new EnchantmentWrapper("fire_fist", "Fire Fist", 1, EnchantmentTarget.ARMOR_TORSO, 1);
	
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

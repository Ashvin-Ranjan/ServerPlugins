package vin.ash.skycube.enchants;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;

public class CustomEnchants {
	public static final Enchantment TRANSMUTATION = new EnchantmentWrapper("transmutation", "Transmutation", 6, EnchantmentTarget.TOOL);
	
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

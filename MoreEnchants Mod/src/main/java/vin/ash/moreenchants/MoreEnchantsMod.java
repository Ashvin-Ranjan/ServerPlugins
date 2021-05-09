package vin.ash.moreenchants;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import vin.ash.moreenchants.enchants.*;

public class MoreEnchantsMod implements ModInitializer {
	
	// Registers Enchants
	private static Enchantment ENDER_SLAYER = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("moreenchants", "ender_slayer"),
			new EnderSlayerEnchantment());
	private static Enchantment CUBEISM = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("moreenchants", "cubeism"),
			new CubeismEnchant());
	private static Enchantment FIRE_FIST = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("moreenchants", "fire_fist"),
			new FireFistEnchant());
	private static Enchantment GLOWING = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("moreenchants", "glowing"),
			new GlowingEnchant());
	private static Enchantment FROST = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("moreenchants", "frost"),
			new FrostEnchant());
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("More Enchants Initializing, have fun!");
	}
}

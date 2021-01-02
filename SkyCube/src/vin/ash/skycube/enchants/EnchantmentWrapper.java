package vin.ash.skycube.enchants;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class EnchantmentWrapper extends Enchantment{
	
	private final String name;
	private final int maxLvl;
	private final EnchantmentTarget target;
	private final int startLvl;
	private final boolean compatable;
	
	public EnchantmentWrapper(String namespace, String name, int lvl) {
		super(NamespacedKey.minecraft(namespace));
		this.name = name;
		this.maxLvl = lvl;
		this.target = null;
		this.startLvl = 0;
		this.compatable = true;
	}
	
	public EnchantmentWrapper(String namespace, String name, int lvl, EnchantmentTarget target) {
		super(NamespacedKey.minecraft(namespace));
		this.name = name;
		this.maxLvl = lvl;
		this.target = target;
		this.startLvl = 0;
		this.compatable = true;
	}
	
	public EnchantmentWrapper(String namespace, String name, int lvl, EnchantmentTarget target, int startLvl) {
		super(NamespacedKey.minecraft(namespace));
		this.name = name;
		this.maxLvl = lvl;
		this.target = target;
		this.startLvl = startLvl;
		this.compatable = true;
	}
	
	public EnchantmentWrapper(String namespace, String name, int lvl, EnchantmentTarget target, int startLvl, boolean compatable) {
		super(NamespacedKey.minecraft(namespace));
		this.name = name;
		this.maxLvl = lvl;
		this.target = target;
		this.startLvl = startLvl;
		this.compatable = compatable;
	}

	@Override
	public boolean canEnchantItem(ItemStack arg0) {
		return false;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return !compatable;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return target;
	}

	@Override
	public int getMaxLevel() {
		return maxLvl;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getStartLevel() {
		return startLvl;
	}

	@Override
	public boolean isCursed() {
		return false;
	}

	@Override
	public boolean isTreasure() {
		return false;
	}

}

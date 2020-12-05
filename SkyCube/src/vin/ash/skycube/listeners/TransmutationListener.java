package vin.ash.skycube.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import vin.ash.skycube.Main;
import vin.ash.skycube.enchants.CustomEnchants;

public class TransmutationListener implements Listener{
	private Main plugin;
	
	public TransmutationListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getItemInMainHand() == null)
			return;
		if(!p.getInventory().getItemInMainHand().hasItemMeta())
			return;
		if(!p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.TRANSMUTATION))
			return;
		if(p.getGameMode() != GameMode.SURVIVAL)
			return;

		ItemStack replacement;
		
		switch (p.getInventory().getItemInMainHand().getEnchantments().get(CustomEnchants.TRANSMUTATION)) {
			case 1:
				replacement = new ItemStack(Material.COAL, 1);
				break;
			case 2:
				replacement = new ItemStack(Material.IRON_INGOT, 1);
				break;
			case 3:
				replacement = new ItemStack(Material.GOLD_INGOT, 1);
				break;
			case 4:
				replacement = new ItemStack(Material.REDSTONE, 1);
				break;
			case 5:
				replacement = new ItemStack(Material.LAPIS_LAZULI, 1);
				break;
			case 6:
				replacement = new ItemStack(Material.DIAMOND, 1);
				break;
			default:
				replacement = new ItemStack(Material.COBBLESTONE, 1);
				break;
		}
		e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), replacement);
		e.setDropItems(false);
	}
}

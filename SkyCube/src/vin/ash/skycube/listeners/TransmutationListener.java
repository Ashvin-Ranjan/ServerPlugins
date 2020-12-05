package vin.ash.skycube.listeners;

import java.util.Calendar;
import java.util.Random;

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
		if(e.getBlock() != Material.STONE.createBlockData() || e.getBlock() != Material.COBBLESTONE.createBlockData())
			return;
		if(p.getInventory().getItemInMainHand().getEnchantmentLevel(CustomEnchants.TRANSMUTATION) < 1)
		
		e.setDropItems(false);
		ItemStack replacement;
		switch (p.getInventory().getItemInMainHand().getEnchantmentLevel(CustomEnchants.TRANSMUTATION)) {
			case 1:
				replacement = new ItemStack(Material.COAL);
				break;
			case 2:
				replacement = new ItemStack(Material.IRON_INGOT);
				break;
			case 3:
				replacement = new ItemStack(Material.GOLD_INGOT);
				break;
			case 4:
				replacement = new ItemStack(Material.REDSTONE);
				break;
			case 5:
				replacement = new ItemStack(Material.LAPIS_LAZULI);
				break;
			case 6:
				replacement = new ItemStack(Material.DIAMOND);
				break;
			default:
				return;
		}
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		replacement.setAmount(r.nextInt(2) + 1);
		e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), replacement);
	}
}
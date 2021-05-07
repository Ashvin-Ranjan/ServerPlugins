package vin.ash.moreenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import vin.ash.moreenchants.Main;
import vin.ash.moreenchants.enchants.CustomEnchants;
import vin.ash.moreenchants.utils.Utils;

public class BlockBreakListener implements Listener{
	private Main plugin;
	
	public BlockBreakListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	private void handlePlanting(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getItemInMainHand() == null)
			return;
		if(!p.getInventory().getItemInMainHand().hasItemMeta())
			return;
		if(!p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.PLANTING))
			return;
		if(!Utils.isHoe(p.getInventory().getItemInMainHand().getType()))
			return;
		if(!Utils.isPlant(e.getBlock().getType()))
			return;
		

		Ageable age = (Ageable) e.getBlock().getBlockData();
		if (age.getAge() != age.getMaximumAge())
			return;
		
		e.setCancelled(true);
		age.setAge(0); // Setting the crop's state back to when it was planted
		e.getBlock().setBlockData(age);
		
		if(e.getBlock().getType() == Material.WHEAT) {
			e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.WHEAT, 2));
		}
		
		for (ItemStack drop : e.getBlock().getDrops()) {
			e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(drop.getType(), 2));
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(plugin.getConfig().getBoolean("planting"))
			handlePlanting(e);
	}
}
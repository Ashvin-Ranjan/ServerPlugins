package vin.ash.skycube.listeners;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

public class BlockBreakListener implements Listener{
	private Main plugin;
	
	public BlockBreakListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	private void transmutation(BlockBreakEvent e) {
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
		e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), replacement);
		e.setDropItems(false);
	}
	
	private void regenerate(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(e.getBlock().getType() != Material.COBBLESTONE)
			return;
		File file = new File(plugin.getDataFolder(), plugin.getConfig().getString("unbreakable_file") + ".txt");
	    if(!file.exists())
	    	return;
		
	    try {
	    	Scanner myReader = new Scanner(file);
	    	String out = "";
	        while (myReader.hasNextLine()) {
	          out += myReader.nextLine();
	        }
	        myReader.close();
	        String[] coords = out.split("\\|");
	        String blockloc = e.getBlock().getLocation().getBlockX() + " " + e.getBlock().getLocation().getBlockY() + " " + e.getBlock().getLocation().getBlockZ();
	        for(String c : coords) {
	        	System.out.println(c);
	        	System.out.println(blockloc);
	        	System.out.println(c.compareTo(blockloc));
	        	if(c.compareTo(blockloc) == 0) {
	        		e.setCancelled(true);
	        		if(p.getInventory().getItemInMainHand() == null || !p.getInventory().getItemInMainHand().hasItemMeta() || !p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.TRANSMUTATION) || p.getGameMode() != GameMode.SURVIVAL) 
	        			e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(Material.COBBLESTONE, 1));
	        		return;
	        	}
	        }

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return;
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		transmutation(e);
		regenerate(e);
	}
}

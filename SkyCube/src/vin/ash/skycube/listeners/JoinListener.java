package vin.ash.skycube.listeners;

import java.util.Calendar;
import java.util.Collection;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import vin.ash.skycube.Main;
import vin.ash.skycube.utils.Utils;

public class JoinListener implements Listener{
	
	private Main plugin;
	
	public JoinListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if (!p.hasPlayedBefore()) {
			//TODO initialize island for player to join
			//Find if there are any players online
			if(plugin.getServer().getOnlinePlayers() != null) {
				if(plugin.getServer().getOnlinePlayers().size() != 0) {
					//If there is an online player spawn the new one within 6 chunks of their spawn
					Location spawn = findSpawnLocation(p, plugin.getServer().getOnlinePlayers(), Utils.getAllPlayers(Bukkit.getServer()));
					p.setBedSpawnLocation(spawn);
					p.teleport(spawn);
					generateIsland(spawn);
					
				} else if(plugin.getServer().getOfflinePlayers() != null ) {
					//If there are no online players then spawn the new one within 6 chunks of a offline players spawn
					Location spawn = findSpawnLocation(p, Utils.toOnlinePlayer(plugin.getServer().getOfflinePlayers()));
					p.setBedSpawnLocation(spawn);
					p.teleport(spawn);
					generateIsland(spawn);
				} else {
					//If this is the first player then spawn them at 0, 0, 0
					p.setBedSpawnLocation(new Location(Bukkit.getServer().getWorlds().get(0), 0, 0, 65));
					p.teleport(new Location(Bukkit.getServer().getWorlds().get(0), 0, 0, 65));
					generateIsland(new Location(Bukkit.getServer().getWorlds().get(0), 0, 0, 65));
				}
			}
			
			//Messages for the new players
			Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("messageJoin_first").replace("<player>", p.getName())));
			p.sendMessage(Utils.chat(plugin.getConfig().getString("messageTutorial_start")));
		} else {
			Bukkit.broadcastMessage(Utils.chat(plugin.getConfig().getString("messageJoin_default").replace("<player>", p.getName())));
		}
	}
	
	void generateIsland(Location playerloc) {
		World w = plugin.getServer().getWorlds().get(0);
		int x = playerloc.getBlockX();
		int y = playerloc.getBlockY();
		int z = playerloc.getBlockZ();
		//the top layer is logs
		w.getBlockAt(x, y-1, z).setBlockData(Material.OAK_LOG.createBlockData());
		w.getBlockAt(x-1, y-1, z).setBlockData(Material.OAK_LOG.createBlockData());
		w.getBlockAt(x+1, y-1, z).setBlockData(Material.OAK_LOG.createBlockData());
		w.getBlockAt(x-1, y-1, z-1).setBlockData(Material.OAK_LOG.createBlockData());
		w.getBlockAt(x-1, y-1, z+1).setBlockData(Material.OAK_LOG.createBlockData());
		w.getBlockAt(x+1, y-1, z-1).setBlockData(Material.OAK_LOG.createBlockData());
		w.getBlockAt(x+1, y-1, z+1).setBlockData(Material.OAK_LOG.createBlockData());
		w.getBlockAt(x, y-1, z-1).setBlockData(Material.OAK_LOG.createBlockData());
		w.getBlockAt(x, y-1, z+1).setBlockData(Material.OAK_LOG.createBlockData());
		//the middle layer is grass
		w.getBlockAt(x, y-2, z).setBlockData(Material.GRASS_BLOCK.createBlockData());
		w.getBlockAt(x-1, y-2, z).setBlockData(Material.GRASS_BLOCK.createBlockData());
		w.getBlockAt(x+1, y-2, z).setBlockData(Material.GRASS_BLOCK.createBlockData());
		w.getBlockAt(x-1, y-2, z-1).setBlockData(Material.GRASS_BLOCK.createBlockData());
		w.getBlockAt(x-1, y-2, z+1).setBlockData(Material.GRASS_BLOCK.createBlockData());
		w.getBlockAt(x+1, y-2, z-1).setBlockData(Material.GRASS_BLOCK.createBlockData());
		w.getBlockAt(x+1, y-2, z+1).setBlockData(Material.GRASS_BLOCK.createBlockData());
		w.getBlockAt(x, y-2, z-1).setBlockData(Material.GRASS_BLOCK.createBlockData());
		w.getBlockAt(x, y-2, z+1).setBlockData(Material.GRASS_BLOCK.createBlockData());
		//stone, water, and lava
		w.getBlockAt(x, y-3, z).setBlockData(Material.STONE.createBlockData());
		w.getBlockAt(x-1, y-3, z).setBlockData(Material.WATER.createBlockData());
		w.getBlockAt(x+1, y-3, z).setBlockData(Material.LAVA.createBlockData());
		w.getBlockAt(x-1, y-3, z-1).setBlockData(Material.WATER.createBlockData());
		w.getBlockAt(x-1, y-3, z+1).setBlockData(Material.WATER.createBlockData());
		w.getBlockAt(x+1, y-3, z-1).setBlockData(Material.LAVA.createBlockData());
		w.getBlockAt(x+1, y-3, z+1).setBlockData(Material.LAVA.createBlockData());
		w.getBlockAt(x, y-3, z-1).setBlockData(Material.STONE.createBlockData());
		w.getBlockAt(x, y-3, z+1).setBlockData(Material.STONE.createBlockData());
	}
	
	Location findSpawnLocation(Player p, Player[] playerlist) {
		Location endloc;
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		Player spawnp = (Player) playerlist[r.nextInt(playerlist.length)];
		boolean correctspawn = false;
		do {
			boolean fail = false;
			endloc = spawnp.getBedSpawnLocation().add(new Location(Bukkit.getServer().getWorlds().get(0), r.nextInt(25) + 25, r.nextInt(25) + 25, 0));
			for (Player pl : playerlist){
				if(Utils.getDist(endloc, pl.getBedSpawnLocation()) < 15) {
					spawnp = pl;
					fail = true;
					break;
				}
			}
			if(!fail) {
				correctspawn = true;
			}
		} while (!correctspawn);
		
		return endloc;
	}
	
	Location findSpawnLocation(Player p, Collection<? extends Player> playerlist, Player[] full) {
		Location endloc;
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		Player spawnp = (Player) playerlist.toArray()[r.nextInt(playerlist.size())];
		boolean correctspawn = false;
		do {
			boolean fail = false;
			endloc = spawnp.getBedSpawnLocation().add(new Location(Bukkit.getServer().getWorlds().get(0), r.nextInt(25) + 25, r.nextInt(25) + 25, 0));
			for (Player pl : full){
				if(Utils.getDist(endloc, pl.getBedSpawnLocation()) < 15) {
					spawnp = pl;
					fail = true;
					break;
				}
			}
			if(!fail) {
				correctspawn = true;
			}
		} while (!correctspawn);
		
		return endloc;
	}
	
}

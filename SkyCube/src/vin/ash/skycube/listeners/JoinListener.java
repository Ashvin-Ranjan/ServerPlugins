package vin.ash.skycube.listeners;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
			//Find if there are any players online
			if(plugin.getServer().getOnlinePlayers() != null) {
				if(plugin.getServer().getOnlinePlayers().size() > 1 || plugin.getServer().getOfflinePlayers().length > 1) {
					//If this is not the first player then spawn them in a random location
					Location spawn = Utils.getRandomLocation(plugin.getServer().getWorlds().get(0), plugin.getConfig().getInt("spawn_spread"));
					
					p.setBedSpawnLocation(spawn);
					p.teleport(spawn);
					generateIsland(spawn);
					registerSpawn(spawn, p);
					
				} else {
					//If this is the first player then spawn them at 0, 65, 0
					Location spawn = new Location(Bukkit.getServer().getWorlds().get(0), 0, 65, 0);
					int iter = 0;
					while(!awayFromPlayers(spawn)) {
						spawn = new Location(Bukkit.getServer().getWorlds().get(0), 0 + iter, 65, 0 + iter);
						iter++;
					}
					p.setBedSpawnLocation(spawn);
					p.teleport(spawn);
					generateIsland(spawn);
					registerSpawn(spawn, p);
				}
			}
			
			//Messages for the new players
			e.setJoinMessage(Utils.chat(plugin.getConfig().getString("messageJoin_first").replace("<player>", p.getName())));
			p.sendMessage(Utils.chat(plugin.getConfig().getString("messageTutorial_start")));
			Utils.playerQuickStart(p, plugin);
		} else {
			e.setJoinMessage(Utils.chat(plugin.getConfig().getString("messageJoin_default").replace("<player>", p.getName())));
		}
		
		Utils.playerQuickStart(p, plugin, false);
	}
	
	boolean awayFromPlayers(Location l) {
		File file = new File(plugin.getDataFolder(), plugin.getConfig().getString("spawn_file") + ".json");
		JSONObject playerspawn = new JSONObject();
		if(!file.exists()) {
			return true;
		} else {
			JSONParser parser = new JSONParser();
			try {
				playerspawn = (JSONObject) parser.parse(new FileReader(file));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		boolean check = true;
		for(Object key : playerspawn.keySet().toArray()) {
			if(Utils.getDist(l,  Utils.stringToLocation(l.getWorld(), (String) playerspawn.get(key))) <= plugin.getConfig().getInt("minDistAway")) 
				check = false;
		}
		
		return check;
	}
	
	void generateIsland(Location playerloc) {
		World w = plugin.getServer().getWorlds().get(0);
		int x = playerloc.getBlockX();
		int y = playerloc.getBlockY();
		int z = playerloc.getBlockZ();
		
		
		
		
		//Adding air
		w.getBlockAt(x, y, z).setBlockData(Material.AIR.createBlockData());
		w.getBlockAt(x, y+1, z).setBlockData(Material.AIR.createBlockData());
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
		w.getBlockAt(x, y-3, z).setBlockData(Material.COBBLESTONE.createBlockData());
		w.getBlockAt(x-1, y-3, z).setBlockData(Material.COBBLESTONE.createBlockData());
		w.getBlockAt(x+1, y-3, z).setBlockData(Material.COBBLESTONE.createBlockData());
		w.getBlockAt(x-1, y-3, z-1).setBlockData(Material.COBBLESTONE.createBlockData());
		w.getBlockAt(x-1, y-3, z+1).setBlockData(Material.COBBLESTONE.createBlockData());
		w.getBlockAt(x+1, y-3, z-1).setBlockData(Material.COBBLESTONE.createBlockData());
		w.getBlockAt(x+1, y-3, z+1).setBlockData(Material.COBBLESTONE.createBlockData());
		w.getBlockAt(x, y-3, z-1).setBlockData(Material.COBBLESTONE.createBlockData());
		w.getBlockAt(x, y-3, z+1).setBlockData(Material.COBBLESTONE.createBlockData());
		//Made blocks unbreakable
		File file = new File(plugin.getDataFolder(), plugin.getConfig().getString("unbreakable_file") + ".txt");
		boolean creatednew = !file.exists();
	    if(!file.exists()){
	        try {
	            file.createNewFile();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    try {
	        FileWriter writer = new FileWriter(file, true);
	        int[][] lis = {{x, y-3, z+1} , {x, y-3, z}, {x-1, y-3, z}, {x+1, y-3, z}, {x-1, y-3, z-1}, {x-1, y-3, z+1}, {x+1, y-3, z-1}, {x+1, y-3, z+1}, {x, y-3, z-1}};
	        if(!creatednew)
	        	writer.write("|");
	        for(int i = 0; i < lis.length; i++) {
	        	for(int j = 0; j < lis[i].length; j++) {
	        		if(j == lis[i].length - 1)
	        			writer.write(Integer.toString(lis[i][j]));
	        		else
	        			writer.write(lis[i][j] + " ");
	        	}
	        	if(i != lis.length - 1)
	        		writer.write("|");
	        }
	        writer.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	@SuppressWarnings("unchecked")
	private void registerSpawn(Location spawn, Player p) {
		File file = new File(plugin.getDataFolder(), plugin.getConfig().getString("spawn_file") + ".json");
		JSONObject playerspawn = new JSONObject();
		if(!file.exists()) {
			try {
	            file.createNewFile();
	        } catch (IOException es) {
	            es.printStackTrace();
	        }
		} else {
			JSONParser parser = new JSONParser();
			try {
				playerspawn = (JSONObject) parser.parse(new FileReader(file));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		playerspawn.put(p.getUniqueId().toString(), spawn.getBlockX() + " " + spawn.getBlockY() + " " + spawn.getBlockZ());
		
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(playerspawn.toJSONString());
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
}

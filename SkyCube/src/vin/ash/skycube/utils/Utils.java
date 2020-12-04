package vin.ash.skycube.utils;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;


public class Utils {
	
	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static double getDist(Location a, Location b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2)+Math.pow(a.getZ() - b.getZ(), 2));
	}
	
	public static Player[] getAllPlayers(Server s) {
		return (Player[]) ArrayUtils.addAll(s.getOnlinePlayers().toArray(), toOnlinePlayer(s.getOfflinePlayers()));
	}
	
	public static Player[] toOnlinePlayer(OfflinePlayer[] p) {
		Player[] pl = new Player[p.length];
		for(int i = 0; i < p.length; i++) {
			pl[i] = p[i].getPlayer();
		}
		return pl;
	}
	
}

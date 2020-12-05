package vin.ash.skycube.utils;

import java.util.Calendar;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;


public class Utils {
	
	public static String chat (String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static double getDist(Location a, Location b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2)+Math.pow(a.getZ() - b.getZ(), 2));
	}
	
	public static Location getRandomLocation(World w, int spread) {
		Random r = new Random(Calendar.getInstance().getTimeInMillis());
		return new Location(w, r.nextDouble() * spread, 65, r.nextDouble() * spread);
	}

	
	
}

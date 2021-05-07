package vin.ash.moreenchants.utils;

import java.util.TreeMap;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class Utils {
	
	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public final static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }
    
    public static boolean isSword(Material m) {
    	return m == Material.WOODEN_SWORD || m == Material.STONE_SWORD || m == Material.IRON_SWORD || m == Material.GOLDEN_SWORD || m == Material.DIAMOND_SWORD || m == Material.NETHERITE_SWORD;
    }
    
    public static boolean isHoe(Material m) {
    	return m == Material.WOODEN_HOE || m == Material.STONE_HOE || m == Material.IRON_HOE || m == Material.GOLDEN_HOE || m == Material.DIAMOND_HOE || m == Material.NETHERITE_HOE;
    }
    
    public static boolean isPlant(Material m) {
    	return m == Material.WHEAT || m == Material.POTATOES || m == Material.BEETROOTS || m == Material.CARROTS || m == Material.NETHER_WART;
    }
	
}

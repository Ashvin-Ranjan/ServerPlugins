package vin.ash.playablevoid.generators;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import vin.ash.playablevoid.Main;

public class VoidGenerator extends ChunkGenerator {
	
	private Main plugin;
	
	public VoidGenerator(Main pl) {
		this.plugin = pl;
	}
    
    //This needs to be set to return true to override minecraft's default behaviour
    @Override
    public boolean canSpawn(World world, int x, int z) {
        return true;
    }
    
    @Override
    public boolean shouldGenerateCaves() {
    	return plugin.getConfig().getBoolean("generateCaves");
    }
    
    @Override
    public boolean shouldGenerateStructures() {
    	return plugin.getConfig().getBoolean("generateStructures");
    }
    
    @Override
    public boolean shouldGenerateDecorations() {
    	return plugin.getConfig().getBoolean("generateDecorations");
    }
    
    @Override
    public boolean shouldGenerateMobs() {
    	return plugin.getConfig().getBoolean("generateMobs");
    }

    public ChunkData generateChunkData​(World world, Random rand, int x, int z, ChunkData biome) {
    	ChunkData result = createChunkData(world);

	    // This sets everything to air
	    result.setRegion(x * 16, 0, z * 16, (x * 16) + 16, 256, (z * 16) + 16, Material.AIR);
	    
	    return result;
	}
}

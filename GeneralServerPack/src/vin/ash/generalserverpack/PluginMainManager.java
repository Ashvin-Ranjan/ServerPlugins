package vin.ash.generalserverpack;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import vin.ash.generalserverpack.commands.GetTimeCommand;
import vin.ash.generalserverpack.commands.HelloCommand;
import vin.ash.generalserverpack.commands.HomeCommand;
import vin.ash.generalserverpack.commands.ShareLocationCommand;

public class PluginMainManager extends JavaPlugin{
	
	public HashMap<UUID, int[]> homeData = new HashMap<UUID, int[]>();
	
	@Override
	public void onEnable() {
		new HelloCommand(this);
		new HomeCommand(this);
		new ShareLocationCommand(this);
		new GetTimeCommand(this);
	}
	
}

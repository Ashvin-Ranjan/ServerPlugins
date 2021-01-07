package vin.ash.skycube.commands;

import org.bukkit.entity.Player;

public class TeleportRequest {
	private Player from;
	private Player to;
	private long time;
	
	public TeleportRequest(Player p, Player t)
	{
		from = p;
		to = t;
		time = System.currentTimeMillis();
	}
	
	public Player getFrom()
	{
		return from;
	}
	
	public Player getTo()
	{
		return to;
	}
	
	public long getTime()
	{
		return time;
	}
	
	public void setFrom(Player p)
	{
		from = p;
	}
	
	public void setTo(Player p)
	{
		to = p;
	}
	
	public void setTime(long t)
	{
		time = t;
	}
	
	public boolean isValid()
	{
		return (System.currentTimeMillis() - getTime() < 30000);
	}
}

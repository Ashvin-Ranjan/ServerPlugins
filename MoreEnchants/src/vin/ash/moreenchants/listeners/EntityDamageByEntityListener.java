package vin.ash.moreenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import vin.ash.moreenchants.Main;
import vin.ash.moreenchants.enchants.CustomEnchants;
import vin.ash.moreenchants.utils.Utils;

public class EntityDamageByEntityListener implements Listener{
	private Main plugin;
	
	public EntityDamageByEntityListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType() != EntityType.PLAYER)
			return;
		Player p = (Player) e.getDamager();
		if(p.getInventory().getItemInMainHand() == null)
			return;
		if(!p.getInventory().getItemInMainHand().hasItemMeta())
			return;
		if(!p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.ENDER_SLAYER))
			return;
		if(!Utils.isSword(p.getInventory().getItemInMainHand().getType()))
			return;
		if(e.getEntityType() != EntityType.ENDERMAN && e.getEntityType() != EntityType.ENDERMITE && e.getEntityType() != EntityType.ENDER_DRAGON && e.getEntityType() != EntityType.SHULKER)
			return;
		
		
		e.setDamage(e.getDamage() + (p.getInventory().getItemInMainHand().getEnchantments().get(CustomEnchants.ENDER_SLAYER) * 2.5));
	}
}
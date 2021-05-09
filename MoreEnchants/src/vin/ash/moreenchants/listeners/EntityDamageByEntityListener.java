package vin.ash.moreenchants.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import vin.ash.moreenchants.Main;
import vin.ash.moreenchants.enchants.CustomEnchants;

public class EntityDamageByEntityListener implements Listener{
	private Main plugin;
	
	public EntityDamageByEntityListener(Main pl) {
		this.plugin = pl;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	private void handleEnderSlayer(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType() != EntityType.PLAYER)
			return;
		Player p = (Player) e.getDamager();
		if(p.getInventory().getItemInMainHand() == null)
			return;
		if(!p.getInventory().getItemInMainHand().hasItemMeta())
			return;
		if(!p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.ENDER_SLAYER))
			return;
		if(!CustomEnchants.ENDER_SLAYER.canEnchantItem(p.getInventory().getItemInMainHand()))
			return;
		if(e.getEntityType() != EntityType.ENDERMAN && e.getEntityType() != EntityType.ENDERMITE && e.getEntityType() != EntityType.ENDER_DRAGON && e.getEntityType() != EntityType.SHULKER)
			return;
		
		
		e.setDamage(e.getDamage() + (p.getInventory().getItemInMainHand().getEnchantments().get(CustomEnchants.ENDER_SLAYER) * 2.5));
	}

	private void handleCubeism(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType() != EntityType.PLAYER)
			return;
		Player p = (Player) e.getDamager();
		if(p.getInventory().getItemInMainHand() == null)
			return;
		if(!p.getInventory().getItemInMainHand().hasItemMeta())
			return;
		if(!p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.CUBEISM))
			return;
		if(!CustomEnchants.CUBEISM.canEnchantItem(p.getInventory().getItemInMainHand()))
			return;
		if(e.getEntityType() != EntityType.CREEPER && e.getEntityType() != EntityType.SLIME && e.getEntityType() != EntityType.MAGMA_CUBE && e.getEntityType() != EntityType.SHULKER)
			return;
		
		
		e.setDamage(e.getDamage() + (p.getInventory().getItemInMainHand().getEnchantments().get(CustomEnchants.CUBEISM) * 2.5));
	}

	private void handleGlowing(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType() != EntityType.PLAYER)
			return;
		Player p = (Player) e.getDamager();
		if(p.getInventory().getItemInMainHand() == null)
			return;
		if(!p.getInventory().getItemInMainHand().hasItemMeta())
			return;
		if(!p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(CustomEnchants.GLOWING))
			return;
		if(!CustomEnchants.GLOWING.canEnchantItem(p.getInventory().getItemInMainHand()))
			return;
		if(!(e.getEntity() instanceof LivingEntity))
			return;
		
		
		LivingEntity other = (LivingEntity) e.getEntity();
		other.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100 * p.getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(CustomEnchants.GLOWING), 255));
	}

	private void handleFireFist(EntityDamageByEntityEvent e) {
		if (e.getDamager().getType() != EntityType.PLAYER)
			return;
		Player p = (Player) e.getDamager();
		if(p.getInventory().getItemInMainHand().getType() != Material.AIR)
			return;
		if(p.getInventory().getChestplate() == null)
			return;
		if(!p.getInventory().getChestplate().hasItemMeta())
			return;
		if(!p.getInventory().getChestplate().getItemMeta().hasEnchant(CustomEnchants.FIRE_FIST))
			return;

		
		e.getEntity().setFireTicks(80);
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if(plugin.getConfig().getBoolean("enderSlayer"))
			handleEnderSlayer(e);
		if(plugin.getConfig().getBoolean("cubeism"))
			handleCubeism(e);
		if(plugin.getConfig().getBoolean("glowing"))
			handleGlowing(e);
		if(plugin.getConfig().getBoolean("fireFist"))
			handleFireFist(e);
	}
}
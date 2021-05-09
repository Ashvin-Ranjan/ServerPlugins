package vin.ash.moreenchants.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class CubeismEnchant extends Enchantment {
	
    public CubeismEnchant() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }
    
    @Override
    public int getMinPower(int level) {
    	return 10 * (level/3);
    }
    
    @Override
    public int getMaxLevel() {
    	return 5;
    }
    
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            LivingEntity hit = (LivingEntity) target;
            if (hit.getType() == EntityType.CREEPER || hit.getType() == EntityType.SLIME || hit.getType() == EntityType.MAGMA_CUBE || hit.getType() == EntityType.SHULKER) {
                hit.setHealth(hit.getHealth() - (level * 2.5f));
                System.out.println("Damaged");
            }
        }
     
        super.onTargetDamaged(user, target, level);
    }
}

package vin.ash.moreenchants.enchants;

import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;

public class FireFistEnchant extends Enchantment {

    public FireFistEnchant() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
    }

    @Override
    public int getMinPower(int level) {
        return 10 * (level/3);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        System.out.println(user.getMainHandStack().getItem() == Items.AIR);
        System.out.println(user.getMainHandStack().getItem());
        if(user.getMainHandStack().getItem() == Items.AIR)
            target.setFireTicks(80);
        super.onTargetDamaged(user, target, level);
    }
}

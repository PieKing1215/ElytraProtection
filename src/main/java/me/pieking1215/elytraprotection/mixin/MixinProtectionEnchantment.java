package me.pieking1215.elytraprotection.mixin;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ProtectionEnchantment.class)
public class MixinProtectionEnchantment {

    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;<init>(Lnet/minecraft/enchantment/Enchantment$Rarity;Lnet/minecraft/enchantment/EnchantmentTarget;[Lnet/minecraft/entity/EquipmentSlot;)V"))
    private static EnchantmentTarget inj(EnchantmentTarget orig){
        if(orig == EnchantmentTarget.ARMOR) return EnchantmentTarget.WEARABLE;
        return orig;
    }

}

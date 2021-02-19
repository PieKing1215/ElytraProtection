package me.pieking1215.elytraprotection.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ProtectionEnchantment.class)
public class MixinProtectionEnchantment {

    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(Enchantment.Rarity weight, ProtectionEnchantment.Type type, EquipmentSlot[] slotTypes, CallbackInfo callback){
        ProtectionEnchantment self = (ProtectionEnchantment)(Object)this;

        // change protection enchantments to be available on all wearables (includes blast/fire/proj prot)
        // TODO: come up with a way to make this only apply to elytra (mixin a new EnchantmentTarget?)
        if(self.type == EnchantmentTarget.ARMOR) {
            ((EnchantmentAccessor)self).setType(EnchantmentTarget.WEARABLE);
        }
    }

}

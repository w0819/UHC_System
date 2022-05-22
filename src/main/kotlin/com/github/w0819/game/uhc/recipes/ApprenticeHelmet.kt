package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Apprentice
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object ApprenticeHelmet : Apprentice(
    NamespacedKey.minecraft("apprentice_helmet"),
    ApprenticeHelmet
) {
    init {
        shape(
            "111",
            "121",
            "   "
        )
        setIngredient('1', Material.IRON_INGOT)
        setIngredient('2', Material.REDSTONE_TORCH)
    }
    object ApprenticeHelmet : Item(
        ItemStack(Material.IRON_HELMET)
    ) {
        init {
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1)
            addEnchantment(Enchantment.PROTECTION_EXPLOSIONS,1)
            addEnchantment(Enchantment.PROTECTION_PROJECTILE,1)
            addEnchantment(Enchantment.PROTECTION_FIRE,1)
        }
    }
}
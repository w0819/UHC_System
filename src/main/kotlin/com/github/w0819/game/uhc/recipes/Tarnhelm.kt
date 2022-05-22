package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Engineering
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object Tarnhelm: Engineering(
    NamespacedKey.minecraft("tarnhelm"),
    Tarnhelm,
    3,
    true
) {
    init {
        shape(
            "121",
            "131",
            "   "
        )
        setIngredient('1', Material.DIAMOND)
        setIngredient('2', Material.IRON_INGOT)
        setIngredient('3', Material.REDSTONE_BLOCK)
    }
    object Tarnhelm : Item(
        ItemStack(Material.DIAMOND_HELMET)
    ) {
        init {
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
            addEnchantment(Enchantment.PROTECTION_FIRE, 1)
            addEnchantment(Enchantment.WATER_WORKER, 1)
        }
    }
}
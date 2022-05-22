package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object `Hermes'Boots` : ExtraUltimates(
    NamespacedKey.minecraft("hermes_boots"),
    `Hermes'Boots`,
    100000,
    "Hunter","Engineering"
) {
    init {
        shape(
            "121",
            "343",
            "5 5"
        )
        setIngredient('1', Material.DIAMOND)
        setIngredient('2', Material.PLAYER_HEAD)
        setIngredient('3', Material.BLAZE_POWDER)
        setIngredient('4',Material.DIAMOND_BOOTS)
        setIngredient('5',Material.FEATHER)
    }
    object `Hermes'Boots` : Item(
        ItemStack(Material.DIAMOND_BOOTS)
    ) {
        init {
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2)
            addEnchantment(Enchantment.PROTECTION_FIRE,1)
            addEnchantment(Enchantment.DURABILITY,2)
        }
    }
}
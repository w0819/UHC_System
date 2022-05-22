package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object Ambrosia : ExtraUltimates(
    NamespacedKey.minecraft("ambrosia"),
    Ambrosia,
    175000,
    "Survivalism","Alchemy"
) {
    init {
        shape(
            "121",
            "343",
            "333"
        )
        setIngredient('1', Material.BLAZE_POWDER)
        setIngredient('2', Material.WITHER_SKELETON_SKULL)
        setIngredient('3', Material.GLOWSTONE)
        setIngredient('4', Material.GHAST_TEAR)
    }

    object Ambrosia : Item(ItemStack(Material.GLOWSTONE_DUST))
}
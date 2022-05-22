package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object Cornucopia : ExtraUltimates(
    NamespacedKey.minecraft("cornucopia"),
    Cornucopia,
    50000,
    "Cooking","Engineering"
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.CARROT)
        setIngredient('2',Material.GOLDEN_APPLE)
    }

    object Cornucopia : Item(
        ItemStack(Material.GOLDEN_CARROT)
    )
}
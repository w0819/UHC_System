package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Hunter
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object Saddle: Hunter(
    NamespacedKey.minecraft("saddle"),
    Saddle,
    3,
    true
) {
    init {
        shape(
            "111",
            "212",
            "3 3"
        )
        setIngredient('1', Material.LEATHER)
        setIngredient('2', Material.STRING)
        setIngredient('3', Material.IRON_INGOT)
    }
    object Saddle : Item(
        ItemStack(Material.SADDLE)
    )
}
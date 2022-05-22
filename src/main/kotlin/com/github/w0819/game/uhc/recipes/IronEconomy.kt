package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Engineering
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object IronEconomy : Engineering(
    NamespacedKey.minecraft("iron_economy"),
    IronEconomy,
    3,
    true
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.IRON_ORE)
        setIngredient('2', Material.COAL)
    }
    object IronEconomy : Item(
        ItemStack(Material.IRON_INGOT, 8)
    )
}
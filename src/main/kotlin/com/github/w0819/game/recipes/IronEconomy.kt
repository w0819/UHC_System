package com.github.w0819.game.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class IronEconomy : UHCRecipe(
    NamespacedKey.minecraft("iron_economy"),
    ItemStack(Material.IRON_INGOT, 8)
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
}
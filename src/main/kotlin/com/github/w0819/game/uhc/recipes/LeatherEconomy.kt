package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class LeatherEconomy : UHCRecipe(
    NamespacedKey.minecraft("leather_economy"),
    ItemStack(Material.LEATHER, 8)
) {
    init {
        shape(
            "121",
            "121",
            "121"
        )
        setIngredient('1', Material.STICK)
        setIngredient('2', Material.LEATHER)
    }
}
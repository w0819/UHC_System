package com.github.w0819.game.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class ArrowEconomy : UHCRecipe(
    NamespacedKey.minecraft("arrow_economy"),
    ItemStack(Material.ARROW, 20)
) {
    init {
        shape(
            "111",
            "222",
            "333"
        )
        setIngredient('1', Material.FLINT)
        setIngredient('2', Material.STICK)
        setIngredient('3', Material.FEATHER)
    }
}
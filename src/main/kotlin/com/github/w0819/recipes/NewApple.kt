package com.github.w0819.recipes

import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class NewApple : UHCRecipe(
    NamespacedKey.minecraft("new_apple"),
    ItemStack(Material.GOLDEN_APPLE, 2)
) {
    init {
        shape(
            " 1 ",
            "121",
            " 1 "
        )
        setIngredient('1', Material.GOLD_INGOT)
        setIngredient('2', Material.APPLE)
    }
}
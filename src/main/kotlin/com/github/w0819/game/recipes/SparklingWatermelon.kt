package com.github.w0819.game.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class SparklingWatermelon: UHCRecipe(
    NamespacedKey.minecraft("sparkling_watermelon"),
    ItemStack(Material.GLISTERING_MELON_SLICE)
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.IRON_INGOT)
        setIngredient('2', Material.MELON_SLICE)
    }
}
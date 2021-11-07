package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ApprenticeHelmet : UHCRecipe(
    NamespacedKey.minecraft("apprentice_helmet"),
    Item.apprentice_Helmet
) {
    init {
        shape(
            "111",
            "121",
            "   "
        )
        setIngredient('1', Material.IRON_INGOT)
        setIngredient('2', Material.REDSTONE_TORCH)
    }
}
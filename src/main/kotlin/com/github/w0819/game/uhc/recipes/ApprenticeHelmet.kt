package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
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
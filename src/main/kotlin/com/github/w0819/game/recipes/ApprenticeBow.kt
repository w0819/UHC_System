package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ApprenticeBow : UHCRecipe(
    NamespacedKey.minecraft("apprentice_bow"),
    Item.apprentice_Bow
) {
    init {
        shape(
            " 12",
            "1 2",
            " 12"
        )
        setIngredient('1', Material.REDSTONE_TORCH)
        setIngredient('2', Material.STRING)
    }
}
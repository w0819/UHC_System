package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.uhc.UHCRecipe
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
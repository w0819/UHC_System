package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class GoldenHead : UHCRecipe(
    NamespacedKey.minecraft("golden_head"),
    Item.golden_head
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.GOLD_INGOT)
        setIngredient('2', Material.PLAYER_HEAD)
    }
}
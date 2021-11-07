package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class NotchApple: UHCRecipe(
    NamespacedKey.minecraft("notch_apple"),
    Item.notch_apple
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.GOLD_INGOT)
        setIngredient('2', Material.APPLE)
    }
}
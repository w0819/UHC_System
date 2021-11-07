package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
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
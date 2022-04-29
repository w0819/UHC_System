package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.uhc.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Forge : UHCRecipe(
    NamespacedKey.minecraft("forge"),
    Item.Forge
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.COBBLESTONE)
        setIngredient('2',Material.COAL_BLOCK)
    }
}
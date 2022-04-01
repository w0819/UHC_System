package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Tarnhelm: UHCRecipe(
    NamespacedKey.minecraft("tarnhelm"),
    Item.tarnhelm
) {
    init {
        shape(
            "121",
            "131",
            "   "
        )
        setIngredient('1', Material.DIAMOND)
        setIngredient('2', Material.IRON_INGOT)
        setIngredient('3', Material.REDSTONE_BLOCK)
    }
}
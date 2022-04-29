package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.uhc.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class HermesBoots : UHCRecipe(
    NamespacedKey.minecraft("hermes_boots"),
    Item.HermesBoots
) {
    init {
        shape(
            "121",
            "343",
            "5 5"
        )
        setIngredient('1', Material.DIAMOND)
        setIngredient('2', Material.PLAYER_HEAD)
        setIngredient('3', Material.BLAZE_POWDER)
        setIngredient('4',Material.DIAMOND_BOOTS)
        setIngredient('5',Material.FEATHER)
    }
}
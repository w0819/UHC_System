package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Andūril : UHCRecipe(
    NamespacedKey.minecraft("anduril"),
    Item.Andūril
){
    init {
        shape(
            "121",
            "121",
            "131"
        )
        setIngredient('1', Material.FEATHER)
        setIngredient('2',Material.IRON_BLOCK)
        setIngredient('3',Material.BLAZE_ROD)
    }
}
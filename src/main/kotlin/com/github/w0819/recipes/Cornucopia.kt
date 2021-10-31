package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Cornucopia : UHCRecipe(
    NamespacedKey.minecraft("cornucopia"),
    Item.Cornucopia
){
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.CARROTS)
        setIngredient('2',Material.GOLDEN_APPLE)
    }
}
package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class HideOfLeviathan : UHCRecipe(
    NamespacedKey.minecraft("hide_of_leviathan"),
    Item.HideOfLeviathan
){
    init {
        shape(
            "121",
            "343",
            "5 5"
        )
        setIngredient('1', Material.LAPIS_BLOCK)
        setIngredient('2',Material.WATER_BUCKET)
        setIngredient('3',Material.DIAMOND)
        setIngredient('4',Material.DIAMOND_LEGGINGS)
        setIngredient('5',Material.LILY_PAD)
    }
}
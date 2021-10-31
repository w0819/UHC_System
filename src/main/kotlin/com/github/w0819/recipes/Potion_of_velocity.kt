package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Potion_of_velocity : UHCRecipe(
    NamespacedKey.minecraft("potion_of_velocity"),
    Item.Potion_of_velocity
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1',Material.BROWN_DYE)
        setIngredient('2',Material.SUGAR)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
}
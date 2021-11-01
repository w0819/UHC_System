package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class VorpalSword : UHCRecipe(
    NamespacedKey.minecraft("vorpal_sword"),
    Item.vorpal_sword
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.BONE)
        setIngredient('2',Material.IRON_SWORD)
        setIngredient('3',Material.ROTTEN_FLESH)
    }
}
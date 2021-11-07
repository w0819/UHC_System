package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class BarbarianChestplate : UHCRecipe(
    NamespacedKey.minecraft("barbarian_chestplate"),
    Item.Barbarian_Chestplate
){
    init {
        shape(
            "121",
            "343"
        )
        setIngredient('1', Material.BLAZE_ROD)
        setIngredient('2',Material.DIAMOND_CHESTPLATE)
        setIngredient('3',Material.IRON_BLOCK)
        setIngredient('4',Material.POTION)
    }
}
package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class chest_Of_Fate : UHCRecipe(
    NamespacedKey.minecraft("chest_of_fate"),
    Item.chest_of_fate
){
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.OAK_PLANKS)
        setIngredient('2',Material.PLAYER_HEAD)
    }
}
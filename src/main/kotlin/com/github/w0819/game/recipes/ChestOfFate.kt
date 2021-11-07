package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ChestOfFate : UHCRecipe(
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
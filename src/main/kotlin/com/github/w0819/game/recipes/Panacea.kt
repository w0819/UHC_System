package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Panacea : UHCRecipe(
    NamespacedKey.minecraft("panacea"),
    Item.panacea
){
    init {
        shape(
            "   ",
            "121",
            " 3 "
        )
        setIngredient('1',Material.PLAYER_HEAD)
        setIngredient('2',Material.GLISTERING_MELON_SLICE)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
}
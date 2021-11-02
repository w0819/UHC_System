package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class DeusExMachina : UHCRecipe(
    NamespacedKey.minecraft("deus_ex_machina"),
    Item.DeusExMachina
){
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.EMERALD)
        setIngredient('2',Material.PLAYER_HEAD)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
}
package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Essence_of_yggdrasil : UHCRecipe(
    NamespacedKey.minecraft("essence_of_yggdrasil"),
    Item.Essence_of_yggdrasil
){
    init {
        shape(
            "121",
            "343",
            "151"
        )
        setIngredient('1',Material.OAK_LEAVES)
        setIngredient('2',Material.ENCHANTING_TABLE)
        setIngredient('3',Material.GLOWSTONE)
        setIngredient('4',Material.GLASS_BOTTLE)
        setIngredient('5',Material.REDSTONE)
    }
}
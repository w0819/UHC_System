package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Bloodlust : UHCRecipe(
    NamespacedKey.minecraft("bloodlust"),
    Item.Bloodlust
){
    init {
        shape(
            "121",
            "131",
            "141"
        )
        setIngredient('1', Material.REDSTONE_BLOCK)
        setIngredient('2',Material.DIAMOND)
        setIngredient('3',Material.DIAMOND_SWORD)
        setIngredient('4',Material.EXPERIENCE_BOTTLE)
    }
}
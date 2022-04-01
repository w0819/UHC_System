package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class PotionofToughness : UHCRecipe(
    NamespacedKey.minecraft("potion_of_toughness"),
    Item.PotionofToughness
){
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.SLIME_BALL)
        setIngredient('2',Material.SNOW_BLOCK)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
}
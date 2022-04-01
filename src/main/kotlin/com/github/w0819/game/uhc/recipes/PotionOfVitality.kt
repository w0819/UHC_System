package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class PotionOfVitality : UHCRecipe(
    NamespacedKey.minecraft("potion_of_vitality"),
    Item.PotionOfVitality
){
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.PLAYER_HEAD)
        setIngredient('2',Material.NETHER_WART)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
}
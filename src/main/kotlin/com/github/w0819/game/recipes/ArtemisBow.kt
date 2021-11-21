package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ArtemisBow : UHCRecipe(
    NamespacedKey.minecraft("artemis_bow"),
    Item.Artemis_Bow
){
    init {
        shape(
            "121",
            "131",
            "141"
        )
        setIngredient('1', Material.FEATHER)
        setIngredient('2',Material.DIAMOND)
        setIngredient('3',Material.BOW)
        setIngredient('4',Material.ENDER_EYE)
    }
}
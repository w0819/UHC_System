package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Fenrir : UHCRecipe(
    NamespacedKey.minecraft("fenrir"),
    Item.Fenrir
){
    init {
        shape(
            "111",
            "232",
            "111"
        )
        setIngredient('1', Material.LEATHER)
        setIngredient('2',Material.BONE)
        setIngredient('3',Material.EXPERIENCE_BOTTLE)
    }
}
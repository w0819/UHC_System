package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class PotionOfVelocity : UHCRecipe(
    NamespacedKey.minecraft("potion_of_velocity"),
    Item.Potion_of_velocity
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1',Material.BROWN_DYE)
        setIngredient('2',Material.SUGAR)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
}
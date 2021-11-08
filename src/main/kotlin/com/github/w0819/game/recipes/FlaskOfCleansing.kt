package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class FlaskOfCleansing : UHCRecipe(
    NamespacedKey.minecraft("flask_of_cleansing"),
    Item.FlaskOfCleansing
){
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.ZOMBIE_HEAD)
        setIngredient('2',Material.MILK_BUCKET)
        setIngredient('3',Material.GLASS_BOTTLE)
    }
}
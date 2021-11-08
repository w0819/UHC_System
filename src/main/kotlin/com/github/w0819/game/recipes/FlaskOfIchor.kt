package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class FlaskOfIchor : UHCRecipe(
    NamespacedKey.minecraft("flask_of_ichor"),
    Item.FlaskOfIchor
){
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.PLAYER_HEAD)
        setIngredient('2',Material.BROWN_MUSHROOM)
        setIngredient('3',Material.GLASS_BOTTLE)
        setIngredient('4',Material.INK_SAC)
    }
}
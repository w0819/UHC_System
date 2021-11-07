package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class MasterCompass : UHCRecipe(
    NamespacedKey.minecraft("master_compass"),
    Item.Master_Compass
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.REDSTONE)
        setIngredient('2', Material.COMPASS)
    }
}
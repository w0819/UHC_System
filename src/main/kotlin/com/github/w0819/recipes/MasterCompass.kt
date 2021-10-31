package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
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
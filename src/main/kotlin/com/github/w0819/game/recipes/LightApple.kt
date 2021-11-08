package com.github.w0819.game.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class LightApple : UHCRecipe(
    NamespacedKey.minecraft("light_apple"),
    ItemStack(Material.GOLDEN_APPLE)
){
    init {
        shape(
            " 1 ",
            "121",
            " 1 "
        )
        setIngredient('1',Material.GOLD_INGOT)
        setIngredient('2',Material.APPLE)
    }
}
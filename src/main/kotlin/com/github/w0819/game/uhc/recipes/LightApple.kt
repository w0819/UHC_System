package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Cooking
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object LightApple : Cooking(
    NamespacedKey.minecraft("light_apple"),
    LightApple,
    1,
    true
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
    object LightApple : Item(
        ItemStack(Material.GOLDEN_APPLE)
    )
}
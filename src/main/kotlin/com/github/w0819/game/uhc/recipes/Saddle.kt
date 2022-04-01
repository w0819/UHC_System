package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class Saddle: UHCRecipe(
    NamespacedKey.minecraft("saddle"),
    ItemStack(Material.SADDLE, 1)
) {
    init {
        shape(
            "111",
            "212",
            "3 3"
        )
        setIngredient('1', Material.LEATHER)
        setIngredient('2', Material.STRING)
        setIngredient('3', Material.IRON_INGOT)
    }
}
package com.github.w0819.recipes

import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class LightAnvil: UHCRecipe(
    NamespacedKey.minecraft("light_anvil"),
    ItemStack(Material.ANVIL)
) {
    init {
        shape(
            "111",
            " 2 ",
            "111"
        )
        setIngredient('1', Material.IRON_INGOT)
        setIngredient('2', Material.IRON_BLOCK)
    }
}
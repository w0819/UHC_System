package com.github.w0819.recipes

import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class DustOfLight : UHCRecipe(
    NamespacedKey.minecraft("dust_of_light"),
    ItemStack(Material.GLOWSTONE_DUST)
){
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1',Material.REDSTONE)
        setIngredient('2',Material.FLINT_AND_STEEL)
    }
}
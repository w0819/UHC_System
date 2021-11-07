package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class PhilosopherPickaxe : UHCRecipe(
    NamespacedKey.minecraft("philosopher_pickaxe"),
    Item.Philosopher_Pickaxe
) {
    init {
        shape(
            "121",
            "343",
            " 4 "
        )
        setIngredient('1', Material.IRON_ORE)
        setIngredient('2', Material.GOLD_ORE)
        setIngredient('3', Material.LAPIS_LAZULI)
        setIngredient('4', Material.STICK)
    }
}
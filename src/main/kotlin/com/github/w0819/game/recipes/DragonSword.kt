package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class DragonSword: UHCRecipe(
    NamespacedKey.minecraft("dragon_sword"),
    Item.dragon_sword
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            "313"
        )
        setIngredient('1', Material.OBSIDIAN)
        setIngredient('2', Material.DIAMOND_SWORD)
        setIngredient('3', Material.BLAZE_POWDER)
    }
}
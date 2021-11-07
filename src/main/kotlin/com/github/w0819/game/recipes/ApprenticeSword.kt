package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ApprenticeSword: UHCRecipe(
    NamespacedKey.minecraft("apprentice_sword"),
    Item.apprentice_Sword
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 1 "
        )
        setIngredient('1', Material.REDSTONE_BLOCK)
        setIngredient('2', Material.IRON_SWORD)
    }
}
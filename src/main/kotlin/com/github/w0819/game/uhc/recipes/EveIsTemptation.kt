package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class EveIsTemptation : UHCRecipe(
    NamespacedKey.minecraft("eve_is_temptation"),
    ItemStack(Material.APPLE, 2)
) {
    init {
        shape(
            "   ",
            " 1 ",
            " 2 "
        )
        setIngredient('1', Material.BONE_MEAL)
        setIngredient('2', Material.APPLE)
    }
}
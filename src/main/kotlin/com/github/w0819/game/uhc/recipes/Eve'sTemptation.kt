package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Cooking
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object `Eve'sTemptation` : Cooking(
    NamespacedKey.minecraft("eve_is_temptation"),
    `Eve'sTemptation`,
    3,
    true
) {
    init {
        shape(
            "   ",
            " 1 ",
            " 2 "
        )
        setIngredient('1', Material.BONE_MEAL)
        setIngredient('2', Material.APPLE)
        System.`in`
    }
    object `Eve'sTemptation` : Item(
        ItemStack(Material.APPLE, 2)
    )
}
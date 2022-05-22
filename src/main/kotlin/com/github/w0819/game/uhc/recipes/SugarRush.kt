package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Invention
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object SugarRush: Invention(
    NamespacedKey.minecraft("sugar_rush"),
    SugarRush,
    3,
    true
) {
    init {
        shape(
            " 1 ",
            "232",
            "   "
        )
        setIngredient('1', Material.OAK_SAPLING)
        setIngredient('2', Material.WHEAT_SEEDS)
        setIngredient('3', Material.SUGAR)
    }
    object SugarRush : Item(
        ItemStack(Material.SUGAR,4)
    )
}
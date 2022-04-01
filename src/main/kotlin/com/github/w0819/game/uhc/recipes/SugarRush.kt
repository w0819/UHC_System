package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class SugarRush: UHCRecipe(
    NamespacedKey.minecraft("sugar_rush"),
    ItemStack(Material.SUGAR, 4)
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
}
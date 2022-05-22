package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Hunter
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object ArrowEconomy : Hunter(
    NamespacedKey.minecraft("arrow_economy"),
    ArrowEconomy,
    1,
    true
) {
    init {
        shape(
            "111",
            "222",
            "333"
        )
        setIngredient('1', Material.FLINT)
        setIngredient('2', Material.STICK)
        setIngredient('3', Material.FEATHER)
    }
    object  ArrowEconomy : Item(
        ItemStack(Material.ARROW,20)
    )
}
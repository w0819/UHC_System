package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ArmorSmithing
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object LeatherEconomy : ArmorSmithing(
    NamespacedKey.minecraft("leather_economy"),
    LeatherEconomy,
    3,
    true
) {
    init {
        shape(
            "121",
            "121",
            "121"
        )
        setIngredient('1', Material.STICK)
        setIngredient('2', Material.LEATHER)
    }
    object LeatherEconomy : Item(
        ItemStack(Material.LEATHER,8)
    )
}
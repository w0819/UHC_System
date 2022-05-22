package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ToolSmithing
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object Forge : ToolSmithing(
    NamespacedKey.minecraft("forge"),
    Forge,
    3,
    true
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.COBBLESTONE)
        setIngredient('2',Material.COAL_BLOCK)
    }
    object Forge : Item(
        ItemStack(Material.FURNACE)
    )
}
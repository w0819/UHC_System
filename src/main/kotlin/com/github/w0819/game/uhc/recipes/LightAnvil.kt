package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Engineering
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object LightAnvil: Engineering(
    NamespacedKey.minecraft("light_anvil"),
    LightAnvil,
    3,
    true
) {
    init {
        shape(
            "111",
            " 2 ",
            "111"
        )
        setIngredient('1', Material.IRON_INGOT)
        setIngredient('2', Material.IRON_BLOCK)
    }
    object LightAnvil : Item(
        ItemStack(Material.ANVIL)
    )
}
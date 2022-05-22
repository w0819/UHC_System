package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Apprentice
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object `Master'sCompass` : Apprentice(
    NamespacedKey.minecraft("master_compass"),
    `Master'sCompass`
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.REDSTONE)
        setIngredient('2', Material.COMPASS)
    }
    object `Master'sCompass` : Item(
        ItemStack(Material.COMPASS)
    )
}
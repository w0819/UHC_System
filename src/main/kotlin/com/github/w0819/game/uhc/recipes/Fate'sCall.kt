package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object `Fate'sCall`:  ExtraUltimates(
    NamespacedKey.minecraft("fate_s_call"),
    `Fate'sCall`,
    250000,
    "Strategist","Engineering"
) {
    init {
        shape(
            " 1 ",
            "121",
            " 1 "
        )
        setIngredient('1', Material.REDSTONE_LAMP)
        setIngredient('2', Material.FIREWORK_STAR)
    }
    object `Fate'sCall` : Item(
        ItemStack(Material.FLOWER_POT)
    )

}
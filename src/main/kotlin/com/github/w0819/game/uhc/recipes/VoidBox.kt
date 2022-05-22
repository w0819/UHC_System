package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object VoidBox :  ExtraUltimates(
    NamespacedKey.minecraft("void_box"),
    VoidBox,
    50000,
    "BloodCraft","Hunter"
) {
    init {
        shape(
            "121",
            "232",
            "121"
        )
        setIngredient('1', Material.OBSIDIAN)
        setIngredient('2',Material.GRASS)
        setIngredient('3',Material.PLAYER_HEAD)
    }

    object VoidBox : Item(
        ItemStack(Material.ENDER_CHEST,2)
    )
}
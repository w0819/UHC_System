package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Apprentice
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object ApprenticeBow : Apprentice(
    NamespacedKey.minecraft("apprentice_bow"),
    ApprenticeBow
) {
    init {
        shape(
            " 12",
            "1 2",
            " 12"
        )
        setIngredient('1', Material.REDSTONE_TORCH)
        setIngredient('2', Material.STRING)
    }
    object ApprenticeBow : Item(ItemStack(Material.BOW))
}
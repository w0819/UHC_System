package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Apprentice
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object ApprenticeSword: Apprentice(
    NamespacedKey.minecraft("apprentice_sword"),
    ApprenticeSword
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 1 "
        )
        setIngredient('1', Material.REDSTONE_BLOCK)
        setIngredient('2', Material.IRON_SWORD)
    }
    object ApprenticeSword : Item(
        ItemStack(Material.BOW)
    )
}
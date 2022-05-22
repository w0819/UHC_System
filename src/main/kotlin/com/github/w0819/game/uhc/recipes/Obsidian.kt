package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Engineering
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object Obsidian : Engineering(
    NamespacedKey.minecraft("obsidian"),
    Obsidian,
    3,
    true
){
    init {
        shape(
            "   ",
            " 1 ",
            " 2 "
        )
        setIngredient('1',Material.LAVA_BUCKET)
        setIngredient('2',Material.WATER_BUCKET)
    }
    object Obsidian : Item(
        ItemStack(Material.OBSIDIAN)
    )
}
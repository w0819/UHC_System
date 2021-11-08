package com.github.w0819.game.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class Obsidian : UHCRecipe(
    NamespacedKey.minecraft("obsidian"),
    ItemStack(Material.OBSIDIAN)
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
}
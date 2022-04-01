package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class BrewingArtifact : UHCRecipe(
    NamespacedKey.minecraft("brewing_artifact"),
    ItemStack(Material.NETHER_WART)
) {
    init {
        shape(
            " 1 ",
            "121",
            " 1 "
        )
        setIngredient('1', Material.WHEAT_SEEDS)
        setIngredient('2', Material.SPIDER_EYE)
    }
}
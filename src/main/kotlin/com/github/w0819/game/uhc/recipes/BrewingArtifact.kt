package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Alchemy
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object BrewingArtifact : Alchemy(
    NamespacedKey.minecraft("brewing_artifact"),
    BrewingArtifact,
    3,
    true
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
    object BrewingArtifact : Item(
        ItemStack(Material.NETHER_WART)
    )
}
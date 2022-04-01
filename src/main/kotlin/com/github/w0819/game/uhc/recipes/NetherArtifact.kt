package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class NetherArtifact : UHCRecipe(
    NamespacedKey.minecraft("nether_artifact"),
    ItemStack(Material.BLAZE_ROD)
) {
    init {
        shape(
            "121",
            "131",
            "121"
        )
        setIngredient('1', Material.ORANGE_STAINED_GLASS)
        setIngredient('2', Material.LAVA_BUCKET)
        setIngredient('3', Material.FIREWORK_ROCKET)
    }
}
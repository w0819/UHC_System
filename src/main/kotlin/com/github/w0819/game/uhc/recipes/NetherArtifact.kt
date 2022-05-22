package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Alchemy
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object NetherArtifact : Alchemy(
    NamespacedKey.minecraft("nether_artifact"),
    NetherArtifact,
    1,
    true
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
    object NetherArtifact : Item(
        ItemStack(Material.BLAZE_ROD)
    )
}
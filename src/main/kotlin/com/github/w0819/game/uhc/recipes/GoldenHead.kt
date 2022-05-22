package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.uhc.UHCRecipe
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object GoldenHead : UHCRecipe(
    NamespacedKey.minecraft("golden_head"),
    GoldenHead,
    3,
    true
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.GOLD_INGOT)
        setIngredient('2', Material.PLAYER_HEAD)
    }

    object GoldenHead : Item(
        ItemStack(Material.ENCHANTED_GOLDEN_APPLE),
        listOf(
            Component.text("")
        )
    )
}
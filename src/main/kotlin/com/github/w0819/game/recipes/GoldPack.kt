package com.github.w0819.game.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class GoldPack : UHCRecipe(
    NamespacedKey.minecraft("gold_pack"),
    ItemStack(Material.GOLD_INGOT, 8)
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.GOLD_ORE)
        setIngredient('2', Material.COAL)
    }
}
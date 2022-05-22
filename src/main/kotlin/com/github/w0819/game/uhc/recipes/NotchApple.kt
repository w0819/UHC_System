package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.uhc.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

// 1.9 이상에는 노치 사과가 없어서 추가 Professions 없음
object NotchApple: UHCRecipe(
    NamespacedKey.minecraft("notch_apple"),
    NotchApple,
    10000000,
    true
) {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.GOLD_BLOCK)
        setIngredient('2', Material.APPLE)
    }
    object NotchApple : Item(
        ItemStack(Material.ENCHANTED_GOLDEN_APPLE)
    )
}
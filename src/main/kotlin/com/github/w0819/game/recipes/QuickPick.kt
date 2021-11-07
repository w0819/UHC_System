package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class QuickPick: UHCRecipe(
    NamespacedKey.minecraft("quick_pick"),
    Item.quick_pick
) {
    init {
        shape(
            "111",
            "232",
            " 3 "
        )
        setIngredient('1', Material.IRON_ORE)
        setIngredient('2', Material.COAL)
        setIngredient('3', Material.STICK)
    }
}
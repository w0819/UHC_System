package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class LumberjackAxe : UHCRecipe(
    NamespacedKey.minecraft("lumberjack_axe"),
    Item.LumberjackAxe
) {
    init {
        shape(
            "112",
            "13 ",
            " 3 "
        )
        setIngredient('1', Material.IRON_INGOT)
        setIngredient('2', Material.FLINT)
        setIngredient('3', Material.STICK)
    }
}
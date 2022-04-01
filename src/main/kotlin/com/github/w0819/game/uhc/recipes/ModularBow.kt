package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ModularBow : UHCRecipe(
    NamespacedKey.minecraft("modular_bow"),
    Item.ModularBow
) {
    init {
        shape(
            " 1 ",
            "232",
            "454"
        )
        setIngredient('1', Material.CLOCK)
        setIngredient('2',Material.BLAZE_POWDER)
        setIngredient('3',Material.BOW)
        setIngredient('4',Material.SPIDER_EYE)
        setIngredient('5',Material.SLIME_BALL)
    }
}
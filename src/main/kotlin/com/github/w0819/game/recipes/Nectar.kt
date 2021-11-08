package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Nectar : UHCRecipe(
    NamespacedKey.minecraft("nectar"),
    Item.Nectar
){
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1',Material.EMERALD)
        setIngredient('2',Material.GOLD_INGOT)
        setIngredient('3',Material.MELON_SLICE)
        setIngredient('4',Material.GLASS_BOTTLE)
    }
}
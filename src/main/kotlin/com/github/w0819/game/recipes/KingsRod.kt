package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class KingsRod : UHCRecipe(
    NamespacedKey.minecraft("king_s_rod"),
    Item.King_s_Rod
){
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.FISHING_ROD)
        setIngredient('2',Material.LILY_PAD)
        setIngredient('3',Material.COMPASS)
        setIngredient('4',Material.WATER_BUCKET)
    }
}
package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class DeathScythe: UHCRecipe(
    NamespacedKey.minecraft("death_scythe"),
    Item.Death_Scythe
) {
    init {
        shape(
            " 11",
            " 23",
            " 2 "
        )
        setIngredient('1', Material.PLAYER_HEAD)
        setIngredient('2',Material.BONE)
        setIngredient('3',Material.CLOCK)
    }
}
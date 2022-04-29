package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.uhc.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class BackPack : UHCRecipe(
    NamespacedKey.minecraft("back_pack"),
    Item.backPack
) {
    init {
        shape(
            "121",
            "131",
            "121"
        )
        setIngredient('1', Material.STICK)
        setIngredient('2',Material.LEATHER)
        setIngredient('3',Material.CHEST)
    }
}
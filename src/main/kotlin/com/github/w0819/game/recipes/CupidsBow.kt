package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class CupidsBow : UHCRecipe(
    NamespacedKey.minecraft("cupid_s_bow"),
    Item.Cupid_s_Bow
) {
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.BLAZE_ROD)
        setIngredient('2',Material.PLAYER_HEAD)
        setIngredient('3',Material.BOW)
        setIngredient('4',Material.LAVA_BUCKET)
    }
}
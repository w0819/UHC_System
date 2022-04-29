package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.uhc.UHCRecipe
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
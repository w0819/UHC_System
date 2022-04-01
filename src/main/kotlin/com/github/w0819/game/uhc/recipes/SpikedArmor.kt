package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class SpikedArmor : UHCRecipe(
    NamespacedKey.minecraft("spiked_armor"),
    Item.spiked_armor
) {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1',Material.LILY_PAD)
        setIngredient('2',Material.CACTUS)
        setIngredient('3',Material.LEATHER_CHESTPLATE)
    }
}
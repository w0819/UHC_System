package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class spiked_armor : UHCRecipe(
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
package com.github.w0819.recipes

import com.github.w0819.Item
import com.github.w0819.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Shoes_of_Vidar: UHCRecipe(
    NamespacedKey.minecraft("shoes_of_vidar"),
    Item.Shoes_of_Vidar
) {
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.PUFFERFISH)
        setIngredient('2',Material.GLASS_BOTTLE)
        setIngredient('3',Material.DIAMOND_BOOTS)
        setIngredient('4',Material.FISHING_ROD)
    }
}
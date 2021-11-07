package com.github.w0819.game.recipes

import com.github.w0819.game.util.Item
import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ShoesOfVidar: UHCRecipe(
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
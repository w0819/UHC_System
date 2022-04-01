package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

class DeliciousMeal : UHCRecipe(
    NamespacedKey.minecraft("delicious_meal"),
    ItemStack(Material.COOKED_BEEF,10)
){
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1',Material.BEEF)
        setIngredient('2',Material.COAL)
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1',Material.CHICKEN)
        setIngredient('2',Material.COAL)
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1',Material.MUTTON)
        setIngredient('2',Material.COAL)
    }
}
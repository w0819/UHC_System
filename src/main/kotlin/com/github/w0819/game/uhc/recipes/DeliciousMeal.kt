package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Survivalism
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object DeliciousMeal : Survivalism(
    NamespacedKey.minecraft("delicious_meal"),
    DeliciousMeal,
    3,
    true
){
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1',Material.BEEF)
        setIngredient('1',Material.CHICKEN)
        setIngredient('1',Material.MUTTON)
        setIngredient('2',Material.COAL)
    }
    object DeliciousMeal : Item(
        ItemStack(Material.COOKED_BEEF,10)
    )
}
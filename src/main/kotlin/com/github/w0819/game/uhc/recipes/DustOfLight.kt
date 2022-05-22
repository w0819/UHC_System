package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.Alchemy
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object DustOfLight : Alchemy(
    NamespacedKey.minecraft("dust_of_light"),
    DustOfLight,
    3,
    true
){
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1',Material.REDSTONE)
        setIngredient('2',Material.FLINT_AND_STEEL)
    }
    object DustOfLight : Item(
        ItemStack(Material.REDSTONE,8)
    )
}
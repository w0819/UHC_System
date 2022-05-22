package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack

object Excalibur : ExtraUltimates(
    NamespacedKey.minecraft("excalibur"),
    Excalibur,
    150000,
    "WeaponSmithing","Alchemy"
) {
    init {
        shape(
            "121",
            "131",
            "141"
        )
        setIngredient('1', Material.SOUL_SAND)
        setIngredient('2',Material.FIRE_CHARGE)
        setIngredient('3',Material.TNT)
        setIngredient('4',Material.DIAMOND_SWORD)
    }

    object Excalibur : Item(
        ItemStack(Material.DIAMOND_SWORD),
        listOf(),
        20
    )
}
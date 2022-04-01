package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Excalibur : UHCRecipe(
    NamespacedKey.minecraft("excalibur"),
    Item.Excalibur
),ExtraUltimates {
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

    override fun needProfessions(): List<Professions> {
        return listOf(WeaponSmithing(),Alchemy())
    }

    override fun needCoin(): Int {
       return 150000
    }
}
package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Anduril : UHCRecipe(
    NamespacedKey.minecraft("anduril"),
    Item.Andūril
), ExtraUltimates {
    init {
        shape(
            "121",
            "121",
            "131"
        )
        setIngredient('1', Material.FEATHER)
        setIngredient('2',Material.IRON_BLOCK)
        setIngredient('3',Material.BLAZE_ROD)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Engineering(),WeaponSmithing())
    }

    override fun needCoin(): Int {
        return 150000
    }
}
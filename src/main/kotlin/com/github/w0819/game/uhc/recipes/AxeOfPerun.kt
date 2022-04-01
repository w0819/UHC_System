package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey

class AxeOfPerun : UHCRecipe(
    NamespacedKey.minecraft("axe_of_perun"),
    Item.AxeOfPerun
),ExtraUltimates{
    init {
        shape(
            "123",
            "14 ",
            " 4 "
        )
        setIngredient('1', Material.DIAMOND)
        setIngredient('2',Material.TNT)
        setIngredient('3',Material.FIRE_CHARGE)
        setIngredient('4',Material.STICK)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Enchanting(),WeaponSmithing())
    }

    override fun needCoin(): Int {
        return 150000
    }
}
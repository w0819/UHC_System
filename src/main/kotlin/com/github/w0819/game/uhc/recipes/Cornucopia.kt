package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Cornucopia : UHCRecipe(
    NamespacedKey.minecraft("cornucopia"),
    Item.Cornucopia
), ExtraUltimates {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.CARROT)
        setIngredient('2',Material.GOLDEN_APPLE)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Cooking(),Engineering())
    }

    override fun needCoin(): Int {
        return 50000
    }
}
package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import org.bukkit.Material
import org.bukkit.NamespacedKey

class FatesCall: UHCRecipe(
    NamespacedKey.minecraft("fate_s_call"),
    Item.FateSCall
), ExtraUltimates {
    init {
        shape(
            " 1 ",
            "121",
            " 1 "
        )
        setIngredient('1', Material.REDSTONE_LAMP)
        setIngredient('2', Material.FIREWORK_STAR)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Strategist(), Engineering())
    }

    override fun needCoin(): Int {
        return 250000
    }


}
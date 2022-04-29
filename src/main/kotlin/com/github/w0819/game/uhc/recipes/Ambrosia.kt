package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Ambrosia : UHCRecipe(
    NamespacedKey.minecraft("ambrosia"),
    Item.Ambrosia
), ExtraUltimates {
    init {
        shape(
            "121",
            "343",
            "333"
        )
        setIngredient('1', Material.BLAZE_POWDER)
        setIngredient('2',Material.WITHER_SKELETON_SKULL)
        setIngredient('3',Material.GLOWSTONE)
        setIngredient('4',Material.GHAST_TEAR)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Survivalism(),Alchemy())
    }

    override fun needCoin(): Int {
        return 100000
    }
}
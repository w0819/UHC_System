package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ChestOfFate : UHCRecipe(
    NamespacedKey.minecraft("chest_of_fate"),
    Item.chest_of_fate
), ExtraUltimates {
    init {
        shape(
            "111",
            "121",
            "111"
        )
        setIngredient('1', Material.OAK_PLANKS)
        setIngredient('2',Material.PLAYER_HEAD)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(BloodCraft(),Engineering())
    }

    override fun needCoin(): Int {
        return 75000
    }
}
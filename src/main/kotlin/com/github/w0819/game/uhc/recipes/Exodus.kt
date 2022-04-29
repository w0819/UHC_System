package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Exodus : UHCRecipe(
    NamespacedKey.minecraft("exodus"),
    Item.Exodus
), ExtraUltimates {
    init {
        shape(
            "111",
            "121",
            "343"
        )
        setIngredient('1', Material.DIAMOND)
        setIngredient('2',Material.PLAYER_HEAD)
        setIngredient('3',Material.EMERALD)
        setIngredient('4',Material.GOLDEN_CARROT)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Engineering(),BloodCraft(),Cooking(),ArmorSmithing())
    }

    override fun needCoin(): Int {
        return 350000
    }
}
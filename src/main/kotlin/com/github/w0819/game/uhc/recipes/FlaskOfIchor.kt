package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class FlaskOfIchor : UHCRecipe(
    NamespacedKey.minecraft("flask_of_ichor"),
    Item.FlaskOfIchor
), ExtraUltimates {
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.PLAYER_HEAD)
        setIngredient('2',Material.BROWN_MUSHROOM)
        setIngredient('3',Material.GLASS_BOTTLE)
        setIngredient('4',Material.INK_SAC)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Alchemy(),BloodCraft())
    }

    override fun needCoin(): Int {
        return 120000
    }
}
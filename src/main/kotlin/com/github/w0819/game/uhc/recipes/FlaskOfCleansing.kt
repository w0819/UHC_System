package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class FlaskOfCleansing : UHCRecipe(
    NamespacedKey.minecraft("flask_of_cleansing"),
    Item.FlaskOfCleansing
), ExtraUltimates {
    init {
        shape(
            " 1 ",
            " 2 ",
            " 3 "
        )
        setIngredient('1', Material.ZOMBIE_HEAD)
        setIngredient('2',Material.MILK_BUCKET)
        setIngredient('3',Material.GLASS_BOTTLE)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Hunter(),Engineering())
    }

    override fun needCoin(): Int {
        return 1000000
    }
}
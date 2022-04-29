package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Bloodlust : UHCRecipe(
    NamespacedKey.minecraft("bloodlust"),
    Item.Bloodlust
), ExtraUltimates {
    init {
        shape(
            "121",
            "131",
            "141"
        )
        setIngredient('1', Material.REDSTONE_BLOCK)
        setIngredient('2',Material.DIAMOND)
        setIngredient('3',Material.DIAMOND_SWORD)
        setIngredient('4',Material.EXPERIENCE_BOTTLE)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(BloodCraft(),Invention())
    }

    override fun needCoin(): Int {
        return 100000
    }

}
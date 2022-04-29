package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class VoidBox : UHCRecipe(
    NamespacedKey.minecraft("void_box"),
    Item.VoidBox
), ExtraUltimates {
    init {
        shape(
            "121",
            "232",
            "121"
        )
        setIngredient('1', Material.OBSIDIAN)
        setIngredient('2',Material.GRASS)
        setIngredient('3',Material.PLAYER_HEAD)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(BloodCraft(),Hunter())
    }

    override fun needCoin(): Int {
        return 50000
    }
}
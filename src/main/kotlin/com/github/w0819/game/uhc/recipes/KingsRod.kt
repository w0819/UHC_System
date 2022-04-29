package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class KingsRod : UHCRecipe(
    NamespacedKey.minecraft("king_s_rod"),
    Item.King_s_Rod
), ExtraUltimates {
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.FISHING_ROD)
        setIngredient('2',Material.LILY_PAD)
        setIngredient('3',Material.COMPASS)
        setIngredient('4',Material.WATER_BUCKET)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Survivalism(),Enchanting())
    }

    override fun needCoin(): Int {
        return 50000
    }
}
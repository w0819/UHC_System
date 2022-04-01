package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ExpertSeal : UHCRecipe(
    NamespacedKey.minecraft("expert_seal"),
    Item.ExpertSeal
),ExtraUltimates{
    init {
        shape(
            "121",
            "343",
            "121"
        )
        setIngredient('1', Material.EXPERIENCE_BOTTLE)
        setIngredient('2',Material.IRON_BLOCK)
        setIngredient('3',Material.GOLD_BLOCK)
        setIngredient('4',Material.DIAMOND_BLOCK)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Engineering(),Invention())
    }

    override fun needCoin(): Int {
        return 200000
    }
}
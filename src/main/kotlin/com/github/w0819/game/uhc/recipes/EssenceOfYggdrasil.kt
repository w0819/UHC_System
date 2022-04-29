package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import com.github.w0819.game.util.uhc.UHCRecipe
import com.github.w0819.game.util.ExtraUltimates
import org.bukkit.Material
import org.bukkit.NamespacedKey

class EssenceOfYggdrasil : UHCRecipe(
    NamespacedKey.minecraft("essence_of_yggdrasil"),
    Item.Essence_of_yggdrasil
), ExtraUltimates {
    init {
        shape(
            "121",
            "343",
            "151"
        )
        setIngredient('1',Material.OAK_LEAVES)
        setIngredient('2',Material.ENCHANTING_TABLE)
        setIngredient('3',Material.GLOWSTONE)
        setIngredient('4',Material.GLASS_BOTTLE)
        setIngredient('5',Material.REDSTONE)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Enchanting(),Alchemy())
    }

    override fun needCoin(): Int {
        return 75000
    }
}
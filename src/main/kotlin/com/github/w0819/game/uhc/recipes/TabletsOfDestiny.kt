package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey

class TabletsOfDestiny : UHCRecipe(
    NamespacedKey.minecraft("tablets_of_destiny"),
    Item.tabletsOfDestiny
),ExtraUltimates {
    init {
        shape(
            " 1 ",
            "234",
            "555"
        )
        setIngredient('1', Material.MAGMA_CREAM)
        setIngredient('2',Material.DIAMOND_SWORD)
        setIngredient('3',Material.WRITABLE_BOOK)
        setIngredient('4',Material.BOW)
        setIngredient('5',Material.EXPERIENCE_BOTTLE)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Engineering(),Enchanting())
    }

    override fun needCoin(): Int {
        return 250000
    }
}
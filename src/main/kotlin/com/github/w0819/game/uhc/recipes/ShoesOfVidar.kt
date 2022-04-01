package com.github.w0819.game.uhc.recipes

import com.github.w0819.game.util.*
import org.bukkit.Material
import org.bukkit.NamespacedKey

class ShoesOfVidar: UHCRecipe(
    NamespacedKey.minecraft("shoes_of_vidar"),
    Item.Shoes_of_Vidar
),ExtraUltimates {
    init {
        shape(
            " 1 ",
            "232",
            " 4 "
        )
        setIngredient('1', Material.PUFFERFISH)
        setIngredient('2',Material.GLASS_BOTTLE)
        setIngredient('3',Material.DIAMOND_BOOTS)
        setIngredient('4',Material.FISHING_ROD)
    }

    override fun needProfessions(): List<Professions> {
        return listOf(Enchanting(),Engineering(),Survivalism())
    }

    override fun needCoin(): Int {
        return 150000
    }
}